package br.com.lordsabino.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lordsabino.api.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
