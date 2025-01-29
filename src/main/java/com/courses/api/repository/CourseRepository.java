package com.courses.api.repository;

import com.courses.api.dto.CourseRequestDTO;
import com.courses.api.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
