package br.com.gusto.ms.couse.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gusto.ms.couse.hruser.entities.User;
import br.com.gusto.ms.couse.hruser.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {

	private final UserRepository repository;

	@Autowired
	public UserResource(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id).get());
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		return ResponseEntity.ok(repository.findByEmail(email).get());
	}
}
