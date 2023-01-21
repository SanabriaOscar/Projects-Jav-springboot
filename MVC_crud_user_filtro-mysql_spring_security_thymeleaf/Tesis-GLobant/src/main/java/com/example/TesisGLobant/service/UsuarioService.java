package com.example.TesisGLobant.service;

import com.example.TesisGLobant.model.Usuario;
import com.example.TesisGLobant.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.UniqueConstraint;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario>listAll(String palabraClave){
        if(palabraClave !=null){
            return usuarioRepository.findAll(palabraClave);
        }
        return  usuarioRepository.findAll();
    }

    public void registerUser(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario ListOne(Long id){
        return usuarioRepository.findById(id).get();
    }

    public void  deleteUser(Long id){
        usuarioRepository.deleteById(id);
    }

}
