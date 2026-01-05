package com.workintech.s18d2.validations;

import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;

public class PlantValidation {


    public static void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new PlantException("Plant id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
    }


    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new PlantException("Plant name cannot be empty",HttpStatus.BAD_REQUEST);
        }
    }

}