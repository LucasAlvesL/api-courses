package com.courses.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CourseRequestDTO(@NotBlank String name, @NotBlank String category) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public String category() {
        return category;
    }
}
