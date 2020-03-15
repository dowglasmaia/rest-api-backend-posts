package com.maia.domain.dto;

import java.io.Serializable;

public class PostsNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	private String descricao;
	private String usuarioNome;
	private String usuarioEmail;
	public String descricaoDestaque;

	public PostsNewDTO() {
		
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

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}

	public String getUsuarioEmail() {
		return usuarioEmail;
	}

	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}

	public String getDescricaoDestaque() {
		return descricaoDestaque;
	}

	public void setDescricaoDestaque(String descricaoDestaque) {
		this.descricaoDestaque = descricaoDestaque;
	}

}
