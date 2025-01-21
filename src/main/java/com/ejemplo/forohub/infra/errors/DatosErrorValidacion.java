package com.ejemplo.forohub.infra.errors;

import org.springframework.validation.FieldError;

public record DatosErrorValidacion(String campo, String error){

    public DatosErrorValidacion(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
