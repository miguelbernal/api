package com.softwareynegocios.api.repo;

import com.softwareynegocios.api.model.Rubros;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRubrosRepo extends JpaRepository<Rubros, Integer>{

    @Query(value = "SELECT * FROM rubros r WHERE UPPER(r.nombre) like %?1% LIMIT ?2 OFFSET ?3",
    nativeQuery=true)
    public List<Rubros> findByFilter(String texto, int limit, int offset);
}