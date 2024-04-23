package lv.venta.ajkats.converters;

import lv.venta.ajkats.dto.StudyProgramDTO;
import lv.venta.ajkats.models.entities.StudyProgram;

public class StudyProgramConverter implements IDtoConverter<StudyProgram, StudyProgramDTO> {

    public StudyProgram convertToEntity(StudyProgramDTO dto) {
        final StudyProgram entity = new StudyProgram();
        entity.setId(dto.getId());
        entity.setStudyProgramTitleLv(dto.getStudyProgramTitleLv());
        entity.setFaculty(dto.getFaculty());
        entity.setLevelOfStudy(dto.getLevelOfStudy());
        entity.setStudyLanguage(dto.getStudyLanguage());
        dto.getCourses().forEach(entity::addCourse);

        return entity;
    }

    public StudyProgramDTO convertToDto(StudyProgram entity) {
        final StudyProgramDTO dto = new StudyProgramDTO();
        dto.setId(entity.getId());
        dto.setStudyProgramTitleLv(entity.getStudyProgramTitleLv());
        dto.setFaculty(entity.getFaculty());
        dto.setLevelOfStudy(entity.getLevelOfStudy());
        dto.setStudyLanguage(entity.getStudyLanguage());
        dto.setCourses(entity.getCourses());

        return dto;
    }
}
