package com.hp2020g3.venidemary.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.hp2020g3.venidemary.dto.LineaVentaDto;
import com.hp2020g3.venidemary.dto.VentaDto;
import com.hp2020g3.venidemary.model.Articulo;
import com.hp2020g3.venidemary.model.LineaVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hp2020g3.venidemary.model.Venta;
import com.hp2020g3.venidemary.repository.VentaRepository;

@Service
public class VentaService {
	
	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private TipoEntregaService tipoEntregaService;
	@Autowired
	private DescuentoService descuentoService;
	@Autowired
	private MedioPagoService medioPagoService;
	@Autowired
    private ArticuloService articuloService;
	@Autowired
    private UsuarioService usuarioService;

    public Iterable<Venta> findAll() {
        
        return ventaRepository.findAll();
	                        
    }
	
	public Optional<Venta> findById(Integer id) {
        return ventaRepository.findById(id);
    	
    }
	
	public VentaDto save(VentaDto ventaDto) {
        DateFormat df = new SimpleDateFormat("YDHmsS");
        Venta venta = new Venta();


        venta.setFecha(new Date());
        venta.setNumeroComprobante(Integer.parseInt(df.format(venta.getFecha())));
        venta.setIsEntregada(ventaDto.isEntregada());
        venta.setNota(ventaDto.getNota());
        venta.setTipoEntrega(ventaDto.getCurrentTipoEntrega());
        venta.setDescuento(ventaDto.getCurrentDescuento());
        venta.setMedioPago(ventaDto.getCurrentMedioPago());
        venta.setUsuario(usuarioService.findById(ventaDto.getUsuarioId()).get());

        List<LineaVenta> lineaVentas = new ArrayList<LineaVenta>();
        for (LineaVentaDto lineaVentaDto : ventaDto.getLineaVentaDtos()) {
            LineaVenta lineaVenta = new LineaVenta();
            Articulo articulo = articuloService.findById(lineaVentaDto.getArticuloId()).get();

            lineaVenta.setCantidad(lineaVentaDto.getCantidad());
            lineaVenta.setIsPago(true);
            lineaVenta.setArticulo(articulo);
            lineaVenta.setPrecio(articulo.getPrecio());

            lineaVentas.add(lineaVenta);
        }
        venta.setLineaVentas(lineaVentas);

		return new VentaDto(ventaRepository.save(venta), tipoEntregaService.findAll(), descuentoService.findAllByIsHabilitado(true),
                medioPagoService.findAll(), articuloService.findAllByIsDeleted());
	}
	
    public Boolean deleteById(Integer id) {
    	Optional<Venta> venta = ventaRepository.findById(id);
    	
    	if (venta.isPresent()) {
            ventaRepository.delete(venta.get());
            return true;
        } else {
            // TODO: Esto deberia tirar un error de que no existe el ID de articulo a eliminar
            return false;
        }
    }

    public VentaDto getBaseDto() {
	    VentaDto dto = new VentaDto(new Venta(), tipoEntregaService.findAll(), descuentoService.findAllByIsHabilitado(true),
                medioPagoService.findAll(), articuloService.findAllByIsDeleted());

	    dto.setCurrentDescuento(descuentoService.getDefault());
	    dto.setCurrentMedioPago(medioPagoService.getDefault());
	    dto.setCurrentTipoEntrega(tipoEntregaService.getDefault());

        return dto;
    }

}