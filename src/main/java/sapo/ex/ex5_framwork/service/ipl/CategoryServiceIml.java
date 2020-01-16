package sapo.ex.ex5_framwork.service.ipl;

import sapo.ex.ex5_framwork.model.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryServiceIml {
    List<CategoryEntity> getAll();
    Optional<CategoryEntity> getId(int id);
    List<CategoryEntity> getName(String name);
    void delete(int id);
}
