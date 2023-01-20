package com.example.servicioTestOne.service;

import com.example.servicioTestOne.model.Servicio;
import com.example.servicioTestOne.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio>listarTodos(){
        return servicioRepository.findAll();
    }

    public void crearServicio(Servicio servicio){
        servicioRepository.save(servicio);

    }



    public Servicio buscarById(Long id){
        return servicioRepository.findById(id).get();

    }
    public  void eliminarServicio(Long id){
        servicioRepository.deleteById(id);
    }
}
