package lv.venta.ajkats.controllers;

import lombok.RequiredArgsConstructor;
import lv.venta.ajkats.dto.CourseDTO;
import lv.venta.ajkats.models.entities.Course;
import lv.venta.ajkats.service.ICrudService;
import lv.venta.ajkats.service.interfaces.ICourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController extends CrudController<Course, CourseDTO> {

    private final ICourseService courseService;

    @Override
    protected ICrudService<Course, CourseDTO> crudService() {
        return courseService;
    }
}
