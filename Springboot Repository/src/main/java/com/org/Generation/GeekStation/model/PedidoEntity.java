package com.org.Generation.GeekStation.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {
	
	@Id // Anota que este atributo es una PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Genere un valor automático mediante una estrategia de tipo IDENTITY (AutoIncrementable)
	@Column(name = "id_pedidos")				
	private Long id;
	
	@Column(name = "fecha", nullable = false, unique = false)
	private LocalDateTime fecha;
	
	@Column(name = "estado", length = 30, nullable = false, unique = false)
	private String estado;
	
	@Column(name = "total", nullable = false, unique = false)
	private Double total;
	
	@Column(name = "descripcion", length = 80, nullable = false, unique = false)
	private String descripcion;

	
	public PedidoEntity() {
	
	}


	public PedidoEntity(Long id, LocalDateTime fecha, String estado, Double total, String descripcion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.estado = estado;
		this.total = total;
		this.descripcion = descripcion;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "PedidoEntity [id=" + id + ", fecha=" + fecha + ", estado=" + estado + ", total=" + total
				+ ", descripcion=" + descripcion + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(descripcion, estado, fecha, id, total);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoEntity other = (PedidoEntity) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(estado, other.estado)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id)
				&& Objects.equals(total, other.total);
	}
	
	
	
	
	

}
