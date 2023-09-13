package com.practicas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.entity.Marca;
import com.practicas.responsives.MarcaResponsives;

@Service
public class MarcaServicesImple implements MarcaServices {
	
	@Autowired
	private MarcaResponsives repo;

	@Override
	public Marca insertarActualizarMarca(Marca marca) {
		// TODO Auto-generated method stub
		return repo.save(marca);
	}

	@Override
	public List<Marca> listaMarcaNombreLike(String nombre) {
		// TODO Auto-generated method stub
		return repo.listMarcaLike(nombre);
	}

	@Override
	public void eliminarMarca(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Marca> buscaMarca(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
