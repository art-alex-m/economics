package eco.economics.categorizer.service;

import eco.economics.categorizer.dto.ClassifierDto;
import eco.economics.categorizer.entity.Classifier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class ClassifierCommandService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ModelMapper mapper;

    public ClassifierDto store(ClassifierDto dto) {

        Classifier classifier = new Classifier();

        classifier.setActive(dto.getActive());
        classifier.setDescription(dto.getDescription());
        classifier.setMain(dto.getMain());
        classifier.setTitle(dto.getTitle());

        em.persist(classifier);
        em.flush();
        em.refresh(classifier);

        return toDto(classifier);
    }

    private ClassifierDto toDto(Classifier classifier) {
        return mapper.map(classifier, ClassifierDto.class);
    }
}
