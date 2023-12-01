package com.didenko.starcruises.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
}
