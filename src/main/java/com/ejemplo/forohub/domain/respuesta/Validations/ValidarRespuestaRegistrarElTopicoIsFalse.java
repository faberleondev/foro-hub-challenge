package com.ejemplo.forohub.domain.respuesta.Validations;

import com.ejemplo.forohub.domain.ValidacionException;
import com.ejemplo.forohub.domain.respuesta.data.RegistrarRespuesta;
import com.ejemplo.forohub.domain.topico.TopicoRepository;
import org.springframework.stereotype.Component;

@Component("Validar si se esta registrando en un topico con status false")
public class ValidarRespuestaRegistrarElTopicoIsFalse implements ValidadorDeRegisroRespuesta {

    private final TopicoRepository topicoRepository;

    public ValidarRespuestaRegistrarElTopicoIsFalse(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @Override
    public final void validar(RegistrarRespuesta datos){
        if (topicoRepository.retornarStatusTopico(datos.idTopico())){
            throw new ValidacionException("El topico ya se marco como resuelto no se puede registrar mas respuestas");
        }
    }
}
