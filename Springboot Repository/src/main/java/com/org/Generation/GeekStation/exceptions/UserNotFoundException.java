package com.org.Generation.GeekStation.exceptions;


//La clase hereda de RuntimeException
public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	//Definir metodo constructor que eevalua un parametro
	//Como Runtime 
	public UserNotFoundException(Long id) {
		super("User with id: " + id + "not found");
	}
	
}
