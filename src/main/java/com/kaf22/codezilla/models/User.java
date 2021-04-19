package com.kaf22.codezilla.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id_user")
    private String chatIdUser;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private String username;

}
