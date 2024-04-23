package lv.venta.ajkats;

import lv.venta.ajkats.models.entities.*;
import lv.venta.ajkats.models.enums.Faculty;
import lv.venta.ajkats.models.enums.LevelOfStudy;
import lv.venta.ajkats.models.enums.StudyLanguage;
import lv.venta.ajkats.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KvaldarbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KvaldarbsApplication.class, args);
    }

    @Bean
    public CommandLineRunner testModelLayer(
            final ICourseRepository courseRepository,
            final IExamRepository examRepository,
            final IExamResultRepository examResultRepository,
            final IExamStudentRepository examStudentRepository,
            final IStudentRepository studentRepository,
            final IStudyProgramRepository studyProgramRepository,
            final ITaskRepository taskRepository
    ) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                Student s1 = new Student("Jānis", "Bērziņš", "12345678");
                Student s2 = new Student("Baiba", "Kalniņa", "12245679");
                studentRepository.save(s1);
                studentRepository.save(s2);

                StudyProgram studyProgram1 = new StudyProgram(
                        "Programmēšanas speciālists",
                        Faculty.ITF,
                        LevelOfStudy.FIRST_LEVEL,
                        StudyLanguage.LATVIAN);
                StudyProgram studyProgram2 = new StudyProgram(
                        "Datorzinātnes",
                        Faculty.ITF,
                        LevelOfStudy.BACHELOR,
                        StudyLanguage.LATVIAN);
                studyProgramRepository.save(studyProgram1);
                studyProgramRepository.save(studyProgram2);

                Course c1 = new Course("Java", 4, LevelOfStudy.FIRST_LEVEL, studyProgram1);
                Course c2 = new Course("English", 2, LevelOfStudy.BACHELOR, studyProgram2);
                courseRepository.save(c1);
                courseRepository.save(c2);

                Task t1 = new Task("Testing task description", 5.5F);
                Task t2 = new Task("A different task description", 11F);
                taskRepository.save(t1);
                taskRepository.save(t2);

                Exam e1 = new Exam("Testing exam title", c2);
                Exam e2 = new Exam("A different exam title", c1);
                examRepository.save(e1);
                examRepository.save(e2);

                ExamStudent es1 = new ExamStudent(s1, e1);
                ExamStudent es2 = new ExamStudent(s2, e1);
                examStudentRepository.save(es1);
                examStudentRepository.save(es2);

                ExamResult er1 = new ExamResult(3.4F, es1, t1);
                ExamResult er2 = new ExamResult(7.7F, es1, t2);
                ExamResult er3 = new ExamResult(5.5F, es2, t1);
                ExamResult er4 = new ExamResult(10.1F, es2, t2);
                examResultRepository.save(er1);
                examResultRepository.save(er2);
                examResultRepository.save(er3);
                examResultRepository.save(er4);

                s1.addCourse(c1);
                s1.addCourse(c2);
                s2.addCourse(c1);
                s2.addCourse(c2);
                studentRepository.save(s1);
                studentRepository.save(s2);
            }
        };

    }
}
