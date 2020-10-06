package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Permission;
import com.hp2020g3.venidemary.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping("/permission")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(permissionService.findAll());
    }

    @GetMapping("/permission/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.ok(permissionService.findById(id));
    }
    
    @GetMapping("/permission/base")
    public ResponseEntity getBaseDto() {

        return ResponseEntity.ok(permissionService.getBaseDto());
    }

    @PostMapping("/permission")
    public ResponseEntity save(@RequestBody Permission permission) {
        return ResponseEntity.ok(permissionService.save(permission));
    }

    @PutMapping("/permission")
    ResponseEntity update(@RequestBody Permission newPermission) {
        return ResponseEntity.ok(permissionService.update(newPermission));  
    }

    @DeleteMapping("/permission/{id}")
    ResponseEntity delete(@PathVariable Integer id) {
    	permissionService.deleteById(id);

        return ResponseEntity.ok("{}");
    }
}
 