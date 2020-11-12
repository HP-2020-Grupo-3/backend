package com.hp2020g3.venidemary.service;

import com.hp2020g3.venidemary.model.Role;
import com.hp2020g3.venidemary.model.Usuario;
import com.hp2020g3.venidemary.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

@Service
public class UsuarioService {
	
	@Autowired
	private RoleService roleService;
	
	
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Iterable<Usuario> findAll() {
    	    	               
        return usuarioRepository.findAll();
                        
    }
    
    public Iterable<Usuario> findByIsDeleted() {
    	
    	Iterable<Usuario> validUsers = usuarioRepository.findByIsDeleted(false);
    	return validUsers;
    	
    }

    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }
    
    //TODO id de usuario tiene que ser asignado manualmente al DTO antes de llamar a Save
    
    public Usuario save(Usuario usuario) {
    	
    	Optional<Role> role = roleService.findByName("Cliente");
    	
    	if (role.isPresent()) {
    		usuario.setRole(role.get());
    		return usuarioRepository.save(usuario);
       	} else {
       		// TODO: Tirar error de que no existe el rol para el usuario
    		return usuario;
    	}
    	
    	
        
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

    public Boolean deleteById(Integer id) {
    	Optional<Usuario> usuario = usuarioRepository.findById(id);
    	Date date = new Date();
    	
    	if (usuario.isPresent()) {
            usuario.get().setDeleted(true);
            usuario.get().setDeletionDate(date);
            this.save(usuario.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de usuario a eliminar
            return false;
        }
    }

    public Usuario getBaseDto() {
        return new Usuario();
    }
    
    public static<T> Iterable<T> iteratorToIterable(Iterator<T> iterator) {
        return () -> iterator;
    }
    
   
}
