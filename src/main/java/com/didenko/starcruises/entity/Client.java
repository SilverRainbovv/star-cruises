package com.didenko.starcruises.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@ToString(exclude = {"documents"})
@EqualsAndHashCode(exclude = {"documents"})
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @MapsId
    @JoinColumn(name = "user_id")
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    private String firstname;

    private String lastname;

    @Column(name = "birth_date")
    private LocalDate birthdate;

    public void setUser(User user) {
        this.user = user;
    }


    @OneToMany(mappedBy = "client",  fetch = FetchType.LAZY, cascade = {PERSIST, MERGE, REFRESH})
    @Builder.Default
    private List<ClientDocument> documents = new ArrayList<>();

    public void addDocument(ClientDocument document){
        documents.add(document);
    }

    public void removeAll(List<ClientDocument> toBeRemovedDocuments) {documents.removeAll(toBeRemovedDocuments);}
}
