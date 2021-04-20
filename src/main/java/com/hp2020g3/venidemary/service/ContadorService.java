package com.hp2020g3.venidemary.service;

import com.hp2020g3.venidemary.exception.EntityNotFoundException;
import com.hp2020g3.venidemary.model.Contador;
import com.hp2020g3.venidemary.repository.ContadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContadorService {

    @Autowired
    ContadorRepository contadorRepository;

    public Contador findByNombre(String nombre) {
        Optional<Contador> contador = contadorRepository.findByNombre(nombre);

        if (!contador.isPresent()) {
            throw new EntityNotFoundException("El contador '" + nombre + "' no existe.");
        }

        return contador.get();
    }

    public Integer getValor(String nombre) {
        return this.findByNombre(nombre).getValor();
    }

    public Contador increaseAndSave(String nombre) {
        Contador contador = this.findByNombre(nombre);
        contador.setValor(contador.getValor() + 1);

        return contadorRepository.save(contador);
    }
}
