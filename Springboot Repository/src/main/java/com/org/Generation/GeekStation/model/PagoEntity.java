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
@Table(name = "pago")
public class PagoEntity {
	
	@Id // Anota que este atributo es una PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Genere un valor automático mediante una estrategia de tipo IDENTITY (AutoIncrementable)
	@Column(name = "id_pago")
	private Long id;
	
	@Column(name = "fecha", nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime fecha;
	
	@Column(name = "metodo_pago", length = 30, nullable = false, unique = false)
	private String metodo_pago;
	
	@Column(name = "monto", length = 30, nullable = false, unique = false)
	private String monto;
	
	@Column(name = "folio_factura", length = 30, nullable = false, unique = true)
	private String folio_factura;

	
	public PagoEntity() {
	}


	public PagoEntity(Long id, LocalDateTime fecha, String metodo_pago, String monto, String folio_factura) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.metodo_pago = metodo_pago;
		this.monto = monto;
		this.folio_factura = folio_factura;
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


	public String getMetodo_pago() {
		return metodo_pago;
	}


	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}


	public String getMonto() {
		return monto;
	}


	public void setMonto(String monto) {
		this.monto = monto;
	}


	public String getFolio_factura() {
		return folio_factura;
	}


	public void setFolio_factura(String folio_factura) {
		this.folio_factura = folio_factura;
	}


	@Override
	public String toString() {
		return "PagoEntity [id=" + id + ", fecha=" + fecha + ", metodo_pago=" + metodo_pago + ", monto=" + monto
				+ ", folio_factura=" + folio_factura + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(fecha, folio_factura, id, metodo_pago, monto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PagoEntity other = (PagoEntity) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(folio_factura, other.folio_factura)
				&& Objects.equals(id, other.id) && Objects.equals(metodo_pago, other.metodo_pago)
				&& Objects.equals(monto, other.monto);
	}
	
	
	
	
	

	
	

}
