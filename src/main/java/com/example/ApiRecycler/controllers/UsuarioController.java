package com.example.ApiRecycler.controllers;

import com.example.ApiRecycler.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario prueba(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Jesus");
        usuario.setApellido("Chapi");
        usuario.setEmail("jeseru@gmail.com");
        usuario.setPassword("asdfasdf");
        usuario.setTelefono("98653214732");

        return usuario;
    }
}
