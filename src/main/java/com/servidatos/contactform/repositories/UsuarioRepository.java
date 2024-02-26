package com.servidatos.contactform.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servidatos.contactform.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
	
	// Podemos usar findBy con el nombre de una propiedad para filtrar al crear un metodo
	UsuarioModel findByEmail(String email);

}
