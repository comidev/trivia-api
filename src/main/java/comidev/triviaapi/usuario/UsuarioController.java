package comidev.triviaapi.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/username/{username}")
    public ResponseEntity<Boolean> existsUsername(@PathVariable String username) {
        boolean exists = usuarioService.existsUsuario(username);
        return ResponseEntity.ok(exists);
    }

    @PostMapping
    public ResponseEntity<Boolean> registrar(@RequestBody Usuario usuario) {
        boolean response = usuarioService.registrar(usuario);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsersByCategory(@RequestParam String category) {
        List<Usuario> usuarios = usuarioService.getUsersByCategory(category);
        return usuarios != null ? ResponseEntity.ok(usuarios) : ResponseEntity.noContent().build();
    }

    @GetMapping("/global")
    public ResponseEntity<List<Usuario>> getUsersGlobal() {
        List<Usuario> usuarios = usuarioService.getUsers();
        return usuarios != null ? ResponseEntity.ok(usuarios) : ResponseEntity.noContent().build();
    }
}
