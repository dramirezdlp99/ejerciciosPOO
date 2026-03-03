package com.taller.pagos.service;

import com.taller.pagos.model.Pago;
import com.taller.pagos.model.Pedido;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Service
public class PagoService {
    private List<Pago> pagos = new ArrayList<>();

    public PagoService() {
        // Datos ya establecidos para que el GET no salga vacío
        Pedido ped1 = new Pedido(101L, "Laptop", 2500.0);
        Pago pago1 = new Pago(1L, 2500.0, LocalDate.now(), ped1);
        pago1.procesarPago(); // Esto lo pone en PROCESADO automáticamente
        pagos.add(pago1);

        Pedido ped2 = new Pedido(102L, "Mouse", 50.0);
        pagos.add(new Pago(2L, 50.0, LocalDate.now(), ped2)); // Este queda PENDIENTE
    }

    public void registrarPago(Pago p) {
        p.procesarPago();
        pagos.add(p);
    }

    public List<Pago> listarPagos() {
        return new ArrayList<>(pagos);
    }

    // Sin modificador (Default) para acceso interno [cite: 43]
    Pago buscarPagoPorId(Long id) {
        return pagos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}