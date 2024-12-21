package com.org.Generation.GeekStation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.Generation.GeekStation.model.PagoEntity;
import com.org.Generation.GeekStation.service.PagoService;

@RestController
@RequestMapping("/api/v1")
public class PagoController {
	

	private final PagoService pagoService;
	
	@Autowired
	public PagoController(PagoService pagoService) {
		this.pagoService = pagoService;
	}
	
	//Mapear el metodo getAll()
	
	@GetMapping("/pagos")
	public List<PagoEntity> getPago(){
		return this.pagoService.getAll();
	}
	
	//Mapear el metodo createUser() de manera sencialla
	// @RequestBody me permite solicitar el cuerpo (atributos) del Objeto 
	
	@PostMapping("/new-pago")
	public PagoEntity createPago(@RequestBody PagoEntity newPago) {
		return this.pagoService.createPago(newPago);
	}
	
	

}
