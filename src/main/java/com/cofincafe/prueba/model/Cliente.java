package com.cofincafe.prueba.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Representa un cliente de microfinanzas.
 * Es inmutable (sus campos son final) y usa BigDecimal para manejar dinero.
 */
public final class Cliente {
    private final long id;
    private final String nombre;
    private final BigDecimal balance;

    /**
     * Crea un nuevo cliente.
     * @param id identificador único
     * @param nombre nombre del cliente
     * @param balance saldo actual del cliente
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    public Cliente(long id, String nombre, BigDecimal balance) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.id = id;
        this.nombre = nombre;
        this.balance = balance == null ? BigDecimal.ZERO : balance;
    }

    /** @return id del cliente */
    public long getId() { return id; }

    /** @return nombre del cliente */
    public String getNombre() { return nombre; }

    /** @return balance del cliente */
    public BigDecimal getBalance() { return balance; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente c)) return false;
        return id == c.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Cliente{id=%d, nombre='%s', balance=%s}".formatted(id, nombre, balance);
    }
}

