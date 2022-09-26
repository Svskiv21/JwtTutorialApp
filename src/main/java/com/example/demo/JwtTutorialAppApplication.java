package com.example.demo;

import com.example.demo.domain.AppUser;
import com.example.demo.domain.Role;
import com.example.demo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtTutorialAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTutorialAppApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> { // everything inside this calibrates will be run after application will start
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(
					new AppUser(null, "John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUser(
					new AppUser(null, "Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUser(
					new AppUser(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.saveUser(
					new AppUser(null, "Tom Hardy", "tom", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("jim", "ROLE_ADMIN");
			userService.addRoleToUser("tom", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("tom", "ROLE_ADMIN");
			userService.addRoleToUser("tom", "ROLE_USER");

		};
	}

}
