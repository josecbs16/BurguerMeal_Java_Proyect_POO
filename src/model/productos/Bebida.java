/*
    Qué hace:
Representa una bebida en el menú, con atributos específicos como conAzucar y tamanio.
Implementa getDescripcion() para mostrar detalles como el tamaño y si contiene azúcar.

    POO utilizado:

Herencia: Extiende Producto.

Polimorfismo: Sobrescribe getDescripcion().

    Futuras mejoras:

Añadir más atributos, como temperatura (fría/caliente) o sabor.

Validar que el tamaño no sea negativo.
 */


package model.productos;

import model.abstracts.Producto;

public class Bebida extends Producto {
    private boolean conAzucar;
    private double tamanio; // en ml

    public Bebida(String id, String nombre, double precio, boolean conAzucar, double tamanio) {
        super(id, nombre, precio);
        this.conAzucar = conAzucar;
        this.tamanio = tamanio;
    }

    @Override
    public String getDescripcion() {
        return nombre + " - " + (conAzucar ? "Con azúcar" : "Sin azúcar") + " - " + precio + "€";
    }

}