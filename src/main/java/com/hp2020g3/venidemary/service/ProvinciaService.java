package com.hp2020g3.venidemary.service;

import com.hp2020g3.venidemary.model.Provincia;
import com.hp2020g3.venidemary.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Provincia save(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    public Provincia update(Provincia newProvincia) {
        Optional<Provincia> provincia =  this.findById(newProvincia.getId());

        if (provincia.isPresent()) {
            provincia.get().setNombre(newProvincia.getNombre());
            return this.save(provincia.get());
        } else {
            // TODO: Esto deberia tirar un error de que rubro que intetas actuializar no existe.
            newProvincia.setId(null);
            return this.save(newProvincia);
        }
    }

    public void deleteById(Integer id) {
        provinciaRepository.deleteById(id);
    }

    public Provincia getBaseDto() {
        return new Provincia();
    }
}
 