package br.com.acapi.jparepository.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acapi.jparepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	//@Query("SELECT obj FROM User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
	Page<User> searchBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);

	//@Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> searchByNameContainingIgnoreCase(String name, Pageable pageable);

}
