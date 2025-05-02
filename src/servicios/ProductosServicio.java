package servicios;

import model.abstracts.Producto;
import repositories.*;
import model.productos.*;
import java.util.*;

public class ProductosServicio {
    // Repositorios para cada tipo de producto
    private HamburguesasRepo hamburguesasRepo = new HamburguesasRepo();
    private BebidasRepo bebidasRepo = new BebidasRepo();
    private ComplementosRepo complementosRepo = new ComplementosRepo();
    private MenusRepo menusRepo = new MenusRepo();

    // Carga datos iniciales al crear el servicio
    public ProductosServicio() {
        cargarDatosIniciales();
    }

    // Metodo para cargar productos de ejemplo
    private void cargarDatosIniciales() {
        // Hamburguesas
        hamburguesasRepo.agregar(new Hamburguesa("H1", "Clásica", 5.99,
                Arrays.asList("Pan", "Carne", "Lechuga")));
        hamburguesasRepo.agregar(new Hamburguesa("H2", "Especial", 7.50,
                Arrays.asList("Pan", "Doble carne", "Queso", "Bacon")));

        // Bebidas
        bebidasRepo.agregar(new Bebida("B1", "Refresco", 1.99, true, 330));
        bebidasRepo.agregar(new Bebida("B2", "Agua Mineral", 1.20, false, 500));
        bebidasRepo.agregar(new Bebida("B3", "Zumo Natural", 2.50, false, 250));

        complementosRepo.agregar(new Complemento("C1", "Patatas", 2.50, "Normal"));
        complementosRepo.agregar(new Complemento("C2", "Patatas Grandes", 3.50, "Extra"));
        complementosRepo.agregar(new Complemento("C3", "Aros de Cebolla", 3.00, "Normal"));

        // Menús (combos)
        menusRepo.agregar(new Menu("M1", "Menú Clásico", 8.99,
                hamburguesasRepo.buscarPorId("H1"),
                bebidasRepo.buscarPorId("B1"),
                complementosRepo.buscarPorId("C1")));

        menusRepo.agregar(new Menu("M2", "Menú Especial", 12.50,
                hamburguesasRepo.buscarPorId("H2"),
                bebidasRepo.buscarPorId("B3"),
                complementosRepo.buscarPorId("C2")));
    }

    // Métodos para obtener listas de productos
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

    // Método para buscar cualquier producto por ID
    public Producto buscarProducto(String id) {
        // Busca en todos los repositorios
        Producto p = hamburguesasRepo.buscarPorId(id);
        if (p == null) p = bebidasRepo.buscarPorId(id);
        if (p == null) p = complementosRepo.buscarPorId(id);
        if (p == null) p = menusRepo.buscarPorId(id);
        return p;
    }
}