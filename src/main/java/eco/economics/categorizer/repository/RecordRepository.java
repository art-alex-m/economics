package eco.economics.categorizer.repository;

import eco.economics.categorizer.entity.Record;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RecordRepository extends PagingAndSortingRepository<Record, UUID> {
}