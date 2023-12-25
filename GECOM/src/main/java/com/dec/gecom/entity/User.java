package com.dec.gecom.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "e_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name ="password" )
    private String password;

    @Column(name = "email")
    private String email;
}
