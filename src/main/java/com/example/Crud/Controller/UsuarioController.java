package com.example.Crud.Controller;

import com.example.Crud.Entity.Usuario;
import com.example.Crud.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/obtenerTodos/")
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/obtenerId/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @PostMapping("/guardar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        // Verificar si el usuario con el ID dado existe
        Optional<Usuario> usuarioExistente = usuarioService.obtenerUsuarioPorId(id);

        if (usuarioExistente.isPresent()) {
            // Actualizar las propiedades del usuario existente con los datos del cuerpo de la solicitud
            Usuario usuarioActualizado = usuarioExistente.get();
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setCorreo(usuario.getCorreo());
            usuarioActualizado.setFechaCreacion(usuario.getFechaCreacion());
            usuarioActualizado.setFechaActualizacion(usuario.getFechaActualizacion());
            usuarioActualizado.setFechaEliminacion(usuario.getFechaEliminacion());
            usuarioActualizado.setIndicador(usuario.getIndicador());

            // Guardar el usuario actualizado en la base de datos
            Usuario usuarioGuardado = usuarioService.guardarUsuario(usuarioActualizado);

            return ResponseEntity.ok(usuarioGuardado);
        } else {
            // El usuario con el ID dado no existe, devolver una respuesta de error
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
