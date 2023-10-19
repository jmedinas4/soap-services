package com.soap.demo.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.soap.demo.entity.Vehiculo;
import com.soap.demo.repository.VehiculoRepositorio;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@Service
@WebService(serviceName = "vehiculos")
public class SOAPImplementacion {

	@Autowired
	private VehiculoRepositorio vehiculoRepositorio;
    @Autowired
    private IVehiculoService servicioVehiculo;

   
    @WebMethod(operationName = "consultarSeguro")
    public String consultarSeguroTodoRiesgo(@WebParam(name = "placa") String placa) {
//    	Vehiculo vehiculo = vehiculoRepositorio.findById(null)
    	System.out.print("la placas es : "+placa);
    	List<Vehiculo> vehiculos = vehiculoRepositorio.findAll();
    	for (Vehiculo vehiculo : vehiculos) {
			System.out.print(vehiculo.getModelo());
			if (placa.equals(vehiculo.getPlaca())){
				return "el valor del seguro es : " + vehiculo.consultarSeguroTodoRiesgo();
			}
		}
       

        return "Placa No Encontrada";
    }
    
    @WebMethod(operationName = "valorSeguroSoat")
    public String calcularValorSeguro(String placa) {
    	System.out.print("la placas es : "+placa);
        Optional<Vehiculo> vehiculoSeleccionado = servicioVehiculo.buscarPorPlaca(placa);
        if (vehiculoSeleccionado.isPresent()) {
            Long precioSeguro = (vehiculoSeleccionado.get().getPrecio() * 20) / 100;
            return "El valor del SOAT ES(20% valor comercial): "+ String.valueOf(precioSeguro);
        } else {
            return "Placa No Encontrada";
        }
    }
//
//    @WebMethod(operationName = "adicionar")
//    public void addUsuario(@WebParam Usuario usuario) {
//        datos.adicionarUsuario(usuario); 
//    }
//
//    @WebMethod(operationName = "consultaUniversidad")
//    public Universidad consulta(@WebParam String nit) {
//        return new Universidad("nit", "nit");
//    }
//
//    @WebMethod(operationName = "dataIn")
//    public DatosEntrada DataIn(@WebParam String cedula) {
//        return new DatosEntrada(123, "28/9/23");
//    }
//
//    @WebMethod(operationName = "consultaSaldo")
//    public DatosSalida DataOut(@WebParam DatosEntrada datos) {
//        // System.out.println(datos.getCedula());
//        return new DatosSalida(23, 123, new Banco(123, "Miguel"));
//    }
//
//    @WebMethod(operationName = "consultaSaldoUser")
//    public DatosSalida DataOutUserCash(@WebParam DatosEntrada datos) {
//        // System.out.println(datos.getCedula());
//        
//        return new DatosSalida(23, 123, new Banco(123, "Miguel"));
//    }
//
//    @WebMethod(operationName = "consultaValorSeguro")
//    public String consultarValorSeguro(@WebParam String plaquita ) {
//        VehiculoDto vehiculo = datos.consultarVehiculo(plaquita);
//        if (vehiculo != null){
//        
//            return "EL valor del seguro es : "+vehiculo.getValorSeguro();
//        }else{
//            return "EL valor del seguro es : "+0L;
//        }


        
//    }
	
	
	
	
}