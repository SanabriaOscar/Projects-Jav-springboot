package com.example.TesisGLobant.controlller;

import com.example.TesisGLobant.model.Usuario;
import com.example.TesisGLobant.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
  UsuarioService usuarioService;
    //@GetMapping("/")
    @RequestMapping("/")
    public  String verPaginaDeInicio(Model model , @Param("palabraClave")String palabraClave){
  //      String palabraClave ="oscar";
        List<Usuario>listaUsuarios= usuarioService.listAll(palabraClave);
        model.addAttribute("listaUsuarios", listaUsuarios);
        model.addAttribute("palabraClave", palabraClave);
        return "index";
    }
 @GetMapping("/nuevo")
    //@RequestMapping("/nuevo")
    public String MostrarFormDeRegistro(Model model){
      Usuario usuario =new Usuario();
        model.addAttribute("usuario", usuario);
        return "nuevo_usuario";
    }

//@PostMapping("guardar")
@RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario){
    usuarioService.registerUser(usuario);
    return "redirect:/";
}

//@GetMapping("editar/{id}")
@RequestMapping("/editar/{id}")
public ModelAndView MostrarFormDeEditar(@PathVariable(name = "id")Long id){
    ModelAndView modelo =new ModelAndView("editar_usuario");
    Usuario usuario= usuarioService.ListOne(id);
    modelo.addObject("usuario", usuario);
    return modelo;
}
    //@DeleteMapping("/eliminar/{id}")
    @RequestMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable(name="id") Long id){
        usuarioService.deleteUser(id);
        return "redirect:/";
    }
}
