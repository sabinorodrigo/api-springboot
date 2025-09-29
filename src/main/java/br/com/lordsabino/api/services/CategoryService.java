package br.com.lordsabino.api.services;

import br.com.lordsabino.api.Entities.Category;
import br.com.lordsabino.api.Entities.User;
import br.com.lordsabino.api.repositories.CategoryRepository;
import br.com.lordsabino.api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
