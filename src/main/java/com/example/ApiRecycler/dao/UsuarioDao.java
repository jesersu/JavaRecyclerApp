package com.example.ApiRecycler.dao;

import com.example.ApiRecycler.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void regsitrar(Usuario usuario);

    Usuario verificarEmailPassword(Usuario usuario);
}
