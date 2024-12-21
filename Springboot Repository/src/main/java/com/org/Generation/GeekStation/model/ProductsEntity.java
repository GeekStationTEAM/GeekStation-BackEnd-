package com.org.Generation.GeekStation.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class ProductsEntity {
		
		@Id // Anota que este atributo es una PK
		@GeneratedValue(strategy = GenerationType.IDENTITY) // Genere un valor automático mediante una estrategia de tipo IDENTITY (AutoIncrementable)
		@Column(name = "id_producto")
		private Long id;
		
		@Column(name = "nombre", length = 30, nullable = false, unique = false)
		private String nombre;
		
		@Column(name = "descripcion", length = 80, nullable = false, unique = false)
		private String descripcion;
		
		@Column(name = "sku", length = 80, nullable = false, unique = true)
		private Long sku;
		
		@Column(name = "marca", length = 60, nullable = false, unique = false)
		private String marca;
		
		@Column(name = "color", length = 60, nullable = false, unique = false)
		private String color;
		
		@Column(name = "url", length = 60, nullable = false, unique = true)
		private String url;
		
		@Column(name = "stock", length = 60, nullable = false, unique = false)
		private Long stock;
		
		@Column(name = "precio", length = 60, nullable = false, unique = false)
		private Double precio;

		
		public ProductsEntity() {
			
		}


		public ProductsEntity(Long id, String nombre, String descripcion, Long sku, String marca, String color,
				String url, Long stock, Double precio) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.sku = sku;
			this.marca = marca;
			this.color = color;
			this.url = url;
			this.stock = stock;
			this.precio = precio;
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


		public Long getSku() {
			return sku;
		}


		public void setSku(Long sku) {
			this.sku = sku;
		}


		public String getMarca() {
			return marca;
		}


		public void setMarca(String marca) {
			this.marca = marca;
		}


		public String getColor() {
			return color;
		}


		public void setColor(String color) {
			this.color = color;
		}


		public String getUrl() {
			return url;
		}


		public void setUrl(String url) {
			this.url = url;
		}


		public Long getStock() {
			return stock;
		}


		public void setStock(Long stock) {
			this.stock = stock;
		}


		public Double getPrecio() {
			return precio;
		}


		public void setPrecio(Double precio) {
			this.precio = precio;
		}


		@Override
		public String toString() {
			return "ProductsEntity [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", sku=" + sku
					+ ", marca=" + marca + ", color=" + color + ", url=" + url + ", stock=" + stock + ", precio="
					+ precio + "]";
		}


		@Override
		public int hashCode() {
			return Objects.hash(color, descripcion, id, marca, nombre, precio, sku, stock, url);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ProductsEntity other = (ProductsEntity) obj;
			return Objects.equals(color, other.color) && Objects.equals(descripcion, other.descripcion)
					&& Objects.equals(id, other.id) && Objects.equals(marca, other.marca)
					&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio)
					&& Objects.equals(sku, other.sku) && Objects.equals(stock, other.stock)
					&& Objects.equals(url, other.url);
		}
		
		
		
		
		
	}



