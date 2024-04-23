package lv.venta.ajkats.converters;

import lv.venta.ajkats.dto.CourseDTO;
import lv.venta.ajkats.models.entities.Course;

public class CourseConverter implements IDtoConverter<Course, CourseDTO> {

    public Course convertToEntity(CourseDTO dto) {
        final Course entity = new Course();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setCreditPoints(dto.getCreditPoints());
        entity.setLevelOfStudy(dto.getLevelOfStudy());
        entity.setStudyProgram(dto.getStudyProgram());
        dto.getStudents().forEach(entity::addStudent);
        dto.getExams().forEach(entity::addExam);

        return entity;
    }

    public CourseDTO convertToDto(Course entity) {
        final CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setCreditPoints(entity.getCreditPoints());
        dto.setLevelOfStudy(entity.getLevelOfStudy());
        dto.setStudyProgram(entity.getStudyProgram());
        dto.setStudents(entity.getStudents());
        dto.setExams(entity.getExams());

        return dto;
    }
}
