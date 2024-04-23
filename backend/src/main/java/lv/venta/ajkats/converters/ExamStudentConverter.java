package lv.venta.ajkats.converters;

import lv.venta.ajkats.dto.ExamStudentDTO;
import lv.venta.ajkats.models.entities.ExamStudent;

public class ExamStudentConverter implements IDtoConverter<ExamStudent, ExamStudentDTO> {

    public ExamStudent convertToEntity(ExamStudentDTO dto) {
        final ExamStudent entity = new ExamStudent();
        entity.setId(dto.getId());
        entity.setStudent(dto.getStudent());
        entity.setExam(dto.getExam());
        dto.getExamResults().forEach(entity::addExamResult);

        return entity;
    }

    public ExamStudentDTO convertToDto(ExamStudent entity) {
        final ExamStudentDTO dto = new ExamStudentDTO();
        dto.setId(entity.getId());
        dto.setStudent(entity.getStudent());
        dto.setExam(entity.getExam());
        dto.setExamResults(entity.getExamResults());

        return dto;
    }
}
