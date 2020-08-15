package com.hp2020g3.venidemary.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp2020g3.venidemary.model.Provincia;
import com.hp2020g3.venidemary.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

    @Autowired
    ProvinciaRepository provinciaRepository;

    public Iterable<Provincia> findAll() {
        return provinciaRepository.findAll();
    }

    public Optional<Provincia> findById(Integer id) {
        return provinciaRepository.findById(id);
    }
}
