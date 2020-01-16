package sapo.ex.ex5_framwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sapo.ex.ex5_framwork.model.CategoryEntity;
import sapo.ex.ex5_framwork.repository.CategoryRepository;
import sapo.ex.ex5_framwork.service.ipl.CategoryServiceIml;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService  implements CategoryServiceIml {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryEntity> getAll() {
        return (List<CategoryEntity>) categoryRepository.findAll();
    }

    @Override
    public Optional getId(int id) {
        return categoryRepository.findByIdcategory(id);
    }

    @Override
    public List<CategoryEntity> getName(String name) {
        return (List<CategoryEntity>) categoryRepository.findByNamecategory(name);
    }

    @Override
    @Transactional
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    public CategoryEntity save(CategoryEntity categoryEntity){
        categoryRepository.save(categoryEntity);
        return categoryEntity;
    }
}
