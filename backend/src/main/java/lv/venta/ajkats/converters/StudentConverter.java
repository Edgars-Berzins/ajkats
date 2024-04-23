package lv.venta.ajkats.converters;

import lv.venta.ajkats.dto.StudentDTO;
import lv.venta.ajkats.models.entities.Student;

public class StudentConverter implements IDtoConverter<Student, StudentDTO> {

    public Student convertToEntity(StudentDTO dto) {
        final Student entity = new Student();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setMatriculationNumber(dto.getMatriculationNumber());
        dto.getExamStudents().forEach(entity::addExamStudent);
        dto.getCourses().forEach(entity::addCourse);

        return entity;
    }

    public StudentDTO convertToDto(Student entity) {
        final StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setMatriculationNumber(entity.getMatriculationNumber());
        dto.setExamStudents(entity.getExamStudents());
        dto.setCourses(entity.getCourses());

        return dto;
    }
}
