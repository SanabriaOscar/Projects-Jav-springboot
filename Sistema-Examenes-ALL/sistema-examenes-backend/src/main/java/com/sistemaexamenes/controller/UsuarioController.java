package com.sistemaexamenes.controller;

import com.sistemaexamenes.model.Rol;
import com.sistemaexamenes.model.Usuario;
import com.sistemaexamenes.model.UsuarioRol;
import com.sistemaexamenes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public Usuario saveUsuarioC(@RequestBody Usuario usuario)throws Exception{
        Set<UsuarioRol> roles=new HashSet<>();
        Rol rol =new Rol();
        rol.setRolId(1L);
        rol.setNombre("NORMAL");
        UsuarioRol usuarioRol=new UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuario(usuario);
        return usuarioService.guardarusuario(usuario,roles);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuarioC(@PathVariable("username") String username){
        return usuarioService.obtenerusuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public  void eliminarUsuarioC(@PathVariable("usuarioId")Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }



}
