package com.cofincafe.prueba;

import com.cofincafe.prueba.model.Cliente;
import com.cofincafe.prueba.service.ClienteService;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para ClienteService.
 */
class ClienteServiceTest {

    private final ClienteService service = new ClienteService();
    private final List<Cliente> base = List.of(
        new Cliente(1, "A", new BigDecimal("100")),
        new Cliente(2, "B", new BigDecimal("-1")),
        new Cliente(3, "C", new BigDecimal("300")),
        new Cliente(4, "D", new BigDecimal("50")),
        new Cliente(5, "E", new BigDecimal("-0.01"))
    );

    /** Verifica que se filtren correctamente los balances negativos. */
    @Test
    void negativos_ok() {
        var negs = service.clientesConBalanceNegativo(base);
        assertEquals(2, negs.size());
        assertTrue(negs.stream().allMatch(c -> c.getBalance().signum() < 0));
    }

    /** Verifica que el Top 3 esté ordenado de mayor a menor. */
    @Test
    void top3_ok() {
        var top = service.top3MayorBalance(base);
        assertEquals(List.of("C","A","D"),
            top.stream().map(Cliente::getNombre).toList());
    }

    /** Verifica que la serialización a JSON */
    @Test
    void json_ok() {
        var json = service.listaAJson(base);
        assertTrue(json.contains("\"nombre\""));
        assertTrue(json.contains("\"balance\""));
        assertTrue(json.contains("\"id\""));
    }
}
