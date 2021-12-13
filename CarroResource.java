package br.com.prog3.semanapratica2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.semanapratica2.domain.Carro;
import br.com.prog3.semanapratica2.service.CarroService;

@RestController
@RequestMapping("/api/carros")
public class CarroResource {
	
	@Autowired
	private CarroService carroService;
	
	
	@PostMapping
	public Carro save(@RequestBody Carro carro){
		return carroService.save(carro);
	}
}
