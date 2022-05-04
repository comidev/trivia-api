package comidev.triviaapi.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comidev.triviaapi.exceptions.badrequest.BadRequestException;
import comidev.triviaapi.exceptions.conflict.ConflictException;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepo usuarioRepo;
    private final int MAX_SCORE = 20;

    public boolean existsUsuario(String username) {
        return usuarioRepo.findByUsername(username) != null;
    }

    public boolean registrar(Usuario registrar) {
        Usuario usuario = usuarioRepo.findByUsername(registrar.getUsername());
        if (usuario == null) {
            if (registrar.getPuntaje() <= MAX_SCORE) {
                usuarioRepo.save(registrar);
                return true;
            } else {
                throw new BadRequestException("Puntaje fuera del limite");
            }
        } else {
            throw new ConflictException("Usuario ya existente");
        }
    }

    public List<Usuario> getUsers() {
        List<Usuario> usuarios = usuarioRepo.findAll();
        return usuarios != null ? sortByScoreAndTime(usuarios) : null;
    }

    public List<Usuario> getUsersByCategory(String category) {
        List<Usuario> usuariosByCategory = usuarioRepo.findAllByCategory(category);
        return usuariosByCategory != null ? sortByScoreAndTime(usuariosByCategory) : null;
    }

    private List<Usuario> sortByScoreAndTime(List<Usuario> usuarios) {
        usuarios.sort((a, b) -> {
            if (a.getPuntaje() != b.getPuntaje()) {
                if (a.getPuntaje() < b.getPuntaje()) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                if (a.getTime() > b.getTime()) {
                    return 1;
                } else if (a.getTime() == b.getTime()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return usuarios;
    }
}
