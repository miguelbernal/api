package com.softwareynegocios.api.rest;

import java.util.List;
import java.util.Optional;

import com.softwareynegocios.api.model.Usuarioapp;
import com.softwareynegocios.api.repo.IUsuarioappRepo;

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
@RequestMapping("/api/usuarioapp")
public class UsuarioappRestController {
    @Autowired
    private IUsuarioappRepo repo;

    @GetMapping(value = "/{id}")
    public Optional<Usuarioapp> findOne(@PathVariable("id") final Integer id) {
        return repo.findById(id);
    }

    @GetMapping
    public List<Usuarioapp> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Usuarioapp insert(@RequestBody final Usuarioapp usuarioapp) {
        return repo.save(usuarioapp);
    }

    @PutMapping
    public Usuarioapp update(@RequestBody final Usuarioapp usuarioapp) {
        return repo.save(usuarioapp);
    }

    @DeleteMapping(value = "/{id}")
    public Optional<Usuarioapp> delete(@PathVariable("id") final Integer id) {
        final Optional<Usuarioapp> usuario = repo.findById(id);
        repo.deleteById(id);
        return usuario;
    }

    @GetMapping(value = "/{nombreusuario}/{password}")
    public Optional<Usuarioapp> findOptional(@PathVariable("nombreusuario") final String nombreusuario,
            @PathVariable("password") final String password) {
        System.out.println("***************************" + nombreusuario + " - " + password);
        return repo.findByUsuarioAndClave(nombreusuario, password);
    }

    @GetMapping(value = "/filtrar/{texto}/{pagina}")
    public List<Usuarioapp> findOptional(@PathVariable("texto") String texto, @PathVariable("pagina") int pagina) {
        System.out.println("***************************" + texto + " - " + pagina);
        // 1-1 = 0 * 10 = 0
        // 2-1 = 1 * 10 = 10
        // 3-1 = 2 * 10 = 20
        if (texto.equals(" ")) {
            texto = "";
        }
        int limit = 10;
        int offset = (pagina - 1) * limit;
        return repo.findByFilter(texto.toUpperCase(), limit, offset);
    }
}
