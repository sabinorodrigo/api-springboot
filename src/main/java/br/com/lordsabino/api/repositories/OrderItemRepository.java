package br.com.lordsabino.api.repositories;

import br.com.lordsabino.api.Entities.OrderItem;
import br.com.lordsabino.api.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
