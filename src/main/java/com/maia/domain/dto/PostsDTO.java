package com.maia.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maia.domain.Posts;
import com.maia.domain.Usuario;

public class PostsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	private String descricao;
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime data;
	private String urlImagem;
	private Integer upVotos;
	private String nomeAutor;
	public String descricaoDestaque;

	public PostsDTO() {
	}

	public PostsDTO(Posts obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.descricao = obj.getDescricao();
		this.data = obj.getData();
		this.urlImagem = obj.getUrlImagem();
		this.nomeAutor = (obj.getUsuario() != null) ? obj.getUsuario().getNome() : "Usuário Anônimo";
		this.descricaoDestaque = obj.getDescricaoDestaque();
		this.upVotos = obj.getUpVotos();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Integer getUpVotos() {
		return upVotos;
	}

	public void setUpVotos(Integer upVotos) {
		this.upVotos = upVotos;
	}

	public String getDescricaoDestaque() {
		return descricaoDestaque;
	}

	public void setDescricaoDestaque(String descricaoDestaque) {
		this.descricaoDestaque = descricaoDestaque;
	}

}
