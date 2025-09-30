package br.com.lordsabino.api.repositories;

import br.com.lordsabino.api.Entities.Category;
import br.com.lordsabino.api.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
