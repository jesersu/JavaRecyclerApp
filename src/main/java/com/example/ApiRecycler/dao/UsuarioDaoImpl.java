package com.example.ApiRecycler.dao;

import com.example.ApiRecycler.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public void regsitrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario verificarEmailPassword(Usuario usuario) {
        String query = "FROM Usuario u WHERE u.email = :email";
        List<Usuario> lista;
        lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()){
            return null;
        }
        String passwordHashed = lista.getFirst().getPassword();       Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword().toCharArray())){
            return lista.getFirst();
        };
        return null;
    }
}
