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