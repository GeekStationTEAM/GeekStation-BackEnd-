package com.org.Generation.GeekStation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Generation.GeekStation.model.PagoEntity;
import com.org.Generation.GeekStation.repository.PagoRepository;

@Service
public class PagoService {
	
	private final PagoRepository pagoRepository;
	
	@Autowired
	public PagoService(PagoRepository pagoRepository) {
		this.pagoRepository = pagoRepository;
	}
	
	//metodo para obtener a todos los Pagos
		public List<PagoEntity> getAll(){
			return this.pagoRepository.findAll();
		}
		
		//metodo para crear un nuevo usuario
		public PagoEntity createPago(PagoEntity newPago) {
			return this.pagoRepository.save(newPago);
		}
	
	
	
	
	

}
