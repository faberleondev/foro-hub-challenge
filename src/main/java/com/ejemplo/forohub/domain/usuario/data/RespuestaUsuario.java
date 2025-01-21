package com.ejemplo.forohub.domain.usuario.data;

import com.ejemplo.forohub.domain.usuario.Usuario;
import com.ejemplo.forohub.domain.usuario.perfil.Perfil;

import java.util.Set;

public record RespuestaUsuario(
        Long id,
        String nombre,
        String correo,
        Set<Perfil> roles) {

    public RespuestaUsuario (Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getRoles());
    }
}
