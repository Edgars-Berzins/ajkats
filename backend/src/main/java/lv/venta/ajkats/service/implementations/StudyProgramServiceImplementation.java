package lv.venta.ajkats.service.implementations;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.converters.IDtoConverter;
import lv.venta.ajkats.converters.StudyProgramConverter;
import lv.venta.ajkats.dto.StudyProgramDTO;
import lv.venta.ajkats.models.entities.StudyProgram;
import lv.venta.ajkats.repositories.IBaseRepository;
import lv.venta.ajkats.repositories.IStudyProgramRepository;
import lv.venta.ajkats.service.CrudServiceImplementation;
import lv.venta.ajkats.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyProgramServiceImplementation extends CrudServiceImplementation<StudyProgram, StudyProgramDTO> implements IStudyProgramService {

    @Autowired
    private IStudyProgramRepository studyProgramRepository;

    private final StudyProgramConverter studyProgramConverter = new StudyProgramConverter();

    @Override
    protected IBaseRepository<StudyProgram, Long> getRepository() {
        return studyProgramRepository;
    }

    @Override
    protected IDtoConverter<StudyProgram, StudyProgramDTO> getConverter() {
        return studyProgramConverter;
    }
}
