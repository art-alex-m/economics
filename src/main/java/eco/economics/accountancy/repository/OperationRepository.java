package eco.economics.accountancy.repository;

import eco.economics.accountancy.entity.Operation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface OperationRepository extends PagingAndSortingRepository<Operation, UUID> {
}