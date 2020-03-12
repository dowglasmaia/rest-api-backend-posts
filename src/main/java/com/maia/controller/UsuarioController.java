package com.maia.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.Servlet;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maia.domain.Usuario;
import com.maia.domain.dto.UsuarioDTO;
import com.maia.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService serive;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getAll() {
		List<Usuario> lista = serive.findAll();
		List<UsuarioDTO> listaDTO = lista.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);

	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> getById(@PathVariable String id) {
		Usuario result = serive.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(result));
	}

	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
		usuario = serive.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}
