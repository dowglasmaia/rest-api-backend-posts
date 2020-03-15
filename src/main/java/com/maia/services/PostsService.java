package com.maia.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maia.domain.Posts;
import com.maia.domain.Usuario;
import com.maia.domain.dto.PostNewUpVotoDTO;
import com.maia.domain.dto.PostsNewDTO;
import com.maia.excptions.services.ObjectNotFoundException;
import com.maia.excptions.services.RuntimeExceptionError;
import com.maia.repository.PostRepository;

@Service
public class PostsService {

	@Autowired
	private PostRepository repository;

	@Autowired
	private UsuarioService usuarioService;

	@Transactional(readOnly = true)
	public List<Posts> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Posts save(Posts posts) {
		try {
			return repository.save(posts);
		} catch (Exception e) {
			throw new RuntimeExceptionError(e.getMessage());
		}
	}

	@Transactional(readOnly = true)
	public Posts findById(Long id) {
		Optional<Posts> posts = repository.findById(id);
		return posts.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}

	@Transactional
	public Posts update(Posts post) {
		try {
			return repository.save(post);
		} catch (Exception e) {
			throw new RuntimeExceptionError(e.getMessage());
		}

	}

	public Posts fromDTO(PostNewUpVotoDTO postDTO) {
		Posts post = findById(postDTO.getId());
		post.setUpVotos(postDTO.getUpVotos());
		return post;
	}

	public Posts fromNewDTO(PostsNewDTO postDTO) {
		Usuario user = new Usuario(null, postDTO.getUsuarioNome(), postDTO.getUsuarioEmail());
		usuarioService.save(user);
		Posts post = new Posts(null, postDTO.getTitulo(), postDTO.getDescricao(), LocalDateTime.now(), null, user,
				postDTO.getDescricaoDestaque(), 0);
		return post;
	}

}
