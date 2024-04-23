package lv.venta.ajkats.service.implementations;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.converters.ExamStudentConverter;
import lv.venta.ajkats.converters.IDtoConverter;
import lv.venta.ajkats.dto.ExamStudentDTO;
import lv.venta.ajkats.models.entities.ExamStudent;
import lv.venta.ajkats.repositories.IBaseRepository;
import lv.venta.ajkats.repositories.IExamStudentRepository;
import lv.venta.ajkats.service.CrudServiceImplementation;
import lv.venta.ajkats.service.interfaces.IExamStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamStudentServiceImplementation extends CrudServiceImplementation<ExamStudent, ExamStudentDTO> implements IExamStudentService {

    @Autowired
    private IExamStudentRepository examStudentRepository;

    private final ExamStudentConverter examStudentConverter = new ExamStudentConverter();

    @Override
    protected IBaseRepository<ExamStudent, Long> getRepository() {
        return examStudentRepository;
    }

    @Override
    protected IDtoConverter<ExamStudent, ExamStudentDTO> getConverter() {
        return examStudentConverter;
    }
}
