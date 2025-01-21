package com.ejemplo.forohub.domain.respuesta.data;

import jakarta.validation.constraints.NotNull;

public record RegistrarRespuesta(
        @NotNull
        String mensaje,
        @NotNull
        Long idTopico) {
}
