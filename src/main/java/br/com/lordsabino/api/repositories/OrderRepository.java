package br.com.lordsabino.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lordsabino.api.Entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
