package com.ejemplo.forohub.domain.curso.data;

import com.ejemplo.forohub.domain.curso.Categoria;

public record ActualizarCurso(
        String nombre,
        Categoria categoria) {
}
