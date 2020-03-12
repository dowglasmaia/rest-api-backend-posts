package com.maia.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Posts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String titulo;
	private String descricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime data;
	private String urlImagem;
	private Integer upVotos;

	public Posts() {

	}

	public Posts(String id, String titulo, String descricao, LocalDateTime data, String urlImagem, Integer upVotos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.urlImagem = urlImagem;
		this.upVotos = upVotos;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Integer getUpVotos() {
		return upVotos;
	}

	public void setUpVotos(Integer upVotos) {
		this.upVotos = upVotos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posts other = (Posts) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
