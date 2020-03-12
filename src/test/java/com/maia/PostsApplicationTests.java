package com.maia;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maia.domain.Usuario;
import com.maia.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsApplicationTests {

	@Autowired
	private UsuarioRepository userRepo;
	
	

	@Test
	public void contextLoads() {
	}

	/*####### TESTES DE INTEGRAÇÃO COM BASE DE DADOS #####*/
	@Test	
	public void insertDB() {
		Usuario user1 = new Usuario(null, "Marcos Lima", "marcos@live.com");
		Usuario user2 = new Usuario(null, "Dowglas Maia", "dowglasmaia@live.com");
		Usuario user3 = new Usuario(null, "Kyron Maia", "luciodowglas@live.com");
		Usuario user4 = new Usuario(null, "Kamilly", "dowglasmaia@gmail.com");
		userRepo.saveAll(Arrays.asList(user1,user2,user3,user4));
	}
	
	@Test
	@Ignore
	public void deleteDB() {
		userRepo.deleteAll();
	}
	
		
}
