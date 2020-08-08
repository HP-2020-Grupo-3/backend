package com.hp2020g3.venidemary.service;

import java.util.List;

import com.hp2020g3.venidemary.model.Provincia;
import com.hp2020g3.venidemary.repository.ProvinciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService {

    @Autowired
    ProvinciaRepository provinciaRepository;

    public List<Provincia> findByName(String name) {
        return provinciaRepository.findByNombre(name);
    }

    public java.util.Optional<Provincia> findById(Integer id) {
        return provinciaRepository.findById(id);
    }
}
