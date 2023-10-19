package com.soap.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soap.demo.entity.Vehiculo;
import com.soap.demo.repository.VehiculoRepositorio;




@Service
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private VehiculoRepositorio vehiculo;

	@Override
	public Optional<Vehiculo> buscarPorPlaca(String placa) {
		System.out.print(placa);
		List<Vehiculo> vehiculos = vehiculo.findAll();
		for (Vehiculo vehiculo : vehiculos) {
			System.out.print(vehiculo.getModelo());
			if (placa.equals(vehiculo.getPlaca())){
				return Optional.ofNullable(vehiculo);
			}
		}
		return  Optional.empty();
	}

}
