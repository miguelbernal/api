package com.softwareynegocios.api.rest;

import java.util.List;
import java.util.Optional;

import com.softwareynegocios.api.model.Rubros;
import com.softwareynegocios.api.repo.IRubrosRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rubros")
public class RubrosRestController {
    @Autowired
    private IRubrosRepo repo;

    @GetMapping(value = "/{id}")
    public Optional<Rubros> findOne(@PathVariable("id") final Integer id) {
        return repo.findById(id);
    }

    @GetMapping
    public List<Rubros> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Rubros insert(@RequestBody final Rubros rubros) {
        return repo.save(rubros);
    }

    @PutMapping
    public Rubros update(@RequestBody final Rubros rubros) {
        return repo.save(rubros);
    }

    @DeleteMapping(value = "/{id}")
    public Optional<Rubros> delete(@PathVariable("id") final Integer id) {
        final Optional<Rubros> rubro = repo.findById(id);
        repo.deleteById(id);
        return rubro;
    }

    @GetMapping(value = "/filtrar/{texto}/{pagina}")
    public List<Rubros> findOptional(@PathVariable("texto") String texto, @PathVariable("pagina") int pagina) {
        if (texto.equals(" ")) {
            texto = "";
        }
        int limit = 10;
        int offset = (pagina - 1) * limit;
        return repo.findByFilter(texto.toUpperCase(), limit, offset);
    }
}
