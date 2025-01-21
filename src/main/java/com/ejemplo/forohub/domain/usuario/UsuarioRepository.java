package com.ejemplo.forohub.domain.usuario;

import com.ejemplo.forohub.domain.usuario.perfil.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByNombre(String nombre);

    boolean existsByIdAndRolesNombre(Long id, Rol rol);

}
