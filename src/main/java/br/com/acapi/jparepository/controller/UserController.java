package br.com.acapi.jparepository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.acapi.jparepository.entities.User;
import br.com.acapi.jparepository.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public ResponseEntity<List<User>> findAllLLL(){
		List<User> result = repository.findAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<User>> findAll(Pageable pageable) {
		Page<User> result = repository.findAll(pageable);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/search-salary")
	public ResponseEntity<Page<User>> searchBySalary(@RequestParam(defaultValue = "0") Double minSalary, 
			@RequestParam(defaultValue = "1000000000000") Double maxSalary, 
			Pageable pageable) {
		Page<User> result = repository.searchBySalaryBetween(minSalary, maxSalary, pageable);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/search-name")
	public ResponseEntity<Page<User>> searchByName(@RequestParam(defaultValue = "") String name,
			Pageable pageable) {
		Page<User> result = repository.searchByNameContainingIgnoreCase(name, pageable);
		return ResponseEntity.ok(result);
	}
	
}
