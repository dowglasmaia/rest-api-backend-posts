package com.maia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.maia.domain.Posts;

@Repository
public interface PostRepository extends MongoRepository<Posts, String> {

}
