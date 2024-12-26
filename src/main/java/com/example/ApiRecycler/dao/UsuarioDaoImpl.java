package com.example.ApiRecycler.dao;

import com.example.ApiRecycler.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String sql = "SELECT u FROM Usuario u";
        return entityManager.createQuery(sql, Usuario.class).getResultList();

    }

    @Override
    public void eliminar(Long id) {
        entityManager.remove(entityManager.find(Usuario.class, id));
    }
}
