package com.maia;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maia.domain.Posts;
import com.maia.domain.Usuario;
import com.maia.repository.PostRepository;
import com.maia.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsApplicationTests {

	@Autowired
	private UsuarioRepository userRepo;
	@Autowired
	private PostRepository postRepo;
	

	@Test
	public void contextLoads() {

	}

	/** @since TESTES DE INTEGRAÇÃO COM BASE DE DADOS */

	/* ## USUARIO ## */
	@Test
	@Ignore
	public void insertUser() {
		Usuario user1 = new Usuario(null, "Marcos Lima", "marcos@live.com");
		Usuario user2 = new Usuario(null, "Dowglas Maia", "dowglasmaia@live.com");
		Usuario user3 = new Usuario(null, "Kyron Maia", "luciodowglas@live.com");
		Usuario user4 = new Usuario(null, "Kamilly", "dowglasmaia@gmail.com");
		userRepo.saveAll(Arrays.asList(user1, user2, user3, user4));
	}

	@Test
	@Ignore
	public void deleteDB() {
		userRepo.deleteAll();
	}

	/* ## Posts ### */
	@Test
	//@Ignore
	public void insertPost() {
		Usuario user1 = new Usuario(null, "Marcos Lima", "marcos@live.com");
		Usuario user2 = new Usuario(null, "Dowglas Maia", "dowglasmaia@live.com");
		userRepo.saveAll(Arrays.asList(user1, user2));

		Posts posts = new Posts(null, "Dev Angular",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer scelerisque facilisis lacus sed maximus.",
				LocalDateTime.now(), "", user2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit", 0);
	
		Posts posts2 = new Posts(null, "Desenvolvimento com Spring",
				"Lorisl luctus quis. Aliquam erat volutpat. Maecenas ac diam vitae enim iaculis laoreet",
				LocalDateTime.now(), "", user1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit", 12);
		
		postRepo.saveAll(Arrays.asList(posts, posts2));

	}

	@Test
	@Ignore
	public void upVotosLikePost() {
		
	}

}
