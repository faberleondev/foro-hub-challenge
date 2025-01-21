package com.ejemplo.forohub.controller;

import com.ejemplo.forohub.domain.usuario.UsuarioService;
import com.ejemplo.forohub.domain.usuario.data.CrearUsuario;
import com.ejemplo.forohub.domain.usuario.data.ModificarUsuario;
import com.ejemplo.forohub.domain.usuario.data.RespuestaUsuario;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Crear Usuario
    @PostMapping
    public ResponseEntity crearUsuario(@Valid @RequestBody CrearUsuario crearUsuario, UriComponentsBuilder builder) {
        RespuestaUsuario usuario = usuarioService.registrarUsuario(crearUsuario);
        URI uri = builder.path("/usuarios/{id}").buildAndExpand(usuario.id()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    //Actualizar Usuario
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity modificarUsuario(@PathVariable Long id, @RequestBody ModificarUsuario datos) {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(id, datos));
    }

}
