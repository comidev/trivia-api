package comidev.triviaapi.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);

    public List<Usuario> findAllByCategory(String category);
}
