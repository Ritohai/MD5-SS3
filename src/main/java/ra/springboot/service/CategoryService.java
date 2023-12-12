package ra.springboot.service;

import ra.springboot.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
    Category findById(Integer id);
    void delete(Integer id);

}
