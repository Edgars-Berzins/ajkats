package lv.venta.ajkats.service.implementations;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.converters.ExamConverter;
import lv.venta.ajkats.converters.IDtoConverter;
import lv.venta.ajkats.dto.ExamDTO;
import lv.venta.ajkats.models.entities.Exam;
import lv.venta.ajkats.repositories.IBaseRepository;
import lv.venta.ajkats.repositories.IExamRepository;
import lv.venta.ajkats.service.CrudServiceImplementation;
import lv.venta.ajkats.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamServiceImplementation extends CrudServiceImplementation<Exam, ExamDTO> implements IExamService {

    @Autowired
    private IExamRepository examRepository;

    private final ExamConverter examConverter = new ExamConverter();

    @Override
    protected IBaseRepository<Exam, Long> getRepository() {
        return examRepository;
    }

    @Override
    protected IDtoConverter<Exam, ExamDTO> getConverter() {
        return examConverter;
    }
}
