package com.hp2020g3.venidemary.service;

import com.hp2020g3.venidemary.dto.ArticuloDto;
import com.hp2020g3.venidemary.dto.UsuarioDto;
import com.hp2020g3.venidemary.model.Role;
import com.hp2020g3.venidemary.model.Usuario;
import com.hp2020g3.venidemary.repository.UsuarioRepository;
import com.hp2020g3.venidemary.repository.RoleRepository;
import com.hp2020g3.venidemary.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

@Service
public class UsuarioService {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
    private RoleRepository roleRepository;
		
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

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
    
	public UsuarioDto findUsuarioDtoById(Integer id) {
	        
	    return new UsuarioDto(usuarioRepository.findById(id), roleService.findAll());
    }

    //TODO id de usuario tiene que ser asignado manualmente al DTO antes de llamar a Save
    public UsuarioDto save(UsuarioDto usuarioDto) {
    	
    	Optional<Role> role = null;
    	
    	if (usuarioDto.getCurrentRole() != null) {
    		role = roleService.findById(usuarioDto.getCurrentRole().getId());
       	}
    	
    	if (role == null || !role.isPresent()) {
    		role = roleService.getDefault();
    	}
    	
    	String password = passwordEncoder.encode(usuarioDto.getPassword());
    	usuarioDto.setPassword(password);
    	
    	Usuario usuario = new Usuario(usuarioDto, role.get());
    	
    	return new UsuarioDto( usuarioRepository.save(usuario), roleRepository.findAll());
    }

    public UsuarioDto update(UsuarioDto newUsuarioDto) {
        Optional<Usuario> usuario =  this.findById(newUsuarioDto.getId());
        System.out.println(usuario.get().getId());
        if (!usuario.isPresent()) {
            newUsuarioDto.setId(null);
        }
        
        return this.save(newUsuarioDto);
    }

    public Boolean deleteById(Integer id) {
    	Optional<Usuario> usuario = usuarioRepository.findById(id);
    	Date date = new Date();
    	
    	if (usuario.isPresent()) {
            usuario.get().setDeleted(true);
            usuario.get().setDeletionDate(date);
            this.usuarioRepository.save(usuario.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de usuario a eliminar
            return false;
        }
    }
        
    public UsuarioDto getBaseDto() {
    	Optional<Role> role = roleService.getDefault();
        
    	Usuario newUsuario = new Usuario();
    	if (role.isPresent()) {
    		newUsuario.setRole(role.get());
    	}
    	Iterable<Role> roleList = roleService.findAll();
    	return new UsuarioDto (newUsuario, roleList);
    }
    
    public static<T> Iterable<T> iteratorToIterable(Iterator<T> iterator) {
        return () -> iterator;
    }
}
