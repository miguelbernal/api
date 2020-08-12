package com.softwareynegocios.api.repo;

import java.util.Optional;

import com.softwareynegocios.api.model.Usuarioapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioappRepo extends JpaRepository<Usuarioapp, Integer>{

    @Query(value = "SELECT * FROM usuarioapp u WHERE u.nombreusuario = ?1 AND u.password = ?2",
    nativeQuery=true)
    public Optional<Usuarioapp> findByUsuarioAndClave(String nombreusuario, String password);

    @Query(value = "SELECT * FROM usuarioapp u WHERE UPPER(u.nombreusuario) like %?1% LIMIT ?2 OFFSET ?3",
    nativeQuery=true)
    public List<Usuarioapp> findByFilter(String texto, int limit, int offset);
}