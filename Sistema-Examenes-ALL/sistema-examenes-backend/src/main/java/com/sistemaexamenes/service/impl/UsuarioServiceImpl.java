package com.sistemaexamenes.service.impl;

import com.sistemaexamenes.model.Usuario;
import com.sistemaexamenes.model.UsuarioRol;
import com.sistemaexamenes.repository.RolRepository;
import com.sistemaexamenes.repository.UsuarioRepository;
import com.sistemaexamenes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;
    @Override
    public Usuario guardarusuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
       Usuario usuario1=usuarioRepository.findByUsername(usuario.getUsername());
       if (usuario1 != null){
    throw new Exception("El usuario ya exite");
       }else {
           for (UsuarioRol usuarioRol: usuarioRoles){
               rolRepository.save(usuarioRol.getRol());
           }
           usuario.getUsuarioRoles().addAll(usuarioRoles);
           usuario1=usuarioRepository.save(usuario);

       }

        return usuario1;
    }

    @Override
    public Usuario obtenerusuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
       usuarioRepository.deleteById(usuarioId);
    }
}
