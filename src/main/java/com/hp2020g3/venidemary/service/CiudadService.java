package com.hp2020g3.venidemary.service;

import java.util.List;

import com.hp2020g3.venidemary.model.Ciudad;
import com.hp2020g3.venidemary.repository.CiudadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadService {

    @Autowired
    CiudadRepository ciudadRepository;

    public List<Ciudad> findByName(String name) {
        return ciudadRepository.findByNombre(name);
    }

    public java.util.Optional<Ciudad> findById(Integer id) {
        return ciudadRepository.findById(id);
    }
}
