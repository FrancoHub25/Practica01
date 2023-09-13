package com.practicas.services;

import java.util.List;
import java.util.Optional;

import com.practicas.entity.Marca;

public interface MarcaServices {
	
	public abstract Marca insertarActualizarMarca(Marca marca);
	public abstract List<Marca> listaMarcaNombreLike(String nombre);
	public abstract void eliminarMarca(int id);
	public abstract Optional<Marca> buscaMarca(int id);
	
}
