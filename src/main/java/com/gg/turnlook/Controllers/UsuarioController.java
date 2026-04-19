package com.gg.turnlook.Controllers;

import com.gg.turnlook.Model.Usuario;
import com.gg.turnlook.Service.UsuarioService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /// ENDPOINTS

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario u) {
        try{
            usuarioService.crearUsuario(u);
            return ResponseEntity.ok().body("Se creo al usuario");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error al crear usuario");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios() {
        try{
            return ResponseEntity.ok().body(usuarioService.listarUsuarios());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error al listar usuarios");
        }
    }

    @GetMapping("/listar/email")
    public ResponseEntity<?> listarUsuariosPorEmail(@RequestParam String email){
        try{
            Optional<Usuario> u = usuarioService.listarUsuariosPorEmail(email);
            if(u.isPresent()){
                return ResponseEntity.ok().body(u.get());
            } else{
                return ResponseEntity.status(404).body("Usuario NO encontrado");
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error al listar usuarios por email");
        }
    }
}
