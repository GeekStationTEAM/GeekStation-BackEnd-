package com.org.Generation.GeekStation.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class CategoryEntity {
	

	@Id // Anota que este atributo es una PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Genere un valor automático mediante una estrategia de tipo IDENTITY (AutoIncrementable)
	@Column(name = "id_categorias")
	private Long id;
	
	@Column(name = "nombre", length = 30, nullable = false, unique = false)
	private String nombre;
	
	@Column(name = "descripcion", length = 80, nullable = false, unique = false)
	private String descripcion;

	
	
	public CategoryEntity() {
		
	}

	
	
	public CategoryEntity(Long id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	@Override
	public String toString() {
		return "CategoryEntity [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, nombre);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryEntity other = (CategoryEntity) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}
	
	
	
	
	

}
