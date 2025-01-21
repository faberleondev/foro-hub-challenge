package com.ejemplo.forohub.domain.usuario.data;

import java.util.Set;

public record ModificarUsuario(
        String nombre,
        String correo,
        String contrasena,
        Set<String> roles) {
}
