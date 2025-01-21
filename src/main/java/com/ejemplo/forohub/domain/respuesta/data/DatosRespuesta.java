package com.ejemplo.forohub.domain.respuesta.data;

import com.ejemplo.forohub.domain.respuesta.Respuesta;
import java.time.LocalDateTime;

public record DatosRespuesta(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor,
        Boolean solucion) {

    public DatosRespuesta(Respuesta respuesta) {
        this(respuesta.getId() , respuesta.getMensaje(), respuesta.getFechaCreacion(),
                respuesta.getAutor().getNombre(), respuesta.getSolucion());
    }
}
