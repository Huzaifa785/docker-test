package com.courses.IITB.repository;

import com.courses.IITB.modal.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Integer> {

    List<CourseInstance> findByCourseYearAndCourseSem(int courseYear, int courseSem);

    Optional<CourseInstance> findByCourseId_IdAndCourseYearAndCourseSem(int id, int courseYear, int courseSem);

    void deleteByCourseId_IdAndCourseYearAndCourseSem(int id, int courseYear, int courseSem);
}
