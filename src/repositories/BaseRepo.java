/*
Propósito
BaseRepo es una clase abstracta que implementa operaciones básicas de un repositorio genérico (IRepository<T>) usando un HashMap como almacenamiento en memoria. Su objetivo es:

Centralizar la lógica CRUD (Crear, Leer, Actualizar, Eliminar) para cualquier entidad.

Evitar duplicar código en repositorios específicos (como HamburguesasRepo o BebidasRepo).

¿Por qué se diseñó así?
Genericidad (<T>)

Permite que BaseRepo funcione con cualquier tipo de entidad (ej: Hamburguesa, Bebida).

Las subclases (como HamburguesasRepo) solo deben indicar el tipo concreto:


public class HamburguesasRepo extends BaseRepo<Hamburguesa> { ... }
Mapa Interno (HashMap<String, T>):

Almacena los elementos con una clave única (el ID del producto).

Rápido acceso por ID

Implementación de IRepository<T>:

Cumple con el contrato de la interfaz, asegurando que todos los repositorios tengan los mismos métodos básicos.

Métodos Clave
Metodo	Explicación
agregar(T item)	Añade un elemento al mapa usando su ID como clave. Nota: Hace un casting a Producto para obtener el ID, lo que implica que T debe ser subtipo de Producto.
eliminar(String id)	Elimina un elemento por su ID. Si el ID no existe, no hace nada.
buscarPorId(String id)	Devuelve el elemento asociado al ID, o null si no se encuentra.
obtenerTodos()	Convierte los valores del mapa a una List<T> (útil para mostrar todos los elementos).
*/
package repositories;

import model.interfaces.IRepository;
import java.util.*;

public abstract class BaseRepo<T> implements IRepository<T> {
    protected Map<String, T> elementos = new HashMap<>();

    @Override
    public void agregar(T item) {
        elementos.put(((model.abstracts.Producto)item).getId(), item);
    }

    @Override
    public boolean eliminar(String id) {
        return elementos.remove(id) != null;
    }

    @Override
    public T buscarPorId(String id) {
        return elementos.get(id);
    }

    @Override
    public List<T> obtenerTodos() {
        return new ArrayList<>(elementos.values());
    }


}