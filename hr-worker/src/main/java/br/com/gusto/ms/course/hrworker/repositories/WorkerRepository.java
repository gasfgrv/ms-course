package br.com.gusto.ms.course.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gusto.ms.course.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
