package com.servidatos.contactform.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.servidatos.contactform.exceptions.ResourceNotFoundException;
import com.servidatos.contactform.models.UsuarioModel;
import com.servidatos.contactform.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ResponseEntity<ArrayList<UsuarioModel>> getAllUsuarios() {
		ArrayList<UsuarioModel> allUsuarios =  usuarioService.getAllUsuarios();
		return new ResponseEntity<>(allUsuarios, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<UsuarioModel> saveUsuario(@RequestBody UsuarioModel usuarioModel) {
		UsuarioModel userToSave = usuarioService.saveUsuario(usuarioModel);
		return new ResponseEntity<>(userToSave, HttpStatus.OK);
	}
	
	@GetMapping( path = "/{id}")
	public Optional<UsuarioModel> getUserById(@PathVariable("id") Long id){
		Optional<UsuarioModel> userFound = usuarioService.getById(id);
		System.out.println(userFound);
		if( userFound == null) {
			throw new ResourceNotFoundException("Usuario no encontrado");
		}
		
		//return userFound;
		throw new ResourceNotFoundException("Usuario no encontrado");
	}
	
	@GetMapping( "/query")
	public UsuarioModel getUserByEmail(@RequestParam("email") String email){
		return usuarioService.getByEmail(email);
	}

	@DeleteMapping( path = "/{id}")
	public String deleteUserById(@PathVariable("id") Long id) {
		boolean ok = this.usuarioService.deleteUsuario(id);
		if(ok) {
			return "Se eliminó el usuario con id " + id;
		} else {
			return "No se eliminó el usuario con id " + id;
		}
	}
}
