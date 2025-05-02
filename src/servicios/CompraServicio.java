package servicios;

import model.abstracts.Producto;
import model.interfaces.ICompra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompraServicio implements ICompra {
    private final Map<String, ItemCarrito> carrito = new HashMap<>();

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