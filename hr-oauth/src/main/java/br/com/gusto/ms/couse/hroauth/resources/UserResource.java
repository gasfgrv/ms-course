package br.com.gusto.ms.couse.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gusto.ms.couse.hroauth.entities.User;
import br.com.gusto.ms.couse.hroauth.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	private final UserService service;

	@Autowired
	public UserResource(UserService service) {
		this.service = service;
	}

	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		try {
			return ResponseEntity.ok(service.findByEmail(email));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
