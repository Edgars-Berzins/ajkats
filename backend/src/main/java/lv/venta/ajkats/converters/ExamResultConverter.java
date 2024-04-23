package lv.venta.ajkats.converters;

import lv.venta.ajkats.dto.ExamResultDTO;
import lv.venta.ajkats.models.entities.ExamResult;

public class ExamResultConverter implements IDtoConverter<ExamResult, ExamResultDTO> {

    public ExamResult convertToEntity(ExamResultDTO dto) {
        final ExamResult entity = new ExamResult();
        entity.setId(dto.getId());
        entity.setEarnedPoints(dto.getEarnedPoints());
        entity.setExamStudent(dto.getExamStudent());
        entity.setTask(dto.getTask());

        return entity;
    }

    public ExamResultDTO convertToDto(ExamResult entity) {
        final ExamResultDTO dto = new ExamResultDTO();
        dto.setId(entity.getId());
        dto.setEarnedPoints(entity.getEarnedPoints());
        dto.setExamStudent(entity.getExamStudent());
        dto.setTask(entity.getTask());

        return dto;
    }
}
