package com.ejemplo.forohub.domain.respuesta.Validations;

import com.ejemplo.forohub.domain.ValidacionException;
import com.ejemplo.forohub.domain.respuesta.RespuestaRepository;
import com.ejemplo.forohub.domain.respuesta.data.RegistrarRespuesta;
import org.springframework.stereotype.Component;

@Component("Validar si tiene mas de 2 respuestas en el mismo topico")
public class ValidarCantidadDeRespuestas implements ValidadorDeRegisroRespuesta{

    private RespuestaRepository respuestaRepository;

    public ValidarCantidadDeRespuestas(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    @Override
    public void validar(RegistrarRespuesta datos) {
        int cantidadDeRespuestas = respuestaRepository.cantidadDeRespuestasEnUnTopico(datos.idTopico());

        if (cantidadDeRespuestas > 2){
            throw new ValidacionException("No puedes registrar mas de dos respuestas en el mismo topico");
        }

    }
}
