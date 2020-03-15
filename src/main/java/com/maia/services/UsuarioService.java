package com.maia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maia.domain.Usuario;
import com.maia.excptions.services.ObjectNotFoundException;
import com.maia.excptions.services.RuntimeExceptionError;
import com.maia.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Usuario save(Usuario usuario) {
		try {
			return repository.save(usuario);
		} catch (Exception e) {
			throw new RuntimeExceptionError(e.getMessage());
		}

	}

	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		Optional<Usuario> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
	}

}
