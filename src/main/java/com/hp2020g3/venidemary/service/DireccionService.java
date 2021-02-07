package com.hp2020g3.venidemary.service;

import com.hp2020g3.venidemary.model.Direccion;
import com.hp2020g3.venidemary.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional; 

@Service
public class DireccionService {

    @Autowired
    DireccionRepository direccionRepository;

    public Iterable<Direccion> findAll() {

        return direccionRepository.findAll();
    }

    public Optional<Direccion> findById(Integer id) {

        return direccionRepository.findById(id);
    }

    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public Direccion update(Direccion newDireccion) {
        Optional<Direccion> direccion =  this.findById(newDireccion.getId());

        if (direccion.isPresent()) {
            direccion.get().setCalle(newDireccion.getCalle());
            direccion.get().setNumero(newDireccion.getNumero());
            direccion.get().setDetalle(newDireccion.getDetalle());
            // TODO: Debería guardar el usuario de la dirección???
            return this.save(direccion.get());
        } else {
            // TODO: Esto deberia tirar un error de que rubro que intetas actuializar no existe.
            newDireccion.setId(null);
            return this.save(newDireccion);
        }
    }

    public void deleteById(Integer id) {
        direccionRepository.deleteById(id);
    }

    public Direccion getBaseDto() {
        return new Direccion();
    } 
}