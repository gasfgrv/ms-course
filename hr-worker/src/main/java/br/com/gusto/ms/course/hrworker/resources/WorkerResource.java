package br.com.gusto.ms.course.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	private final Environment env;
	private final WorkerRepository repository;

	@Autowired
	public WorkerResource(WorkerRepository repository, Environment env) {
		this.env = env;
		this.repository = repository;
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable("id") long id) {
		logger.info("Port: {}", env.getProperty("local.server.port"));
		return ResponseEntity.ok(repository.findById(id).orElse(null));
	}
}
