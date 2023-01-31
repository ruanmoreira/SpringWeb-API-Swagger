package dio.webapiswagger.controller;

import dio.webapiswagger.model.Usuario;
import dio.webapiswagger.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @GetMapping("/")
    public List<Usuario> getUsers() {
        return repository.findAll();
    }
    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id)")
    public void delete(@PathVariable("id") Integer id) {
        repository.delete(id);
    }

    @PostMapping("/")
    public void postUser(Usuario usuario) {
        repository.save(usuario);
    }
}
