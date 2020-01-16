package sapo.ex.ex5_framwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sapo.ex.ex5_framwork.model.NameEntity;
import sapo.ex.ex5_framwork.repository.NameRepository;

import java.util.List;

@Service

public class NameService {
    @Autowired
    private NameRepository nameRepository;

    public List<NameEntity> getAll() {
        return (List<NameEntity>) nameRepository.findAll();
    }

    public Page<NameEntity> entities(Pageable pageable) {
        return  nameRepository.getAllPage(pageable);
    }
    public void save(NameEntity entity){
         nameRepository.save(entity);
    }
}
