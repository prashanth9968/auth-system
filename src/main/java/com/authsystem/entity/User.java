package com.authsystem.entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class User {
@Id @GeneratedValue
private Long id;
private String email;
private String password;
private String name;
}