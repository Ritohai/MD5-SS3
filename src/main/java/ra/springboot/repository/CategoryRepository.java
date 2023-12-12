package ra.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ra.springboot.entity.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
