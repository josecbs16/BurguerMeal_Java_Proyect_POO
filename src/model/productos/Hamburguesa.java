/*
    Qué hace:
Representa una hamburguesa con una lista de ingredientes. Implementa getDescripcion() para mostrar
los ingredientes.

    POO utilizado:

Herencia: Extiende Producto.

Composición: Usa una lista de String para los ingredientes.

Polimorfismo: Sobrescribe getDescripcion().

    Futuras mejoras:

Permitir añadir/eliminar ingredientes de forma dinámica.

Incluir atributos como tipo de pan, salsas, tamaño..
 */
package model.productos;

import model.abstracts.Producto;
import java.util.List;

public class Hamburguesa extends Producto {
    private List<String> ingredientes;

    public Hamburguesa(String id, String nombre, double precio, List<String> ingredientes) {
        super(id, nombre, precio);
        this.ingredientes = ingredientes;
    }

    @Override
    public String getDescripcion() {
        return "Hamburguesa: " + nombre + "\n" +
                "Ingredientes: " + String.join(", ", ingredientes) + "\n" +
                "Precio: " + precio + "€";
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }
}