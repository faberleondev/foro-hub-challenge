package com.ejemplo.forohub.domain.topico.data;

import com.ejemplo.forohub.domain.curso.data.DatosCurso;
import com.ejemplo.forohub.domain.topico.Topico;
import java.time.LocalDateTime;

public record RespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean status,
        String usuario,
        DatosCurso curso,
        Integer respuestas
) {
    public RespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),
                topico.getAutor().getNombre(),
                new DatosCurso(topico.getId(),topico.getCurso().getNombre(), topico.getCurso().getCategoria()),
                topico.getRespuestas());
    }
}
