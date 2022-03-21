package com.kakcruz.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakcruz.main.model.Cliente;
import com.kakcruz.main.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		if (!clientes.isEmpty()) {
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
		}

		else {
			return new ResponseEntity<List<Cliente>>(HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
		} else
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	}
}
