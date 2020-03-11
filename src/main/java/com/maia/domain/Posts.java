package com.maia.domain;

import java.io.Serializable;

public class Posts implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String descricao;

	private Integer upVotos;

	public Posts() {

	}

	public Posts(Long id, String descricao, Integer upVotos) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.upVotos = upVotos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
