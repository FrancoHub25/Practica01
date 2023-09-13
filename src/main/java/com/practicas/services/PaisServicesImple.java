package com.practicas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.entity.Pais;
import com.practicas.responsives.PaisResponsives;

@Service
public class PaisServicesImple implements PaisServices {
	
	@Autowired
	private PaisResponsives repo;

	@Override
	public List<Pais> listaPaises() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
