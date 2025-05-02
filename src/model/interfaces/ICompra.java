/*
    Qué hace:
Define las operaciones básicas para gestionar una compra, como agregar/eliminar productos,
 calcular el total y obtener la lista de productos.

    POO utilizado:

Interfaces: Exige que se implementen ciertos metodos que deben cumplir las clases que la implementen (ej: CompraServicio).

Encapsulamiento: Oculta los detalles de implementación de las operaciones de compra.

    Futuras mejoras:

Añadir métodos para aplicar descuentos o promociones.

Incluir validaciones, como verificar si un producto ya existe en la compra.
 */



package model.interfaces;

import model.abstracts.Producto;

import java.util.List;

public interface ICompra {
    void agregarProducto(Producto producto);
    void eliminarProducto(String productoId);
    double calcularTotal();
    List<Producto> obtenerProductos();
    String generarTicket();
}
