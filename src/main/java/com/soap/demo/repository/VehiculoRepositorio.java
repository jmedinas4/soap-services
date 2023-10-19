package com.soap.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soap.demo.entity.Vehiculo;

@Repository
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, String> {
    
}

