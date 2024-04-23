package lv.venta.ajkats.converters;

import lv.venta.ajkats.dto.ExamDTO;
import lv.venta.ajkats.models.entities.Exam;

public class ExamConverter implements IDtoConverter<Exam, ExamDTO> {

    public Exam convertToEntity(ExamDTO dto) {
        final Exam entity = new Exam();
        entity.setId(dto.getId());
        entity.setExamTitle(dto.getExamTitle());
        entity.setExamDate(dto.getExamDate());
        entity.setCourse(dto.getCourse());
        dto.getExamStudents().forEach(entity::addExamStudent);

        return entity;
    }

    public ExamDTO convertToDto(Exam entity) {
        final ExamDTO dto = new ExamDTO();
        dto.setId(entity.getId());
        dto.setExamTitle(entity.getExamTitle());
        dto.setExamDate(entity.getExamDate());
        dto.setCourse(entity.getCourse());
        dto.setExamStudents(entity.getExamStudents());

        return dto;
    }
}
