package com.ejemplo.forohub.domain.curso.data;

import com.ejemplo.forohub.domain.curso.Categoria;
import jakarta.validation.constraints.NotNull;

public record RegistrarCurso (
        @NotNull
        String nombre,
        @NotNull
        Categoria categoria
){
}
