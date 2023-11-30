package com.didenko.starcruises.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client extends User{

    @Id
    private Long id;

    @OneToOne
    private User user;

    private String firstname;

    private String lastname;

    @Column(name = "birth_date")
    private LocalDate birthdate;
}
