package sapo.ex.ex5_framwork.service.ipl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sapo.ex.ex5_framwork.model.ProductEntity;

import java.util.Optional;

public interface ProductServiceIml {
    Optional<ProductEntity> getId(int id);
    Iterable<ProductEntity> getAll();
    Page<ProductEntity> getAllpage(Pageable pageable);
    int save(ProductEntity entity);
    boolean checkId(int id);
    void deleteByIdCategory(int id);
    Page<ProductEntity>  getByIdCategory(int id,Pageable pageable);
    int numberOfRow(int id);

}
