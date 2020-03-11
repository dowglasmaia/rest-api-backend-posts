package com.maia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.maia.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
