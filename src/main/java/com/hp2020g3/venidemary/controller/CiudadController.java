package com.hp2020g3.venidemary.controller;

import com.hp2020g3.venidemary.model.Ciudad;
import com.hp2020g3.venidemary.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CiudadController {
	@Autowired
	CiudadService ciudadService;

    @GetMapping("/ciudad")
    public ResponseEntity getCiudadById(@RequestParam(value="id") Integer id) {
        return ResponseEntity.ok(ciudadService.findById(id));
    }

}
