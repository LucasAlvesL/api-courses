package com.courses.api.service;

import com.courses.api.dto.CourseRequestDTO;
import com.courses.api.entity.CourseEntity;
import com.courses.api.entity.CourseStatus;
import com.courses.api.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    private CourseEntity convertToEntity(CourseRequestDTO courseDTO) {
        var courseModel = new CourseEntity();
        BeanUtils.copyProperties(courseDTO, courseModel);
        courseModel.setActive(CourseStatus.ACTIVE);
        return courseModel;
    }

    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseEntity getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    public CourseEntity createCourse(CourseRequestDTO courseDTO) {
        return courseRepository.save(convertToEntity(courseDTO));
    }

    public CourseEntity updateCourse(Long id, CourseRequestDTO courseDTO) {
        CourseEntity course = courseRepository.findById(id).orElseThrow();
        course.setName(courseDTO.name());
        course.setCategory(courseDTO.category());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public CourseEntity toggleCourseStatus(Long id) {
        CourseEntity course = courseRepository.findById(id).orElseThrow();
        course.setActive(course.getActive() == CourseStatus.ACTIVE ? CourseStatus.INACTIVE : CourseStatus.ACTIVE);
        return courseRepository.save(course);
    }
}
