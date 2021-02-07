package com.hp2020g3.venidemary.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.model.Permission;
import com.hp2020g3.venidemary.repository.PermissionRepository;

@Service
public class PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    public Iterable<Permission> findAll() {
        return permissionRepository.findAll();
    }

    public Optional<Permission> findById(Integer id) {
        return permissionRepository.findById(id);
    }
    
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Permission update(Permission newPermission) {
        Optional<Permission> permission =  this.findById(newPermission.getId());

        if (permission.isPresent()) {
        	permission.get().setName(newPermission.getName());
            return this.save(permission.get());
        } else {
            // TODO: Esto deberia tirar un error de que rubro que intetas actuializar no existe.
            newPermission.setId(null);
            return this.save(newPermission);
        }
    }

    public void deleteById(Integer id) {
        permissionRepository.deleteById(id);
    }

    public Permission getBaseDto() {
        return new Permission();
    }
}
