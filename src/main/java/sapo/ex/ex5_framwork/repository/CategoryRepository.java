package sapo.ex.ex5_framwork.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sapo.ex.ex5_framwork.model.CategoryEntity;

import java.util.Optional;
@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity,Integer> {

    Iterable<CategoryEntity> findByNamecategory(String name);
    Optional<CategoryEntity> findByIdcategory(int id);

}
