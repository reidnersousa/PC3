
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

import br.com.prog3.semanapratica2.domain.Oficina;
import br.com.prog3.semanapratica2.service.OficinaService;

@RestController
@RequestMapping("/api/oficina")
public class OficinaResource {


	@Autowired
	private OficinaService oficinaService;

	@PostMapping
	public Oficina save(@RequestBody Oficina oficina) {
		return oficinaService.save(oficina);
	}

	@GetMapping
	public ResponseEntity<List<Oficina>> findAll() {
		List<Oficina> oficinas = oficinaService.findAll();
		if (oficinas == null || oficinas.isEmpty()) {
			return new ResponseEntity<List<Oficina>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Oficina>>(oficinas, HttpStatus.OK);
	}

	@GetMapping(path = { "/{codigo}" })
	public ResponseEntity<?> findByCodigo(@PathVariable Integer codigo) {
		return oficinaService.findByCodigo(codigo).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	// TODO VOCE PARO NO VIDEO 4 26:00

	@PutMapping(value = "/{codigo}")
	public ResponseEntity<Oficina> update(@PathVariable("codigo") Integer codigo, @RequestBody Oficina oficina) {
		return oficinaService.findByCodigo(codigo).map(record -> {
			
			record.setCodigo(oficina.getCodigo());
			record.setNome(oficina.getNome());
			record.setEspecilidade(oficina.getEspecilidade());
			record.setEndereco(oficina.getEndereco());
			record.setCarros(oficina.getCarros());
			
		
			
			
			Oficina updated = oficinaService.save(record);

			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping(path = { "/{codigo}" })
	public ResponseEntity<?> delete(@PathVariable Integer codigo) {
		return oficinaService.findByCodigo(codigo).map(record -> {
			oficinaService.deleteByCodigo(codigo);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
