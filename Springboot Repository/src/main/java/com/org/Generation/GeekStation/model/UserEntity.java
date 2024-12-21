package com.org.Generation.GeekStation.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Tenemos que convertir nuestra clase Java en una entidad usando la anotación @Entity
//Para indicar que esta Entidad se va a transformar en una Tabla, debemos anotarla con @Table

@Entity
@Table(name = "usuario")
public class UserEntity {
	
	@Id // Anota que este atributo es una PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Genere un valor automático mediante una estrategia de tipo IDENTITY (AutoIncrementable)
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "nombre", length = 30, nullable = false, unique = false)
	private String nombre;
	
	@Column(name = "apellido", length = 30, nullable = false, unique = false)
	private String apellido;
	
	@Column(name = "email", length = 80, nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", length = 60, nullable = false, unique = false)
	private String password;
	
	@Column(name = "telefono", length = 60, nullable = false, unique = false)
	private String telefono;
	
	@Column(name = "delegacion", length = 60, nullable = true, unique = false)
	private String delegacion;
	
	@Column(name = "RFC", length = 60, nullable = true, unique = true)
	private String rFC;
	
	
	
	//JPA me pide tener dentro de mi Entity un constructor vacio
	public UserEntity() {
		
	}



	public UserEntity(Long id, String nombre, String apellido, String email, String password, String telefono,
			String delegacion, String rFC) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.delegacion = delegacion;
		this.rFC = rFC;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getDelegacion() {
		return delegacion;
	}



	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}



	public String getrFC() {
		return rFC;
	}



	public void setrFC(String rFC) {
		this.rFC = rFC;
	}



	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", password=" + password + ", telefono=" + telefono + ", delegacion=" + delegacion + ", rFC=" + rFC
				+ "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(apellido, delegacion, email, id, nombre, password, rFC, telefono);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(delegacion, other.delegacion)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password)
				&& Objects.equals(rFC, other.rFC) && Objects.equals(telefono, other.telefono);
	}
	
	


	
	
}
