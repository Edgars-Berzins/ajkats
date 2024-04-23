package lv.venta.ajkats.service.implementations;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.converters.IDtoConverter;
import lv.venta.ajkats.converters.StudentConverter;
import lv.venta.ajkats.dto.StudentDTO;
import lv.venta.ajkats.models.entities.Student;
import lv.venta.ajkats.repositories.IBaseRepository;
import lv.venta.ajkats.repositories.IStudentRepository;
import lv.venta.ajkats.service.CrudServiceImplementation;
import lv.venta.ajkats.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation extends CrudServiceImplementation<Student, StudentDTO> implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    private final StudentConverter studentConverter = new StudentConverter();

    @Override
    protected IBaseRepository<Student, Long> getRepository() {
        return studentRepository;
    }

    @Override
    protected IDtoConverter<Student, StudentDTO> getConverter() {
        return studentConverter;
    }
}
