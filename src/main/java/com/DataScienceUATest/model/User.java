package com.DataScienceUATest.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fioid", referencedColumnName = "id")
    private Fio fio;

    @Email
    @Column(name = "email")
    private String email;

    @Past(message = "The birthdate can not be in the past")
    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "gender")
    private String gender;

    @Override
    public String toString() {
        return "{" +
                    "\"id\":" + id + ",\n" +
                    "\"username\":\""+ username +"\"," +
                    "\"fio\":" +
                            fio.toString() +
                    "," +
                    "\"email\":\"" + email + "\"," +
                    "\"birthdate\":\"" + birthdate + "\"," +
                    "\"gender\":\"" + gender + "\"" +
               "}";
    }
}
