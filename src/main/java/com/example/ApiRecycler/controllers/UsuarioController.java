package com.example.ApiRecycler.controllers;

import com.example.ApiRecycler.dao.UsuarioDao;
import com.example.ApiRecycler.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Jesus");
        usuario.setApellido("Chapi");
        usuario.setEmail("jeseru@gmail.com");
        usuario.setPassword("asdfasdf");
        usuario.setTelefono("98653214732");

        return usuario;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsarios() {
       return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        usuarioDao.eliminar(id);
    }
}
