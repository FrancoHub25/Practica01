package com.practicas.responsives;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practicas.entity.Marca;

public interface MarcaResponsives extends JpaRepository<Marca, Integer> {
	
	@Query("select m from Marca m where m.nombre like ?1")
	public List<Marca> listMarcaLike(String nombre);

}
