package com.maia.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
