package br.com.prog3.semanapratica2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.semanapratica2.domain.Cliente;
import br.com.prog3.semanapratica2.repository.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	public Optional<Cliente> findByCpf(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}

	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void deleteByCpf(String cpf) {
		clienteRepository.deleteByCpf(cpf);
	}
	
}
