package com.org.Generation.GeekStation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Generation.GeekStation.model.PedidoEntity;
import com.org.Generation.GeekStation.repository.PedidoRepository;

@Service
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	//metodo para obtener todos los Pedidos
	public List<PedidoEntity> getAll(){
		return this.pedidoRepository.findAll();
	}
		
	//metodo para crear un nuevo Pedido
	public PedidoEntity createPedido(PedidoEntity newPedido) {
		return this.pedidoRepository.save(newPedido);
	}
	
	
	

}
