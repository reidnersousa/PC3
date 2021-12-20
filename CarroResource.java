package br.com.prog3.semanapratica2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.semanapratica2.domain.Carro;
import br.com.prog3.semanapratica2.domain.Oficina;
import br.com.prog3.semanapratica2.service.CarroService;

@RestController
@RequestMapping("/api/carros")
public class CarroResource {

	@Autowired
	private CarroService carroService;

	@PostMapping
	public Carro save(@RequestBody Carro carro) {
		return carroService.save(carro);
	}

	@GetMapping
	public ResponseEntity<List<Carro>> findAll() {
		List<Carro> carros = carroService.findAll();
		if (carros == null || carros.isEmpty()) {
			return new ResponseEntity<List<Carro>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Carro>>(carros, HttpStatus.OK);
	}

	@GetMapping(path = { "/{placa}" })
	public ResponseEntity<?> findByPlaca(@PathVariable Integer placa) {
		return carroService.findByPlaca(placa).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	// TODO VOCE PARO NO VIDEO 4 26:00

	@PutMapping(value = "/{placa}")
	public ResponseEntity<Carro> update(@PathVariable("placa") Integer placa, @RequestBody Carro carro) {
		return carroService.findByPlaca(placa).map(record -> {

			record.setPlaca(carro.getPlaca());
			record.setPlacaCarro(carro.getPlacaCarro());
			record.setAno(carro.getAno());
			record.setCor(carro.getCor());
			record.setAnoModelo(carro.getAnoModelo());
			record.setMarca(carro.getMarca());
			record.setModelo(carro.getModelo());
			record.setOficina(carro.getOficina());
			//record.setCliente(carro.getCliente());
			
			
			
			

			Carro updated = carroService.save(record);

			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping(path = { "/{placa}" })
	public ResponseEntity<?> delete(@PathVariable Integer placa) {
		return carroService.findByPlaca(placa).map(record -> {
			carroService.deleteByPlaca(placa);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
