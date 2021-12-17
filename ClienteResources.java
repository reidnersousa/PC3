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

import br.com.prog3.semanapratica2.domain.Cliente;
import br.com.prog3.semanapratica2.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteResource {

	
	@Autowired
	private ClienteService clienteService;

	


	@PostMapping
	public Cliente save(@RequestBody Cliente cliente){
		return clienteService.save(cliente);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = clienteService.findAll();
		if (clientes == null || clientes.isEmpty()) {
			return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

	@GetMapping(path = { "/{cpf}" })
	public ResponseEntity<?> findByCpf(@PathVariable String cpf) {
		return clienteService.findByCpf(cpf).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{cpf}")
	public ResponseEntity<Cliente> update(@PathVariable("cpf") String cpf, @RequestBody Cliente cliente) {
		return clienteService.findByCpf(cpf).map(record -> {
			
			record.setCpf(cliente.getCpf());
			record.setNome(cliente.getNome());
			record.setDataNascimento(cliente.getDataNascimento());
			//record.setCarros(cliente.getCarros());
			
			
			Cliente updated = clienteService.save(record);
			
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());

	}
	
	@DeleteMapping(path = { "/{cpf}" })
	public ResponseEntity<?> delete(@PathVariable String cpf) {
		return clienteService.findByCpf(cpf).map(record -> {
			clienteService.deleteByCpf(cpf);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}

