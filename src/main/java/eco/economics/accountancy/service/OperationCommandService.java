package eco.economics.accountancy.service;

import eco.economics.accountancy.dto.BaseClassificationDto;
import eco.economics.accountancy.dto.OperationDto;
import eco.economics.accountancy.dto.RecordDto;
import eco.economics.accountancy.entity.BaseClassification;
import eco.economics.accountancy.entity.Operation;
import eco.economics.categorizer.entity.Record;
import eco.economics.common.service.AbstractCommandService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OperationCommandService extends AbstractCommandService<OperationDto, Operation> {

    public OperationDto store(OperationDto dto) {

        Operation operation = new Operation();

        operation.setId(UUID.randomUUID());
        operation.setTitle(dto.getTitle());
        operation.setDate(dto.getDate());
        operation.setValue(dto.getValue());

        BaseClassification baseClassification = createBaseClassification(
                dto.getBaseClassification(),
                operation.getId()
        );

        getEm().persist(operation);
        getEm().persist(baseClassification);
        getEm().flush();
        getEm().refresh(operation);

        return toDto(operation, OperationDto.class);
    }

    private Record getRecordById(RecordDto recordDto) {
        Record record = new Record();
        record.setId(recordDto.getId());

        return record;
    }

    private BaseClassification createBaseClassification(BaseClassificationDto classificationDto, UUID operationId) {

        BaseClassification classification = new BaseClassification();

        classification.setRecordFrom(getRecordById(classificationDto.getRecordFrom()));
        classification.setRecordTo(getRecordById(classificationDto.getRecordTo()));
        classification.setOperationId(operationId);

        return classification;
    }

}
