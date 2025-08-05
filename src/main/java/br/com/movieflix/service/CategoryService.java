package br.com.movieflix.service;


import br.com.movieflix.entity.Category;
import br.com.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }


    public List<Category> findAll() {
        return repository.findAll();
    }
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    public void deleteCategory(Long id) {
        Optional<Category> optCategory = repository.findById(id);
        if (optCategory.isPresent()) {
            repository.delete(optCategory.get());
        }
    }


}
