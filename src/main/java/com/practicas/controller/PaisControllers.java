package com.practicas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicas.entity.Pais;
import com.practicas.services.PaisServices;

@RestController
@RequestMapping("/rest/pais")
@CrossOrigin(origins = "http://localhost:4200")
public class PaisControllers {

	@Autowired
	private PaisServices serv;
	
	public ResponseEntity<List<Pais>> listarPais() {
		List<Pais> lista = serv.listaPaises();
		return ResponseEntity.ok(lista);
	}
	
}
