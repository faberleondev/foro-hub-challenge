package com.ejemplo.forohub.domain.topico;

import com.ejemplo.forohub.domain.curso.Curso;
import com.ejemplo.forohub.domain.topico.data.ActualizarTopico;
import com.ejemplo.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "topicos")
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor")
    private Usuario autor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso")
    private Curso curso;
    private Integer respuestas;

    public void actualizarDatosTopico(ActualizarTopico actualizarTopico) {
        if (actualizarTopico.titulo() != null) this.titulo = actualizarTopico.titulo();
        if (actualizarTopico.mensaje() != null) this.mensaje = actualizarTopico.mensaje();
    }

    public void aumentarRespuestas() {
        this.respuestas++;
    }
}
