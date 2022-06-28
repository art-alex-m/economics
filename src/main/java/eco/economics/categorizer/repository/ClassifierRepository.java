package eco.economics.categorizer.repository;

import eco.economics.categorizer.entity.Classifier;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ClassifierRepository extends PagingAndSortingRepository<Classifier, UUID> {
}