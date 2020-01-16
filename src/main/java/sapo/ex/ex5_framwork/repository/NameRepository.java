package sapo.ex.ex5_framwork.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sapo.ex.ex5_framwork.model.NameEntity;
@Repository
public interface NameRepository extends CrudRepository<NameEntity,Integer> {
    @Query("select e from NameEntity e")
    Page<NameEntity> getAllPage(Pageable pageable);

}
