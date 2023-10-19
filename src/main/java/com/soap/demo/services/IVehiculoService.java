package com.soap.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.soap.demo.entity.Vehiculo;


@Service
public interface IVehiculoService  {
	
	public Optional<Vehiculo> buscarPorPlaca(String placa);

}
