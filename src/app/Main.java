package app;

import servicios.*;
import model.abstracts.Producto;
import utils.PrecioUtil;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ProductosServicio productos = new ProductosServicio();
        CompraServicio carrito = new CompraServicio();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la Hamburguesería Gourmet!");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Hamburguesas");
            System.out.println("2. Bebidas");
            System.out.println("3. Complementos");
            System.out.println("4. Menús");
            System.out.println("5. Ver carrito");
            System.out.println("6. Pagar");
            System.out.println("0. Salir");
            System.out.print("Elige: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- HAMBURGUESAS ---");
                    for (Producto h : productos.getHamburguesas()) {
                        System.out.println(h.getId() + ". " + h.getDescripcion());
                    }

                    System.out.print("\nIntroduce el ID de la hamburguesa (0 para cancelar): ");
                    String idH = scanner.nextLine();

                    if (!idH.equals("0")) {
                        Producto hSeleccionada = null;

                        for (Producto h : productos.getHamburguesas()) {
                            if (h.getId().equals(idH)) {
                                hSeleccionada = h;
                                break;
                            }
                        }

                        if (hSeleccionada != null) {
                            carrito.agregarProducto(hSeleccionada);
                            System.out.println("\nAñadido al carrito: " + hSeleccionada.getNombre() + "!");
                        } else {
                            System.out.println("\nID no encontrado");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- BEBIDAS ---");
                    for (Producto b : productos.getBebidas()) {
                        System.out.println(b.getId() + ". " + b.getDescripcion());
                    }

                    System.out.print("\nIntroduce el ID de la bebida (0 para cancelar): ");
                    String idB = scanner.nextLine();

                    if (!idB.equals("0")) {
                        Producto bSeleccionada = null;

                        for (Producto b : productos.getBebidas()) {
                            if (b.getId().equals(idB)) {
                                bSeleccionada = b;
                                break;
                            }
                        }

                        if (bSeleccionada != null) {
                            carrito.agregarProducto(bSeleccionada);
                            System.out.println("\nAñadido al carrito: " + bSeleccionada.getNombre() + "!");
                        } else {
                            System.out.println("\nID no encontrado");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- COMPLEMENTOS ---");
                    for (Producto c : productos.getComplementos()) {
                        System.out.println(c.getId() + ". " + c.getDescripcion());
                    }

                    System.out.print("\nIntroduce el ID del complemento (0 para cancelar): ");
                    String idC = scanner.nextLine();

                    if (!idC.equals("0")) {
                        Producto cSeleccionado = null;

                        for (Producto c : productos.getComplementos()) {
                            if (c.getId().equals(idC)) {
                                cSeleccionado = c;
                                break;
                            }
                        }

                        if (cSeleccionado != null) {
                            carrito.agregarProducto(cSeleccionado);
                            System.out.println("\nAñadido al carrito: " + cSeleccionado.getNombre() + "!");
                        } else {
                            System.out.println("\nID no encontrado");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- MENÚS ---");
                    for (Producto m : productos.getMenus()) {
                        System.out.println(m.getId() + ". " + m.getDescripcion());
                    }

                    System.out.print("\nIntroduce el ID del menú (0 para cancelar): ");
                    String idM = scanner.nextLine();

                    if (!idM.equals("0")) {
                        Producto mSeleccionado = null;

                        for (Producto m : productos.getMenus()) {
                            if (m.getId().equals(idM)) {
                                mSeleccionado = m;
                                break;
                            }
                        }

                        if (mSeleccionado != null) {
                            carrito.agregarProducto(mSeleccionado);
                            System.out.println("Añadido al carrito: " + mSeleccionado.getNombre() + "!");
                        } else {
                            System.out.println("\nID no encontrado");
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n--- TU CARRITO ---");
                    if (carrito.obtenerProductos().isEmpty()) {
                        System.out.println("Vacío");
                    } else {
                        for (Producto p : carrito.obtenerProductos()) {
                            System.out.println("- " + p.getDescripcion());
                        }
                        System.out.println("TOTAL: " + carrito.calcularTotal() + "€");
                    }
                    break;

                case 6:
                    if (carrito.obtenerProductos().isEmpty()) {
                        System.out.println("\nCarrito vacío");
                    } else {
                        System.out.println("\n--- TICKET DE COMPRA ---");
                        double subtotal = carrito.calcularTotal();

                        for (Producto p : carrito.obtenerProductos()) {
                            double precioConIVA = PrecioUtil.calcularPrecioConIVA(p.getPrecio());
                            System.out.printf("%-25s %6.2f€ (IVA incl.)\n", p.getNombre(), precioConIVA);
                        }

                        System.out.println("------------------------------");
                        System.out.printf("SUBTOTAL:               %6.2f€\n", PrecioUtil.redondear(subtotal));
                        System.out.printf("IVA (21%%):              %6.2f€\n", PrecioUtil.redondear(subtotal * 0.21));

                        double totalFinal = PrecioUtil.calcularPrecioConIVA(subtotal);

                        // Aplicar descuento si hay 3 productos o más
                        if (carrito.obtenerProductos().size() >= 3) {
                            System.out.println("Descuento aplicado:     10%");
                            totalFinal = PrecioUtil.aplicarDescuento(totalFinal, 10);
                        }

                        System.out.printf("TOTAL A PAGAR:          %6.2f€\n", totalFinal);

                        System.out.print("¿Confirmar compra? (s/n): ");
                        if (scanner.nextLine().equalsIgnoreCase("s")) {
                            System.out.println("\n¡Gracias por tu compra!");
                            carrito = new CompraServicio();
                        }
                    }
                    break;


                case 0:
                    salir = true;
                    System.out.println("\n\u00a1Vuelve pronto!");
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }

            if (!salir && opcion != 0) {
                System.out.print("\n(Presiona Enter para continuar)");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
