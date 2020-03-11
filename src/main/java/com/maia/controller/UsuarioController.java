package com.maia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maia.domain.Usuario;
import com.maia.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService serive;

	@GetMapping	
	public ResponseEntity<List<Usuario>> getAll() {
		List<Usuario> result = serive.findAll();	
		return ResponseEntity.ok().body(result);

	}

}
