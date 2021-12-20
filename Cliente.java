package br.com.prog3.semanapratica2.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private String cpf;
	private String cpfReal;
	public String getCpfReal() {
		return cpfReal;
	}

	public void setCpfReal(String cpfReal) {
		this.cpfReal = cpfReal;
	}

	private String nome;
	private LocalDate dataNascimento;
	
	/*
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	private List<Carro> carros;
		
	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	*/

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/*
	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
*/
	//@OneToMany
	//private List<Carro>carros;
	
	
	public Cliente(){
		
		
	}

}

