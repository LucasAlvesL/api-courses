package com.courses.api.controller;

import com.courses.api.dto.CourseRequestDTO;
import com.courses.api.entity.CourseEntity;
import com.courses.api.service.CreateCourseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @GetMapping("/")
    public List<CourseEntity> getAllCourses() {
        return createCourseUseCase.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseEntity getCourseById(@PathVariable Long id) {
        return createCourseUseCase.getCourseById(id);
    }

    @PostMapping("/")
    public ResponseEntity<CourseEntity> createCourse(@RequestBody CourseRequestDTO courseDTO) {
        var result = createCourseUseCase.createCourse(courseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    public CourseEntity updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO courseDTO) {
        return createCourseUseCase.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        createCourseUseCase.deleteCourse(id);
    }

    @PatchMapping("/{id}/active")
    public CourseEntity toggleCourseStatus(@PathVariable Long id) {
        return createCourseUseCase.toggleCourseStatus(id);
    }
}
