package com.example.demo.testing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
public class TestObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TestID")
    @Getter
    private Long TestID;

    @Column(name = "text")
    @Getter
    @Setter
    private String text;
}
