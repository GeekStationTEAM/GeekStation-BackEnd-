package com.org.Generation.GeekStation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.Generation.GeekStation.model.PedidoEntity;
import com.org.Generation.GeekStation.service.PedidoService;


@RestController
@RequestMapping("/api/v1")

public class PedidoController {
	
	private final PedidoService pedidoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	//Mapear el metodo getAll()
	
	@GetMapping("/pedidos")
	public List<PedidoEntity> getUsers(){
		return this.pedidoService.getAll();
	}
	
	//Mapear el metodo createUser() de manera sencialla
	// @RequestBody me permite solicitar el cuerpo (atributos) del Objeto 
	
	@PostMapping("/new-pedido")
	public PedidoEntity createPedido(@RequestBody PedidoEntity newPedido) {
		return this.pedidoService.createPedido(newPedido);
	}
	

}
