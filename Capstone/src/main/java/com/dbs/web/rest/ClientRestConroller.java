package com.dbs.web.rest;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.web.beans.Client;
import com.dbs.web.services.ClientService;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientRestConroller
{
	@Autowired
	private ClientService cliService;
	
	@GetMapping("/clientid/{clientid}")
	private ResponseEntity<Object> findClientById(@PathVariable String clientid)
	{
		try { 
			Client c= this.cliService.findClientById(clientid);
			return ResponseEntity.status(HttpStatus.OK)
					.body(c);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Client with id "+clientid+"not found");
		}
	}

}
