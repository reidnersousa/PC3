package br.com.prog3.semanapratica2.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.prog3.semanapratica2.domain.Oficina;

@Repository
public interface OficinaRepository extends CrudRepository<Oficina ,Integer> {

	
	public Optional<Oficina> findByCodigo(Integer codigo);
	
	public void deleteByCodigo(Integer codigo);
}
