package eco.economics.categorizer.service;

import eco.economics.categorizer.dto.RecordDto;
import eco.economics.categorizer.entity.Record;
import eco.economics.common.service.AbstractCommandService;
import org.springframework.stereotype.Service;

@Service
public class RecordCommandService extends AbstractCommandService<RecordDto, Record> {

    public RecordDto store(RecordDto recordDto) {

        Record record = new Record();

        record.setActive(recordDto.getActive());
        record.setTitle(recordDto.getTitle());
        record.setClassifierId(recordDto.getClassifier().getId());

        getEm().persist(record);
        getEm().flush();
        getEm().refresh(record);

        return toDto(record, RecordDto.class);
    }

}
