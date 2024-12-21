package com.org.Generation.GeekStation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Generation.GeekStation.exceptions.UserNotFoundException;
import com.org.Generation.GeekStation.model.UserEntity;
import com.org.Generation.GeekStation.repository.UserRepository;


@Service
public class UserService {
	
private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository ) {
		this.userRepository =userRepository;
	}
	
	//metodo para obtener a todos los User
	public List<UserEntity> getAll(){
		return this.userRepository.findAll();
	}
	
	// Para poder manejar el método, debemos crear una Excepción ligada al método Optional. Esa Exception es de tipo RunTimeException para indicar que un usuario no se encontró por id
		public UserEntity userById(Long id) {
			return this.userRepository
			.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id)); 
		}
		
	//metodo para recuperar por email
		public UserEntity findByEmail(String email) {
			return this.userRepository.finByEmail(email);
		}

		public UserEntity createUser(UserEntity newUser) {
			// TODO Auto-generated method stub
			return this.userRepository.save(newUser);
		}

		// Método para eliminar un usuario por id
		public void deleteUser(Long id) {
		if (this.userRepository.existsById(id)) {
		this.userRepository.deleteById(id);
		} else {
		throw new UserNotFoundException(id);}
		}
		
		//metodo para Actualizar al user
		public UserEntity updateUser(UserEntity user, Long id) {
		return this.userRepository.findById(id) //Cuando lo encuentre, lo editamos con .map
		.map(userField -> {
		userField.setNombre(user.getNombre()); //entrar a la info vieja y luego modificarla
		userField.setEmail(user.getEmail());
		userField.setPassword(user.getPassword());
		return this.userRepository.save(userField);
		})

		.orElseThrow(() -> new UserNotFoundException(id));
		}

		

}
