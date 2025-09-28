package br.com.lordsabino.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lordsabino.api.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
