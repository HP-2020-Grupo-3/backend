package com.hp2020g3.venidemary.service;

import com.hp2020g3.venidemary.model.Ciudad;
import com.hp2020g3.venidemary.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CiudadService {

    @Autowired
    CiudadRepository ciudadRepository;

    public Iterable<Ciudad> findAll() {

        return ciudadRepository.findAll();
    }

    public Optional<Ciudad> findById(Integer id) {

        return ciudadRepository.findById(id);
    }

    public Ciudad save(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public Ciudad update(Ciudad newCiudad) {
        Optional<Ciudad> ciudad =  this.findById(newCiudad.getId());

        if (ciudad.isPresent()) {
            ciudad.get().setNombre(newCiudad.getNombre());
            ciudad.get().setCodigoPostal(newCiudad.getCodigoPostal());
            return this.save(ciudad.get());
        } else {
            // TODO: Esto deberia tirar un error de que rubro que intetas actuializar no existe.
            newCiudad.setId(null);
            return this.save(newCiudad);
        }
    }

    public void deleteById(Integer id) {
        ciudadRepository.deleteById(id);
    }

    public Ciudad getBaseDto() {
        return new Ciudad();
    }
} 
