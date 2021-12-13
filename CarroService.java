package br.com.prog3.semanapratica2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.semanapratica2.domain.Carro;
import br.com.prog3.semanapratica2.repository.CarroRepository;

@Service
public class CarroService {
	
	
	@Autowired
	private CarroRepository carroRepository;

	public Carro save(Carro carro) {
		return carroRepository.save(carro);
		}
}
