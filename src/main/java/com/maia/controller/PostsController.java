package com.maia.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maia.domain.Posts;
import com.maia.domain.dto.PostNewUpVotoDTO;
import com.maia.domain.dto.PostsDTO;
import com.maia.domain.dto.PostsNewDTO;
import com.maia.services.PostsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/posts")
public class PostsController {

	@Autowired
	private PostsService service;

	@GetMapping
	public ResponseEntity<List<PostsDTO>> getAll() {
		List<Posts> lista = service.findAll();
		List<PostsDTO> listaDTO = lista.stream().map(obj -> new PostsDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);

	}

	@GetMapping("/{id}")
	public ResponseEntity<PostsDTO> getById(@PathVariable Long id) {
		Posts result = service.findById(id);
		return ResponseEntity.ok().body(new PostsDTO(result));
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody PostsNewDTO postDto) {
		Posts post = service.fromNewDTO(postDto);
		post = service.save(post);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody PostNewUpVotoDTO postsDTO, @PathVariable Long id) {
		Posts post = service.fromDTO(postsDTO);
		post.setId(id);
		post = service.update(post);
		return ResponseEntity.noContent().build();
	}
}
