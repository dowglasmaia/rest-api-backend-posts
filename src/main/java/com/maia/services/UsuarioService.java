package com.maia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maia.domain.Usuario;
import com.maia.excptions.services.ObjectNotFoundException;
import com.maia.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> user = repository.findById(id);
		return user.orElseThrow(()-> new ObjectNotFoundException("Usuario não encontrado"));
	}

}
