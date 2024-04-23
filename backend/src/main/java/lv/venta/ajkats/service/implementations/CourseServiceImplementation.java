package lv.venta.ajkats.service.implementations;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.converters.CourseConverter;
import lv.venta.ajkats.converters.IDtoConverter;
import lv.venta.ajkats.dto.CourseDTO;
import lv.venta.ajkats.models.entities.Course;
import lv.venta.ajkats.repositories.IBaseRepository;
import lv.venta.ajkats.repositories.ICourseRepository;
import lv.venta.ajkats.service.CrudServiceImplementation;
import lv.venta.ajkats.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImplementation extends CrudServiceImplementation<Course, CourseDTO> implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    private final CourseConverter courseConverter = new CourseConverter();

    @Override
    protected IBaseRepository<Course, Long> getRepository() {
        return courseRepository;
    }

    @Override
    protected IDtoConverter<Course, CourseDTO> getConverter() {
        return courseConverter;
    }
}
