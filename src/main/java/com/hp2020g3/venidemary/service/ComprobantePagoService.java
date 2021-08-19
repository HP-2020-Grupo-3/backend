package com.hp2020g3.venidemary.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp2020g3.venidemary.dto.ComprobantePagoDto;
import com.hp2020g3.venidemary.model.ComprobantePago;
import com.hp2020g3.venidemary.model.Venta;
import com.hp2020g3.venidemary.repository.ComprobantePagoRepository;
import com.hp2020g3.venidemary.repository.VentaRepository;

@Service
public class ComprobantePagoService {
	
	@Autowired
	ComprobantePagoRepository comprobantePagoRepository;
	
	@Autowired
	VentaRepository ventaRepository;
	
	public List<ComprobantePagoDto> findAll() {
        
		Iterable<ComprobantePago> comprobantePagos = comprobantePagoRepository.findAll();
		Iterator<ComprobantePago> it = comprobantePagos.iterator();
		List<ComprobantePagoDto> comprobantePagosDtos = new ArrayList<ComprobantePagoDto>();
		
		while (it.hasNext()) {
			ComprobantePago cp = it.next();
			Optional<Venta> venta = ventaRepository.findByComprobantePagoId(cp.getId());
			
			if (venta.isPresent()) {
				ComprobantePagoDto comprobantePagoDto = new ComprobantePagoDto(cp, venta.get());
				comprobantePagosDtos.add(comprobantePagoDto);
			}
		}
        return comprobantePagosDtos;	                        
    }
	
	public ComprobantePagoDto findById(Integer id) {
        
		ComprobantePagoDto cpDto = new ComprobantePagoDto();
		Optional<ComprobantePago> cp = comprobantePagoRepository.findById(id);
		Optional<Venta> venta = ventaRepository.findByComprobantePagoId(id);
		
		if (cp.isPresent()) {
			cpDto.setId(cp.get().getId());
			cpDto.setFecha(cp.get().getFecha());
			cpDto.setNumeroComprobante(cp.get().getNumeroComprobante());
			cpDto.setNumeroFactura(cp.get().getNumeroFactura());
			cpDto.setNota(cp.get().getNota());
			if (venta.isPresent()) {
				cpDto.setIdVenta(venta.get().getId());
				cpDto.setTotalVenta(venta.get().getTotal());
			}
		}
    	return cpDto;
    }
	
	public ComprobantePago save(ComprobantePago comprobantePago) {
		return comprobantePagoRepository.save(comprobantePago);
	}
	
	public ComprobantePago update(ComprobantePago newComprobantePago) {
        Optional<ComprobantePago> comprobantePago = comprobantePagoRepository.findById(newComprobantePago.getId());

        if (comprobantePago.isPresent()) {
            comprobantePago.get().setFecha(newComprobantePago.getFecha());
            comprobantePago.get().setNumeroComprobante(newComprobantePago.getNumeroComprobante());
            comprobantePago.get().setNumeroFactura(newComprobantePago.getNumeroFactura());
            comprobantePago.get().setNota(newComprobantePago.getNota());
            return this.save(comprobantePago.get());
        } else {
            // TODO: Esto deberia tirar un error de que el comprobantePago que intentas actualizar no existe.
            newComprobantePago.setId(null);
            return this.save(newComprobantePago);
        }
    }

    public Boolean deleteById(Integer id) {
    	Optional<ComprobantePago> comprobantePago = comprobantePagoRepository.findById(id);
    	
    	if (comprobantePago.isPresent()) {
            comprobantePagoRepository.delete(comprobantePago.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de articulo a eliminar
            return false;
        }
    }
	
public ComprobantePago getBaseDto() {
    	
    	ComprobantePago newComprobantePago = new ComprobantePago();
        return newComprobantePago;
    }

}
