package lv.venta.ajkats.service.implementations;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.converters.ExamResultConverter;
import lv.venta.ajkats.converters.IDtoConverter;
import lv.venta.ajkats.dto.ExamResultDTO;
import lv.venta.ajkats.models.entities.ExamResult;
import lv.venta.ajkats.repositories.IBaseRepository;
import lv.venta.ajkats.repositories.IExamResultRepository;
import lv.venta.ajkats.service.CrudServiceImplementation;
import lv.venta.ajkats.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamResultServiceImplementation extends CrudServiceImplementation<ExamResult, ExamResultDTO> implements IExamResultService {

    @Autowired
    private IExamResultRepository examResultRepository;

    private final ExamResultConverter examResultConverter = new ExamResultConverter();

    @Override
    protected IBaseRepository<ExamResult, Long> getRepository() {
        return examResultRepository;
    }

    @Override
    protected IDtoConverter<ExamResult, ExamResultDTO> getConverter() {
        return examResultConverter;
    }
}
