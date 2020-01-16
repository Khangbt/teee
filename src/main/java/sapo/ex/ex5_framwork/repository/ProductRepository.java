package sapo.ex.ex5_framwork.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sapo.ex.ex5_framwork.model.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    @Query("select e from ProductEntity e")
    Page<ProductEntity> getAllPage(Pageable pageable);

   // @Query("delete from ProductEntity where ProductEntity .=?1")
    void deleteByIdcategory(int id);
    @Query(value = "select e from ProductEntity e where e.nameprouct like ?1 order by e.idproduct desc LIMIT ?2,?3",nativeQuery = true)
    Iterable<ProductEntity> getLimit(String name,int i,int i2);
    @Query("select  e from ProductEntity  e where e.idcategory=?1")
    Page<ProductEntity> getByIdcatego(int id,Pageable pageable);
    @Query("select count (e.idproduct) from ProductEntity  e where e.idcategory=?1")
    int getCountIdCategory(int id);
}
