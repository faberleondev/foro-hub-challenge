package com.ejemplo.forohub.domain.curso;

import com.ejemplo.forohub.domain.curso.data.ActualizarCurso;
import com.ejemplo.forohub.domain.curso.data.RegistrarCurso;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "curso")
@Table(name = "cursos")
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(RegistrarCurso registrarCurso) {
        this.nombre = registrarCurso.nombre();
        this.categoria = registrarCurso.categoria();
    }

    public final void actualizar(ActualizarCurso actualizarCurso) {
        if (actualizarCurso.nombre() != null) this.nombre = actualizarCurso.nombre();
        if (actualizarCurso.categoria() != null) this.categoria = actualizarCurso.categoria();
    }
}
