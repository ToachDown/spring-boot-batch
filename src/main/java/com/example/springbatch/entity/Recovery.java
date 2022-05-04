package com.example.springbatch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Recovery {

    @Id
    @GeneratedValue
    private Long id;
    private String identifier;
    private String loginEmail;
    private String oneTimePassword;
    private String recoveryCode;
    private String firstName;
    private String lastName;
    private String department;
    private String location;

}
