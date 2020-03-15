package com.maia.domain.dto;

import java.io.Serializable;

public class PostNewUpVotoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer upVotos;

	public PostNewUpVotoDTO() {
		
	}

	public PostNewUpVotoDTO(Long id, Integer upVotos) {
		super();
		this.id = id;
		this.upVotos = upVotos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUpVotos() {
		return upVotos;
	}

	public void setUpVotos(Integer upVotos) {
		this.upVotos = upVotos;
	}

	
	
}
