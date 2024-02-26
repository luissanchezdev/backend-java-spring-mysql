package com.servidatos.contactform.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidatos.contactform.models.UsuarioModel;
import com.servidatos.contactform.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	// Método para traer todos los usuarios
    public ArrayList<UsuarioModel> getAllUsuarios(){
    	return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
    
    // Guardar un usuario
    public UsuarioModel saveUsuario(UsuarioModel usuario) {
    	return usuarioRepository.save(usuario);
    }
    
    // Obtener un usuario por id
    public Optional<UsuarioModel> getById(Long id){
    	return usuarioRepository.findById(id);
    }
    
    // Obtener por email
    public UsuarioModel getByEmail(String email){
    	return usuarioRepository.findByEmail(email);
    }
    
    // Eliminar usuario
    public boolean deleteUsuario(Long id) {
    	try {
    		usuarioRepository.deleteById(id);
    		return true;
    		
    	}catch(Exception err) {
    		return false;
    	}
    }
    
    
}
