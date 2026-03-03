package com.taller.pagos.controller;

import com.taller.pagos.model.Pago;
import com.taller.pagos.service.PagoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public void crearPago(@RequestBody Pago p) {
        pagoService.registrarPago(p);
    }

    @GetMapping
    public List<Pago> obtenerPagos() {
        return pagoService.listarPagos();
    }
}