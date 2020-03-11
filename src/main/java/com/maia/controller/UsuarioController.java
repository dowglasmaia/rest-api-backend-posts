package com.maia.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maia.domain.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		Usuario usuario = new Usuario(1L, "Dowglas Maia", "dowglasmaia@live.com");
		Usuario usuario2 = new Usuario(1L, "Dowglas ", "maia@live.com");

		List<Usuario> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(usuario, usuario2));
		
		return ResponseEntity.ok().body(lista);

	}

}
