package com.hp2020g3.venidemary.service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.hp2020g3.venidemary.dto.CuentaCorrienteClienteVentaDto;
import com.hp2020g3.venidemary.dto.LineaVentaDto;
import com.hp2020g3.venidemary.dto.VentaDto;
import com.hp2020g3.venidemary.model.*;
import com.hp2020g3.venidemary.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	@Autowired
    private ContadorService contadorService;
	@Autowired
    private ComprobantePagoService comprobantePagoService;
	@Autowired
    private CuentaCorrienteClienteService cuentaCorrienteClienteService;
	@Autowired
    private EstadoCuentaCorrienteService estadoCuentaCorrienteService;

    public Iterable<Venta> findAll() {
        
        return ventaRepository.findAll();
	                        
    }
	
	public VentaDto findById(Integer id) {
        VentaDto ventaDto = new VentaDto(ventaRepository.findById(id).get(), tipoEntregaService.findAll(), descuentoService.findAllByIsHabilitado(true),
            medioPagoService.findAll(), articuloService.findAllByIsDeleted());

        Iterable<CuentaCorrienteCliente> cuentaCorrienteClientes =
                cuentaCorrienteClienteService.findByIsAprobadaAndIsDeleted(true, false);

		ventaDto.setCuentaCorrienteClienteVentaDtos(
		        StreamSupport.stream(cuentaCorrienteClientes.spliterator(), false)
                    .map(cuentaCorrienteCliente -> new CuentaCorrienteClienteVentaDto((CuentaCorrienteCliente) cuentaCorrienteCliente))
                    .collect(Collectors.toList()));

		return ventaDto;
    }
	
    private List<LineaVenta> lineaDeVentaDtosToLineaVentas(List<LineaVentaDto> lineaVentaDtos, Venta venta) {
        List<LineaVenta> lineaVentas = new ArrayList<LineaVenta>();
        for (LineaVentaDto lineaVentaDto : lineaVentaDtos) {
            LineaVenta lineaVenta = new LineaVenta();
            Articulo articulo = articuloService.findById(lineaVentaDto.getArticuloId()).get();

            lineaVenta.setCantidad(lineaVentaDto.getCantidad());
            lineaVenta.setArticulo(articulo);
            lineaVenta.setPrecio(articulo.getPrecio());
            lineaVenta.setVenta(venta);

            lineaVentas.add(lineaVenta);
        }

        return lineaVentas;
    }

    private List<LineaVentaCuentaCorriente> lineaDeVentaDtosToLineaVentasCuentaCorreinte(
            List<LineaVentaDto> lineaVentaDtos, Venta venta, Integer cuentaConrrienteClienteId, Boolean precioCongelado) {
        CuentaCorrienteCliente cuentaCorriente = cuentaCorrienteClienteService.findById(cuentaConrrienteClienteId);

        List<LineaVentaCuentaCorriente> lineaVentas = new ArrayList<LineaVentaCuentaCorriente>();
        for (LineaVentaDto lineaVentaDto : lineaVentaDtos) {
            LineaVentaCuentaCorriente lineaVenta = new LineaVentaCuentaCorriente();
            Articulo articulo = articuloService.findById(lineaVentaDto.getArticuloId()).get();
            EstadoCuentaCorriente estadoCuentaCorriente = estadoCuentaCorrienteService
                    .findByCuentaCorrienteClienteIdAndArticuloId(cuentaConrrienteClienteId, articulo.getId());

            if (estadoCuentaCorriente == null) {
                estadoCuentaCorriente = new EstadoCuentaCorriente();
                estadoCuentaCorriente.setArticulo(articulo);
                estadoCuentaCorriente.setCuentaCorrienteCliente(cuentaCorriente);
                estadoCuentaCorriente.setCantidad(0);
                estadoCuentaCorriente = estadoCuentaCorrienteService.save(estadoCuentaCorriente);
            }

            lineaVenta.setCantidad(lineaVentaDto.getCantidad());
            lineaVenta.setVenta(venta);
            if (precioCongelado == null || !precioCongelado) {
                estadoCuentaCorriente.setCantidad(estadoCuentaCorriente.getCantidad() + lineaVentaDto.getCantidad());
            } else {
                lineaVenta.setPrecio(articulo.getPrecio());
                lineaVenta.setIsPago(false);
            }
            lineaVenta.setEstadoCuentaCorriente(estadoCuentaCorriente);

            lineaVentas.add(lineaVenta);
        }

        return lineaVentas;
    }

	public VentaDto save(VentaDto ventaDto) {

        Venta venta = new Venta();

        venta.setFecha(new Date());
        venta.setNumeroComprobante(contadorService.getValor(Constants.CONTADOR_COMP_VENTA));
        venta.setIsEntregada(ventaDto.isEntregada());
        venta.setNota(ventaDto.getNota());
        venta.setTipoEntrega(ventaDto.getCurrentTipoEntrega());
        venta.setDescuento(ventaDto.getCurrentDescuento());
        venta.setUsuario(usuarioService.findById(ventaDto.getUsuarioId()).get());
        venta.setMedioPago(ventaDto.getCurrentMedioPago());

        if (ventaDto.getSelectedCuentaCorrienteClienteVentaDto() != null) {
            venta.setLineasVentaCuentaCorriente(this.lineaDeVentaDtosToLineaVentasCuentaCorreinte(
                    ventaDto.getLineaVentaDtos(), venta, ventaDto.getSelectedCuentaCorrienteClienteVentaDto().getId(),
                    ventaDto.isPrecioCongelado()));
        } else {
            ComprobantePago comprobantePago = new ComprobantePago(new Date(), contadorService.getValor(Constants.CONTADOR_COMP_PAGO));

            venta.setComprobantePago(comprobantePagoService.save(comprobantePago));
            venta.setLineasVenta(this.lineaDeVentaDtosToLineaVentas(ventaDto.getLineaVentaDtos(), venta));
        }

		ventaDto = new VentaDto(ventaRepository.save(venta), tipoEntregaService.findAll(), descuentoService.findAllByIsHabilitado(true),
                medioPagoService.findAll(), articuloService.findAllByIsDeleted());
		contadorService.increaseAndSave(Constants.CONTADOR_COMP_VENTA);

		if (ventaDto.getSelectedCuentaCorrienteClienteVentaDto() == null) {
            contadorService.increaseAndSave(Constants.CONTADOR_COMP_PAGO);
        }
		
		return ventaDto;
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

	    Iterable<CuentaCorrienteCliente> cuentaCorrienteClientes =
                cuentaCorrienteClienteService.findByIsAprobadaAndIsDeleted(true, false);

		dto.setCuentaCorrienteClienteVentaDtos(
		        StreamSupport.stream(cuentaCorrienteClientes.spliterator(), false)
                    .map(cuentaCorrienteCliente -> new CuentaCorrienteClienteVentaDto((CuentaCorrienteCliente) cuentaCorrienteCliente))
                    .collect(Collectors.toList()));

        return dto;
    }

}
