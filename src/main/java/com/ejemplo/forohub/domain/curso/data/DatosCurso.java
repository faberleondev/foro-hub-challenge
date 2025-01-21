package com.ejemplo.forohub.domain.curso.data;

import com.ejemplo.forohub.domain.curso.Categoria;
import com.ejemplo.forohub.domain.curso.Curso;

public record DatosCurso(
        Long id,
        String nombre,
        Categoria categoria) {

    public DatosCurso (Curso curso){
        this(curso.getId(), curso.getNombre(),curso.getCategoria());
    }
}
