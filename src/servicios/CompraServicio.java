/*Documentación de CompraServicio
Propósito
CompraServicio es la clase encargada de gestionar el carrito de compras en el sistema. Implementa la interfaz ICompra y
 proporciona funcionalidades para:

Añadir/eliminar productos.

Calcular el total de la compra.

Generar tickets con el resumen de la compra.

Estructura interna:

Usa un Map<String, ItemCarrito> para almacenar los productos, donde:

Clave: ID del producto (String).

Valor: Objeto ItemCarrito (producto + cantidad).

Clase Interna ItemCarrito

Responsabilidad:
Almacena un producto y su cantidad en el carrito.

Atributos:

producto: Instancia de Producto (ej: Hamburguesa, Bebida).

cantidad: Número de unidades del producto.

Constructor:

ItemCarrito(Producto producto): Inicializa la cantidad en 1 al añadir un producto nuevo.

Métodos Clave
Explicación
agregarProducto(Producto p)	Añade un producto al carrito. Si ya existe, incrementa su cantidad. Valida que el producto no sea null.
eliminarProducto(String id)	Elimina una unidad del producto. Si la cantidad llega a 0, lo quita del carrito. Valida el ID.
calcularTotal()	Suma el precio de todos los productos (considerando sus cantidades).
obtenerProductos()	Devuelve una List<Producto> donde cada producto aparece tantas veces como su cantidad.
generarTicket()	Genera un ticket formateado con: productos, cantidades, precios y total.**/



package servicios;

import model.abstracts.Producto;
import model.interfaces.ICompra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompraServicio implements ICompra {
    private final Map<String, ItemCarrito> carrito = new HashMap<>();

    public void limpiarCarrito() {

    }

    // Clase interna para manejar producto + cantidad
    private static class ItemCarrito {
        final Producto producto;
        int cantidad;

        ItemCarrito(Producto producto) {
            this.producto = producto;
            this.cantidad = 1;
        }
    }

    @Override
    public void agregarProducto(Producto producto) {
        if (producto == null) {
            System.out.println("Error: Producto no puede ser nulo");
            return;
        }
        if (carrito.containsKey(producto.getId())) {
            ItemCarrito item = carrito.get(producto.getId());
            item.cantidad++;
            System.out.println(" - " + producto.getNombre() + " Cantidad: " + item.cantidad);

        } else {
            carrito.put(producto.getId(), new ItemCarrito(producto));
            System.out.println("Añadido: " + producto.getNombre());

        }
    }

    @Override
    public void eliminarProducto(String productoId) {

        if (productoId == null || productoId.isEmpty()) {
            System.out.println("Error: ID inválido");
            return;
        }

        if (!carrito.containsKey(productoId)) {
            System.out.println("Error: Producto no encontrado");
            return;
        }
        ItemCarrito item = carrito.get(productoId);
        if (item.cantidad > 1) {
            item.cantidad--;
            System.out.println("-" + item.producto.getNombre() + " Cantidad: " + item.cantidad);

        } else {
            carrito.remove(productoId);
            System.out.println("Eliminado: " + item.producto.getNombre());

        }
    }

    @Override
    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrito item : carrito.values()) {
            total += item.producto.getPrecio() * item.cantidad;
        }
        return total;
    }

    @Override
    public List<Producto> obtenerProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        for (ItemCarrito item : carrito.values()) {
            for (int i = 0; i < item.cantidad; i++) {
                listaProductos.add(item.producto);
            }
        }
        return listaProductos;
    }

    public String generarTicket() {
        if (carrito.isEmpty()) {
            return "El carrito está vacío";
        }

        String ticket = "TICKET DE COMPRA\n";
        ticket += "----------------\n";

        for (ItemCarrito item : carrito.values()) {
            ticket += item.producto.getNombre() + " x" + item.cantidad +
                    " = " + (item.producto.getPrecio() * item.cantidad) + "€\n";
        }

        ticket += "----------------\n";
        ticket += "TOTAL: " + calcularTotal() + "€";

        return ticket;
    }
}