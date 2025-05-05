
/*
Propósito
ProductosServicio actúa como fachada central para gestionar todos los productos del sistema (hamburguesas, bebidas, complementos y menús). Su objetivo es:

Centralizar el acceso a los diferentes repositorios de productos.

Cargar datos iniciales de ejemplo al iniciar la aplicación.

Proveer métodos para listar productos o buscar por ID.

Estructura interna:

Utiliza cuatro repositorios especializados (uno por tipo de producto).

Los datos se almacenan en memoria gracias a BaseRepo.

Repositorios
Atributo	Tipo	Descripción
hamburguesasRepo	HamburguesasRepo	Almacena hamburguesas.
bebidasRepo	BebidasRepo	Almacena bebidas.
complementosRepo	ComplementosRepo	Almacena complementos.
menusRepo	MenusRepo	Almacena menús (combos).
Métodos Clave
	Explicación
cargarDatosIniciales()	Inicializa el sistema con productos de ejemplo (se ejecuta en el constructor).
getHamburguesas()	Devuelve todas las hamburguesas (List<Hamburguesa>).
getBebidas()	Devuelve todas las bebidas (List<Bebida>).
getComplementos()	Devuelve todos los complementos (List<Complemento>).
getMenus()	Devuelve todos los menús (List<Menu>).
buscarProducto(String id)	Busca un producto en todos los repositorios por su ID. Devuelve null si no existe.
Ejemplo de Uso

ProductosServicio productos = new ProductosServicio();

// Obtener todas las hamburguesas
List<Hamburguesa> hamburguesas = productos.getHamburguesas();

// Buscar un producto por ID
Producto producto = productos.buscarProducto("B1"); // Devuelve la bebida con ID "B1"
Ventajas
✔ Abstracción: Oculta los detalles de los repositorios al resto del sistema.
✔ Organización: Separa claramente los tipos de productos.
✔ Facilidad de mantenimiento: Añadir nuevos tipos de productos requiere mínimos cambios.


 */
package servicios;

import model.abstracts.Producto;
import model.productos.*;
import repositories.*;
import java.util.*;

public class ProductosServicio {
    private HamburguesasRepo hamburguesasRepo = new HamburguesasRepo();
    private BebidasRepo bebidasRepo = new BebidasRepo();
    private ComplementosRepo complementosRepo = new ComplementosRepo();
    private MenusRepo menusRepo = new MenusRepo();

    public ProductosServicio() {
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        // Hamburguesas
        agregarHamburguesa(new Hamburguesa("H1", "Clásica", 5.99,
                Arrays.asList("Pan brioche", "Carne 150g", "Lechuga", "Tomate", "Salsa especial")));

        agregarHamburguesa(new Hamburguesa("H2", "Doble Queso", 7.50,
                Arrays.asList("Pan artesanal", "Doble carne", "Doble queso cheddar", "Bacon", "Cebolla caramelizada")));

        agregarHamburguesa(new Hamburguesa("H3", "Pollo Crispy", 6.75,
                Arrays.asList("Pan de semillas", "Pollo empanado", "Lechuga iceberg", "Salsa ranch")));

        agregarHamburguesa(new Hamburguesa("H4", "Vegetariana", 6.25,
                Arrays.asList("Pan integral", "Hamburguesa de lentejas", "Aguacate", "Rúcula", "Queso de cabra")));

        agregarHamburguesa(new Hamburguesa("H5", "BBQ", 7.99,
                Arrays.asList("Pan brioche", "Carne 200g", "Bacon", "Cebolla crispy", "Salsa BBQ", "Queso ahumado")));
        // Bebidas
        bebidasRepo.agregar(new Bebida("B1", "Coca-Cola", 1.99, true, 330));
        bebidasRepo.agregar(new Bebida("B2", "Agua Mineral", 1.20, false, 500));
        bebidasRepo.agregar(new Bebida("B3", "Zumo de Naranja", 2.50, false, 250));
        bebidasRepo.agregar(new Bebida("B4", "Cerveza ", 3.00, true, 330));
        bebidasRepo.agregar(new Bebida("B5", "Limonada ", 2.25, true, 400));

        // Complementos
        complementosRepo.agregar(new Complemento("C1", "Patatas Fritas", 2.50, "Clásicas"));
        complementosRepo.agregar(new Complemento("C2", "Aros de Cebolla", 3.00, "Crujientes"));
        complementosRepo.agregar(new Complemento("C3", "Nuggets de Pollo", 3.50, "6 unidades"));
        complementosRepo.agregar(new Complemento("C4", "Ensalada César", 4.25, "Con pollo"));
        complementosRepo.agregar(new Complemento("C5", "Alitas Picantes", 4.50, "Buffalo"));

        // Menús
        menusRepo.agregar(new Menu("M1", "Menú Clásico", 9.99,
                hamburguesasRepo.buscarPorId("H1"),
                bebidasRepo.buscarPorId("B1"),
                complementosRepo.buscarPorId("C1")));

        menusRepo.agregar(new Menu("M2", "Menú Especial", 12.50,
                hamburguesasRepo.buscarPorId("H2"),
                bebidasRepo.buscarPorId("B4"),
                complementosRepo.buscarPorId("C2")));

        menusRepo.agregar(new Menu("M3", "Menú Pollo", 11.25,
                hamburguesasRepo.buscarPorId("H3"),
                bebidasRepo.buscarPorId("B3"),
                complementosRepo.buscarPorId("C3")));

        menusRepo.agregar(new Menu("M4", "Menú Vegetariano", 10.75,
                hamburguesasRepo.buscarPorId("H4"),
                bebidasRepo.buscarPorId("B5"),
                complementosRepo.buscarPorId("C4")));

        menusRepo.agregar(new Menu("M5", "Menú BBQ", 13.25,
                hamburguesasRepo.buscarPorId("H5"),
                bebidasRepo.buscarPorId("B4"),
                complementosRepo.buscarPorId("C5")));
    }

    // Métodos para clientes
    public List<Hamburguesa> getHamburguesas() {
        return hamburguesasRepo.obtenerTodos();
    }

    public List<Bebida> getBebidas() {
        return bebidasRepo.obtenerTodos();
    }

    public List<Complemento> getComplementos() {
        return complementosRepo.obtenerTodos();
    }

    public List<Menu> getMenus() {
        return menusRepo.obtenerTodos();
    }

    // Métodos para administradores
    public void agregarHamburguesa(Hamburguesa hamburguesa) {
        hamburguesasRepo.agregar(hamburguesa);
    }

    public Producto buscarProducto(String id) {
        Producto p = hamburguesasRepo.buscarPorId(id);
        if (p == null) p = bebidasRepo.buscarPorId(id);
        if (p == null) p = complementosRepo.buscarPorId(id);
        return p;
    }

    public boolean eliminarProducto(String id) {
        boolean eliminado = hamburguesasRepo.eliminar(id)
                || bebidasRepo.eliminar(id)
                || complementosRepo.eliminar(id)
                || menusRepo.eliminar(id);

        if (eliminado) {
            System.out.println(" Producto eliminado!");
        } else {
            System.out.println(" Producto no encontrado");
        }
        return eliminado;
    }

    // Metodo para EDITAR nombre y precio de cualquier producto
    public void editarProducto(String id, String nuevoNombre, double nuevoPrecio) {
        Producto producto = buscarProducto(id);

        if (producto != null) {
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            System.out.println(" Producto actualizado: " + producto.getDescripcion());
        } else {
            System.out.println(" Error: ID no encontrado");
        }
    }

}