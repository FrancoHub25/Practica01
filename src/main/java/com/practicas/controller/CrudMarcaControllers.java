package com.practicas.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practicas.entity.Marca;
import com.practicas.services.MarcaServices;
import com.practicas.utils.Constantes;

@RestController
@RequestMapping("/rest/crudMarca")
@CrossOrigin(origins = "http://localhost:4200")
public class CrudMarcaControllers {

	@Autowired
	private MarcaServices services;
	
	@GetMapping("/listaMarcaNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Marca>> listaMarcaNombreLike(@PathVariable("nom") String nom) {
		List<Marca> lista = null;
		try {
			if(nom.equals("todos")) {
				lista = services.listaMarcaNombreLike("%");
			} else {
				lista = services.listaMarcaNombreLike("%" + nom + "%");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registrarMarcas")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertarMarcas(@RequestBody Marca obj) {
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			obj.setIdMarca(0);
			obj.setFechaRegistro(new Date());
			obj.setFechaVigencia(new Date());
			obj.setEstado(1);
			Marca objSalida = services.insertarActualizarMarca(obj);
			if(objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			} 
		} catch(Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizarMarcas")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizarMarcas(@RequestBody Marca obj) {
		
		Map<String, Object> salida = new HashMap<>();
		
		try {
			Marca objSalida = services.insertarActualizarMarca(obj);
			if(objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			} 
		} catch(Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminarMarcas/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarMarcas(@PathVariable("id") int id) {
		
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Marca> opt = services.buscaMarca(id);
			if(opt.isPresent()) {
				services.eliminarMarca(id);
				Optional<Marca> optMarcas = services.buscaMarca(id);
				if(optMarcas.isEmpty()) {
					salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
				} else {
					salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
				}
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ELI_NO_EXISTE_ID);
			}
		} catch(Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
}
