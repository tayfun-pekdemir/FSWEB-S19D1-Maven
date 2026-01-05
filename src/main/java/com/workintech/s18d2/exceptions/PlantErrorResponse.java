package com.workintech.s18d2.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PlantErrorResponse {

    private String message;

    public PlantErrorResponse(String message) {
        this.message = message;
    }
}
