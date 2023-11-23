package com.finnazen.springbootapirestbacked.repository;

import com.finnazen.springbootapirestbacked.model.Cliente;
import com.finnazen.springbootapirestbacked.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
 @Query("from Region ")
    public List<Region>findAllRegiones();
}
