package com.DataScienceUATest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "fio", schema = "public")
public class Fio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Override
    public String toString() {
        return "{" +
                    "\"id\":" + id + "," +
                    "\"name\": \"" + name + "\"," +
                    "\"surname\": \"" + surname + "\"" +
                "}";
    }
}
