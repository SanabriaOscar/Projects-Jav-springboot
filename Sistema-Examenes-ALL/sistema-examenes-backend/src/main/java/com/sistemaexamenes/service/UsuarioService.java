package com.sistemaexamenes.service;

import com.sistemaexamenes.model.Usuario;
import com.sistemaexamenes.model.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarusuario(Usuario usuario, Set<UsuarioRol> usuarioRoles )throws Exception;
    public Usuario obtenerusuario(String username);
    public void eliminarUsuario(Long usuarioId);
}
