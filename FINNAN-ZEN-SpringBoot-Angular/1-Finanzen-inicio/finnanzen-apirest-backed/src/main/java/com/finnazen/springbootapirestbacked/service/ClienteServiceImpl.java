package com.finnazen.springbootapirestbacked.service;

import com.finnazen.springbootapirestbacked.model.Cliente;
import com.finnazen.springbootapirestbacked.model.Region;
import com.finnazen.springbootapirestbacked.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
            clienteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Region> findAllRegiones() {
        return clienteRepository.findAllRegiones();
    }
}
