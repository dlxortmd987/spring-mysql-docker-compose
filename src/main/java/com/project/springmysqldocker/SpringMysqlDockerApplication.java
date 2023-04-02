package com.project.springmysqldocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMysqlDockerApplication {

	private final UserRepository userRepository;

	public SpringMysqlDockerApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlDockerApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		System.out.println("hello");
		return "hello1234";
	}

	@GetMapping("/{id}")
	public User test(@PathVariable Long id) {
		return userRepository.findById(id).get();
	}

	@PostMapping("/user")
	public void create() {
		userRepository.save(new User(1L, "test"));
	}
}
