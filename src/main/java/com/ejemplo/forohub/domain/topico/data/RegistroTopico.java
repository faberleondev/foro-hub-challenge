package com.ejemplo.forohub.domain.topico.data;

import jakarta.validation.constraints.NotNull;

public record RegistroTopico(
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        Long idCurso) {
}
