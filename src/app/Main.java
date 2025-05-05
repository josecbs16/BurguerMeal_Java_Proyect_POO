package app;

import model.productos.Hamburguesa;
import servicios.*;
import model.abstracts.Producto;
import utils.PrecioUtil;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProductosServicio productos = new ProductosServicio();
        CompraServicio carrito = new CompraServicio();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la Hamburguesería Gourmet!");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- SELECCIONE ROL ---");
            System.out.println("1. Cliente");
            System.out.println("2. Administrador");
            System.out.println("0. Salir");
            System.out.print("Elige: ");

            int rol = scanner.nextInt();
            scanner.nextLine();

            switch (rol) {
                case 1:
                    menuCliente(productos, carrito, scanner);
                    break;
                case 2:
                    menuAdministrador(productos, scanner);
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }

    private static void menuCliente(ProductosServicio productos, CompraServicio carrito, Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- MENÚ CLIENTE ---");
            System.out.println("1. Hamburguesas");
            System.out.println("2. Bebidas");
            System.out.println("3. Complementos");
            System.out.println("4. Menús");
            System.out.println("5. Ver carrito");
            System.out.println("6. Pagar");
            System.out.println("0. Volver");
            System.out.print("Elige: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarYAgregarProductos(productos.getHamburguesas(), carrito, scanner);
                    break;
                case 2:
                    mostrarYAgregarProductos(productos.getBebidas(), carrito, scanner);
                    break;
                case 3:
                    mostrarYAgregarProductos(productos.getComplementos(), carrito, scanner);
                    break;
                case 4:
                    mostrarYAgregarProductos(productos.getMenus(), carrito, scanner);
                    break;
                case 5:
                    verCarrito(carrito);
                    break;
                case 6:
                    pagar(carrito, scanner);
                    break;
                case 0:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void menuAdministrador(ProductosServicio productos, Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- MENÚ ADMINISTRADOR ---");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Agregar producto");
            System.out.println("3. Editar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("0. Volver");
            System.out.print("Elige: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarProductos(productos);
                    break;
                case 2:
                    agregarHamburguesa(productos, scanner);
                    break;
                case 3:
                    System.out.print("Introduce ID del producto a editar: ");
                    String idEditar = scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Nuevo precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    productos.editarProducto(idEditar, nombre, precio);
                    break;


                case 4:
                    System.out.print("Introduce ID del producto a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    productos.eliminarProducto(idEliminar);
                    break;


                case 0:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    // Métodos auxiliares para Cliente
    private static void mostrarYAgregarProductos(List<? extends Producto> productos, CompraServicio carrito, Scanner scanner) {
        System.out.println();
        for (Producto p : productos) {
            System.out.println(p.getId() + ". " + p.getDescripcion());
        }

        System.out.print("\nIntroduce el ID (0 para cancelar): ");
        String id = scanner.nextLine();

        if (!id.equals("0")) {
            Producto seleccionado = productos.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElse(null);

            if (seleccionado != null) {
                carrito.agregarProducto(seleccionado);
                System.out.println("Añadido: " + seleccionado.getNombre());
            } else {
                System.out.println("ID no encontrado");
            }
        }
    }

    private static void verCarrito(CompraServicio carrito) {
        System.out.println("\n--- TU CARRITO ---");
        if (carrito.obtenerProductos().isEmpty()) {
            System.out.println("Vacío");
        } else {
            carrito.obtenerProductos().forEach(p ->
                    System.out.println("- " + p.getDescripcion()));
            System.out.println("TOTAL: " + carrito.calcularTotal() + "€");
        }
    }

    private static void pagar(CompraServicio carrito, Scanner scanner) {
        if (carrito.obtenerProductos().isEmpty()) {
            System.out.println("\nCarrito vacío");
            return;
        }

        System.out.println("\n" + carrito.generarTicket());
        System.out.print("\n¿Confirmar compra? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            System.out.println("¡Gracias por tu compra!");
            carrito.limpiarCarrito();
        }
    }

    // Métodos auxiliares para Administrador
    private static void mostrarProductos(ProductosServicio productos) {
        System.out.println("\n--- PRODUCTOS ---");
        System.out.println("Hamburguesas:");
        productos.getHamburguesas().forEach(p -> System.out.println("  " + p.getDescripcion()));

        System.out.println("\nBebidas:");
        productos.getBebidas().forEach(p -> System.out.println("  " + p.getDescripcion()));
    }

    private static void agregarHamburguesa(ProductosServicio productos, Scanner scanner) {
        System.out.print("\nID de la hamburguesa: ");
        String id = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingredientes (separados por comas): ");
        List<String> ingredientes = Arrays.asList(scanner.nextLine().split(","));

        productos.agregarHamburguesa(new Hamburguesa(id, nombre, precio, ingredientes));
        System.out.println("¡Hamburguesa añadida!");
    }
}