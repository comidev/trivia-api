package comidev.triviaapi.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private Integer puntaje;
    private String category;
    private Float time;

    public Usuario() {
    }

    public Usuario(String username, Integer puntaje, String category, Float time) {
        this.username = username;
        this.puntaje = puntaje;
        this.category = category;
        this.time = time;
    }
}
