package com.courses.IITB.controllers;

import com.courses.IITB.modal.Course;
import com.courses.IITB.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Create a new course
    @PostMapping("/addcourse")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    // List all courses available
    @GetMapping("/getcourselist")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/getcourse/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    // Delete a course with a specific ID
    @DeleteMapping("/deletecourse/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}
