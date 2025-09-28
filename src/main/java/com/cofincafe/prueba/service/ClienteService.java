package com.cofincafe.prueba.service;

import com.cofincafe.prueba.model.Cliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * Lógica de negocio sobre clientes: filtrado, top y exportación a JSON.
 */
public class ClienteService {

    // ObjectMapper configurado una vez; seguro de usar tras la configuración.
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    /**
     * Devuelve los clientes cuyo balance es negativo (balance < 0).
     * @param clientes lista de entrada
     * @return lista con los clientes de balance negativo
     */
    public List<Cliente> clientesConBalanceNegativo(List<Cliente> clientes) {
        return clientes.stream()
                .filter(c -> c.getBalance().compareTo(BigDecimal.ZERO) < 0)
                .toList();
    }

    /**
     * Devuelve el top 3 de clientes con mayor balance 
     * Ordena y toma los 3 primeros.
     * @param clientes lista de entrada
     * @return lista con hasta 3 clientes de mayor balance
     */
    public List<Cliente> top3MayorBalance(List<Cliente> clientes) {
        return clientes.stream()
                .sorted(Comparator.comparing(Cliente::getBalance).reversed())
                .limit(3)
                .toList();
    }

    /**
     * Serializa a JSON la lista de clientes.
     * @param clientes lista a serializar
     * @return cadena JSON formateada
     * @throws RuntimeException si falla la serialización
     */
    public String listaAJson(List<Cliente> clientes) {
        try {
            return MAPPER.writeValueAsString(clientes);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializando a JSON", e);
        }
    }
}
