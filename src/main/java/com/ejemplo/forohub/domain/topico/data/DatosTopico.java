package com.ejemplo.forohub.domain.topico.data;

import com.ejemplo.forohub.domain.curso.data.DatosCurso;
import com.ejemplo.forohub.domain.topico.Topico;
import java.time.LocalDateTime;

public record DatosTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean status,
        DatosCurso datosCurso,
        Integer respuestas) {

    public DatosTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),
                new DatosCurso(topico.getId(), topico.getCurso().getNombre(), topico.getCurso().getCategoria()),
                topico.getRespuestas());
    }
}
