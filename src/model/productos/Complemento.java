/*
    Qué hace:
Representa un complemento del menú (ej: patatas fritas, ensalada). Incluye un atributo tipo y una descripción personalizada.

    POO utilizado:

Herencia: Extiende Producto.

Polimorfismo: Sobrescribe getDescripcion().

    Futuras mejoras:

Clasificar complementos por categorías (ej: acompañamiento, postre).

Añadir opciones de personalización (ej: tamaño o ingredientes extra).
 */
package model.productos;

import model.abstracts.Producto;


public class Complemento extends Producto {
    private String tipo;  // Tipo de complemento (ej: "patatas fritas", "ensalada", "postre")


    public Complemento(String id, String nombre, double precio, String tipo) {
        super(id, nombre, precio);
        this.tipo = tipo;
    }


    @Override
    public String getDescripcion() {
        return "Complemento " + getNombre() + " [" + tipo + "] - Precio: $" + getPrecio();
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}