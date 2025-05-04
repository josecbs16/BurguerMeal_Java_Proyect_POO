/*Clase Ingredientes
Responsabilidad:
Representa ingredientes adicionales para personalizar productos (ej: extra queso, bacon).

Atributos:

extra (boolean): Indica si el ingrediente tiene coste adicional.

Métodos clave:

@Override public String getDescripcion()
Formato:

        "[Nombre] (extra) - [Precio]€" (si extra == true).

        "[Nombre] - [Precio]€" (si extra == false).*/

package model.productos;

import model.abstracts.Producto;

public class Ingredientes extends Producto {
    private boolean extra;

    public Ingredientes (String id, String nombre, double precio, boolean extra) {
        super(id, nombre, precio);
        this.extra = extra;
    }

    @Override
    public String getDescripcion() {
        return nombre + (extra ? " (extra)" : "") + " - " + precio + "€";
    }

    public boolean isExtra() {
        return extra;
    }

}