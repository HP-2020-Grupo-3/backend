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
}
