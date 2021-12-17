package br.com.prog3.semanapratica2.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.prog3.semanapratica2.domain.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,String>{

	public Optional<Cliente> findByCpf(String cpf);
	
	public void deleteByCpf(String cpf);
}
