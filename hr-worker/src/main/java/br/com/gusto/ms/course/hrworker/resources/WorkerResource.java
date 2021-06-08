package br.com.gusto.ms.course.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gusto.ms.course.hrworker.entities.Worker;
import br.com.gusto.ms.course.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	private final WorkerRepository repository;
	
	@Autowired
	public WorkerResource(WorkerRepository repository) {
		 this.repository = repository;
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok(repository.findAll()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable("id") long id) {
		return ResponseEntity.ok(repository.findById(id).orElse(null));
	}
}
