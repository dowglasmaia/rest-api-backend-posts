package com.maia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maia.domain.Posts;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {

}
