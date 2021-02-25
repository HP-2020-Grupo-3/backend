package com.hp2020g3.venidemary.service;

import com.hp2020g3.venidemary.model.Role;
import com.hp2020g3.venidemary.repository.RoleRepository;
import com.hp2020g3.venidemary.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }
    
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
    
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Role update(Role newRole) {
        Optional<Role> role =  this.findById(newRole.getId());

        if (role.isPresent()) {
            role.get().setName(newRole.getName());
            return this.save(role.get());
        } else {
            // TODO: Esto deberia tirar un error de que rubro que intetas actuializar no existe.
            newRole.setId(null);
            return this.save(newRole);
        }
    }

    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
    }

    public Role getBaseDto() {
        return new Role();
    }
    
    public Optional<Role> getDefault(){
    	return roleRepository.findById(Constants.DEFAULT_ROLE_ID);
    }
} 

