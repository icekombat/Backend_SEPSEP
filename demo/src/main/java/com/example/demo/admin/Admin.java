package com.example.demo.admin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vorname")
    @Setter
    private String vorname;
    @Column(name = "nachname")
    @Setter
    private String nachname;
    @Column(name = "email")
    @Setter
    private String email;
    @Column(name = "passwort")
    @Setter
    private String passwort;

}
