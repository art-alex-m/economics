package eco.economics.common.service;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
abstract public class AbstractCommandService<D, E> {

    @PersistenceContext
    @Getter
    private EntityManager em;

    @Autowired
    @Getter
    private ModelMapper mapper;

    public D toDto(E entity, Class<D> dtoClass) {
        return mapper.map(entity, dtoClass);
    }
}
