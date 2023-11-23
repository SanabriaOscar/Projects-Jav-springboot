package com.finnazen.springbootapirestbacked.service;

import com.finnazen.springbootapirestbacked.model.Cliente;
import com.finnazen.springbootapirestbacked.model.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {
    public List<Cliente>findAll();
    public Page<Cliente> findAll(Pageable pageable);
    public Cliente save(Cliente cliente);
    public Cliente findById(Long id);
    public void delete(Long id);
    public List<Region>findAllRegiones();


}
