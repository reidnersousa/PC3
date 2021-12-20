package br.com.prog3.semanapratica2.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Oficina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private String especilidade;
	private String endereco;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_oficina")
	private List<Carro> carros;

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	
	
	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEspecilidade() {
		return especilidade;
	}



	public void setEspecilidade(String especilidade) {
		this.especilidade = especilidade;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	/*
	public Oficina(Integer codigo ,String  endereco , String especilidade , String nome,List<Carro> carros) {
		this.codigo=codigo;
		this.endereco=endereco;
		this.especilidade=especilidade;
		this.nome=nome;
		this.carros=carros;
		
	}
	*/
	
	public Oficina( ) {
		//this.codigo=codigo;
		
		
	}
}

