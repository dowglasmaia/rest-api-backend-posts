package com.maia.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Posts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private String descricaoDestaque;

	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime data;
	private String urlImagem;
	private Integer upVotos;

	@ManyToOne
	private Usuario usuario;

	public Posts() {

	}

	public Posts(Long id, String titulo, String descricao, LocalDateTime data, String urlImagem, Usuario usuario,
			String descricaoDestaque, Integer upVotos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.urlImagem = urlImagem;
		this.usuario = usuario;
		this.descricaoDestaque = descricaoDestaque;
		this.upVotos = upVotos;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
