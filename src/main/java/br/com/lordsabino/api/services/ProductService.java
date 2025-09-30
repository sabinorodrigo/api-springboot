package br.com.lordsabino.api.services;

import br.com.lordsabino.api.Entities.Category;
import br.com.lordsabino.api.Entities.Product;
import br.com.lordsabino.api.repositories.CategoryRepository;
import br.com.lordsabino.api.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
