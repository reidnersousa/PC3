package br.com.prog3.semanapratica2.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// private String placa;
	private Integer placa;
	private String placaCarro;
	private String cor;
	private Integer ano;
	private Integer anoModelo;
	private String marca;
	private String modelo;
	
	/*
	@ManyToOne
	@JoinColumn(name="id_cliente",nullable=true,updatable=true)
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
*/
	@ManyToOne
	@JoinColumn(name = "id_oficina", nullable = true, updatable = true)
	private Oficina oficina;
	

	public Oficina getOficina() {
		return oficina;
	}



	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}



	public Carro() {
	}
	// get/set

	
	
	public String getCor() {
		return cor;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}



	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}



	public Integer getPlaca() {
		return placa;
	}

	public void setPlaca(Integer placa) {
		this.placa = placa;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
