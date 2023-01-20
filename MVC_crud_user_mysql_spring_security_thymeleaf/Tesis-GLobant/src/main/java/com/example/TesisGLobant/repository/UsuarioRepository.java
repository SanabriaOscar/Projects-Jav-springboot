package com.example.TesisGLobant.repository;

import com.example.TesisGLobant.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT p FROM Usuario p WHERE p.nombre LIKE %?1%" +
            "OR p.apellido LIKE %?1% " +
            "OR p.email LIKE %?1% ")


    public List<Usuario> findAll(String palabraClave);
}
