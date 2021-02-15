package com.hp2020g3.venidemary.service;

import com.hp2020g3.venidemary.model.Rubro;
import com.hp2020g3.venidemary.repository.RubroRepository;
import com.hp2020g3.venidemary.utils.Constants;
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

    public Optional<Rubro> getDefault() {
        return rubroRepository.findById(Constants.DEFAULT_RUBRO_ID);
    }

    public Optional<Rubro> findByNombre(String nombre) {

        return rubroRepository.findByNombre(nombre);
    }

    public Rubro save(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    public Rubro update(Rubro newRubro) {
        Optional<Rubro> rubro =  this.findById(newRubro.getId());

        if (rubro.isPresent()) {
            rubro.get().setNombre(newRubro.getNombre());
            return this.save(rubro.get());
        } else {
            // TODO: Esto deberia tirar un error de que rubro que intetas actuializar no existe.
            newRubro.setId(null);
            return this.save(newRubro);
        }
    }

    public void deleteById(Integer id) {
        rubroRepository.deleteById(id);
    }

    public Rubro getBaseDto() {
        return new Rubro();
    }
}
