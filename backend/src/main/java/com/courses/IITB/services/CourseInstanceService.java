package com.courses.IITB.services;

import com.courses.IITB.modal.CourseInstance;
import com.courses.IITB.repository.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseInstanceService {

    private final CourseInstanceRepository courseInstanceRepository;

    @Autowired
    public CourseInstanceService(CourseInstanceRepository courseInstanceRepository) {
        this.courseInstanceRepository = courseInstanceRepository;
    }

    public CourseInstance createCourseInstance(CourseInstance courseInstance) {
        courseInstance.getCourseId().setCourseCode(courseInstance.getCourseId().getCourseCode());
        courseInstance.getCourseId().setCourseTitle(courseInstance.getCourseId().getCourseTitle());
        courseInstance.getCourseId().setCourseDesc(courseInstance.getCourseId().getCourseDesc());
        return courseInstanceRepository.save(courseInstance);
    }

    public List<CourseInstance> getCourseInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByCourseYearAndCourseSem(year, semester);
    }

    public CourseInstance getCourseInstanceBycourseIdAndYearAndSemester(int id, int year, int semester) {
        Optional<CourseInstance> optionalCourseInstance = courseInstanceRepository.findByCourseId_IdAndCourseYearAndCourseSem(id, year, semester);
        return optionalCourseInstance.orElse(null);
    }

    public void deleteCourseInstanceByIdAndYearAndSemester(int id, int year, int semester) {
        courseInstanceRepository.deleteByCourseId_IdAndCourseYearAndCourseSem(id, year, semester);
    }
    public List<CourseInstance> getAllCoursesInstances() {
        return courseInstanceRepository.findAll();
    }
}
