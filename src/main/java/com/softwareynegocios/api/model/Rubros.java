package com.softwareynegocios.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rubros{
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("codigo")
    private int codigo;

    @Column(name = "nombre", length = 40)
    @JsonProperty("nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name="familia", referencedColumnName = "codigo", insertable = false, updatable = false) 
    @JsonProperty("familia")
    private Familias familia;

}



  
    