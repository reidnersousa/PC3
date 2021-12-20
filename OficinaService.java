package br.com.prog3.semanapratica2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.semanapratica2.domain.Oficina;
import br.com.prog3.semanapratica2.repository.OficinaRepository;

@Service
public class OficinaService {

	@Autowired
	private OficinaRepository oficinaRepository;

	public Oficina save(Oficina oficina) {
		return oficinaRepository.save(oficina);
	}

	public List<Oficina> findAll() {
		return (List<Oficina>) oficinaRepository.findAll();
	}

	public Optional<Oficina> findByCodigo(Integer codigo) {
		return oficinaRepository.findByCodigo(codigo);
	}

	public Oficina update(Oficina oficina) {
		return oficinaRepository.save(oficina);
	}

	public void deleteByCodigo(Integer codigo) {
		oficinaRepository.deleteByCodigo(codigo);
	}
}

