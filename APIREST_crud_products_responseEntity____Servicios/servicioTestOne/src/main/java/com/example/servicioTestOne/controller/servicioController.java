package com.example.servicioTestOne.controller;

import com.example.servicioTestOne.model.Servicio;
import com.example.servicioTestOne.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class servicioController {

    @Autowired
    private ServicioService servicio;

    @GetMapping("/servicios")
    public List<Servicio>listarServicios(){
        return servicio.listarTodos();
    }

    @PostMapping("/servicios")
    public void crearService(@RequestBody Servicio ser){
        servicio.crearServicio(ser);
    }

    @GetMapping("/servicios/{id}")
    public Servicio listarByParameter( @PathVariable long id ){
        Servicio serv= servicio.buscarById(id);
        return serv;
    }
   @PutMapping("/servicios/{id}")
//
//    public Servicio updatePerson(@PathVariable Long id ,@RequestBody Servicio serv) {
//      servicio.crearServicio(serv);
//        return serv;
//    }
    public Servicio actualizarServicio(@RequestBody Servicio serv, @PathVariable Long id){
        Servicio servicioParaUpdate =servicio.buscarById(id);
        servicioParaUpdate.getId();
        servicioParaUpdate.setNombre(serv.getNombre());
        servicioParaUpdate.setDescripcion(serv.getDescripcion());

        servicio.crearServicio(servicioParaUpdate);
        return serv;

}

    @DeleteMapping("/servicios")
    public void eliminarservice(@PathVariable Long id){
servicio.eliminarServicio(id);
    }
}
