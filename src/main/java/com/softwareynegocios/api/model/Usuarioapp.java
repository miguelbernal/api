package com.softwareynegocios.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuarioapp {
    @Id
    @Column(name = "codusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("codusuario")
    private int codusuario;

    @Column(name = "nombreusuario", length = 30)
    @JsonProperty("nombreusuario")
     private String nombreusuario;

    @Column(name = "mail", length = 80)
    @JsonProperty("mail")
    private String mail;

    @Column(name = "password", length = 20)
    @JsonProperty("password")
    private String password;
}



  
    