package com.ejemplo.forohub.domain.usuario;

import com.ejemplo.forohub.domain.ValidacionException;
import com.ejemplo.forohub.domain.respuesta.RespuestaRepository;
import com.ejemplo.forohub.domain.topico.TopicoRepository;
import com.ejemplo.forohub.domain.usuario.data.CrearUsuario;
import com.ejemplo.forohub.domain.usuario.data.ModificarUsuario;
import com.ejemplo.forohub.domain.usuario.data.RespuestaUsuario;
import com.ejemplo.forohub.domain.usuario.perfil.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, TopicoRepository topicoRepository, RespuestaRepository respuestaRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.topicoRepository = topicoRepository;
        this.respuestaRepository = respuestaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void verificarRol(String permiso) {
        var usuarioAutenticado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!usuarioRepository.existsByIdAndRolesNombre(usuarioAutenticado.getId(), Rol.ADMINISTRADOR)){
            throw new ValidacionException("El usuario no tiene permisos para " + permiso);
        }
    }

    public RespuestaUsuario registrarUsuario(CrearUsuario datos) {
        verificarRol("registrar usuario");
        Usuario usuario = new Usuario(datos);
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        usuarioRepository.save(usuario);
        return new RespuestaUsuario(usuario);
    }

    public RespuestaUsuario actualizarUsuario(Long id, ModificarUsuario datos) {
        verificarRol("actualizar usuario");
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()){
            throw new ValidacionException("El usuario no existe");
        }
        Usuario usuarioActualizado = usuario.get();
        usuarioActualizado.actualizardatos(datos, passwordEncoder);
        return new RespuestaUsuario(usuarioActualizado);
    }


}
