package com.didenko.starcruises.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.*;

@EqualsAndHashCode(exclude = "client")
@ToString(exclude = "client")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "document")
public class ClientDocument {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String name;

    @Enumerated(EnumType.STRING)
    private ClientDocumentState state;

    public void setClient(Client client) {
        this.client = client;
        client.addDocument(this);
    }
}
