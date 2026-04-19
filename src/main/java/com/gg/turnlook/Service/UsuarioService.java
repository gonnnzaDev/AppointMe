package com.gg.turnlook.Service;

import com.gg.turnlook.Model.Usuario;
import com.gg.turnlook.Repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usRepo;
    private final PasswordEncoder passEncoder;

    public UsuarioService(UsuarioRepository usRepo, PasswordEncoder passEncoder) {
        this.usRepo = usRepo;
        this.passEncoder = passEncoder;
    }

    public Usuario crearUsuario(Usuario u) {
        u.setPassword(passEncoder.encode(u.getPassword()));
        return usRepo.save(u);
    }

    public List<Usuario> listarUsuarios(){
        return usRepo.findAll();
    }

    public Optional<Usuario> listarUsuariosPorEmail(String email){
        return usRepo.findByEmail(email);
    }
}
