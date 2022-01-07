package br.com.acapi.jparepository.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acapi.jparepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
