package com.ejemplo.forohub.domain.topico.validations;

import com.ejemplo.forohub.domain.ValidacionException;
import com.ejemplo.forohub.domain.topico.TopicoRepository;
import com.ejemplo.forohub.domain.topico.data.RegistroTopico;
import org.springframework.stereotype.Component;

@Component
public class ValidacionTopicoRegistroTopico implements ValidadorDeRegistroTopico {

    private TopicoRepository topicoRepository;

    public ValidacionTopicoRegistroTopico(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public void validar(RegistroTopico datos) {
        if (topicoRepository.existsTopicoByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new ValidacionException("Topico ya existe");
        }
    }
}
