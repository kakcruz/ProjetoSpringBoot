package com.kakcruz.main.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.kakcruz.main.model.Cliente;
import com.kakcruz.main.repository.ClienteRepository;



public class TestConfig implements CommandLineRunner {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Cliente cliente1 = new Cliente(null, "Karol", "kakcruz@recode.org", "48745874108");
		Cliente cliente2 = new Cliente(null, "Simone", "simone@recode.org", "12345678910");
		
		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
	}
	

}
