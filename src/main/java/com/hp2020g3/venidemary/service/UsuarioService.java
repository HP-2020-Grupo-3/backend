package com.hp2020g3.venidemary.service;

import com.hp2020g3.venidemary.model.Usuario;
import com.hp2020g3.venidemary.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }
    
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario newUsuario) {
        Optional<Usuario> usuario =  this.findById(newUsuario.getId());

        if (usuario.isPresent()) {
            usuario.get().setNombre(newUsuario.getNombre());
            usuario.get().setPassword(newUsuario.getPassword());
            usuario.get().setEmail(newUsuario.getEmail());
            usuario.get().setRole(newUsuario.getRole());
            usuario.get().setDirecciones(newUsuario.getDirecciones());
            return this.save(usuario.get());
        } else {
            // TODO: Esto deberia tirar un error de que rubro que intetas actuializar no existe.
            newUsuario.setId(null);
            return this.save(newUsuario);
        }
    }

    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario getBaseDto() {
        return new Usuario();
    }
}
