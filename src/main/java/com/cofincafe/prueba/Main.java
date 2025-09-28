package com.cofincafe.prueba;

import com.cofincafe.prueba.model.Cliente;
import com.cofincafe.prueba.service.ClienteService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Demostración de uso de ClienteService.
 * - Filtra la lista de  negativos
 * - Obtiene la lista del Top 3 por balance
 * - Convierte listas a JSON
 */
public class Main {
    public static void main(String[] args) {
        var clientes = List.of(
            new Cliente(1, "Andres Ospina",  new BigDecimal("1500.75")),
            new Cliente(2, "Adriana Falla", new BigDecimal("-200.00")),
            new Cliente(3, "Luisa Nieto",new BigDecimal("9800.10")),
            new Cliente(4, "Juan David ", new BigDecimal("2500.00")),
            new Cliente(5, "Alejandra Sarmiento",  new BigDecimal("-10.50"))
        );

        var service = new ClienteService();

        var negativos = service.clientesConBalanceNegativo(clientes);
        System.out.println(" _____Lista de Negativos_____:\n" + service.listaAJson(negativos));

        var top3 = service.top3MayorBalance(clientes);
        System.out.println("_____Lista del Top 3_____:\n" + service.listaAJson(top3));

        System.out.println("_____Todos en JSON_____:\n" + service.listaAJson(clientes));
    }
}

