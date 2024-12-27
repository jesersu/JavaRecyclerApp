package com.example.ApiRecycler.controllers;

import com.example.ApiRecycler.dao.UsuarioDao;
import com.example.ApiRecycler.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(10, 1024, 1, usuario.getPassword().toCharArray());
        usuario.setPassword(hash);
        usuarioDao.regsitrar(usuario);
    }
}
