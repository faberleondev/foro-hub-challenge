package com.ejemplo.forohub.domain.curso.data;
import com.ejemplo.forohub.domain.curso.Curso;

public record ListaNombreCurso(
        long id,
        String nombre) {

    public ListaNombreCurso (Curso curso){
        this(curso.getId(), curso.getNombre());
    }
}
