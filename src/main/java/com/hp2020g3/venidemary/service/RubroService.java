package com.hp2020g3.venidemary.service;

import com.hp2020g3.venidemary.model.Rubro;
import com.hp2020g3.venidemary.repository.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RubroService {

    @Autowired
    RubroRepository rubroRepository;

    public Iterable<Rubro> findAll() {
        return rubroRepository.findAll();
    }

    public Optional<Rubro> findById(Integer id) {
        return rubroRepository.findById(id);
    }

    public Rubro save(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    public Rubro update(Rubro newRubro, Integer id) {
        Optional<Rubro> rubro =  this.findById(id);

        if (rubro.isPresent()) {
            rubro.get().setNombre(newRubro.getNombre());
            return this.save(rubro.get());
        } else {
            newRubro.setId(null);
            return this.save(newRubro);
        }
    }

    public void deleteById(Integer id) {
        rubroRepository.deleteById(id);
    }
}
