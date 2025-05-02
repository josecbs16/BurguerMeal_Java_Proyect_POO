/*
    Qué hace:
Define operaciones genéricas para gestionar repositorios de datos, como agregar,
eliminar, buscar por ID y listar todos los elementos.

    POO utilizado:

Genéricos: Permite que la interfaz sea reutilizable para cualquier tipo T.

Abstracción: Oculta los detalles de cómo se almacenan los datos (ej: en memoria, base de datos).

    Futuras mejoras:

añadir algun metodo para filtrar por precios o nombres por ejemplo
 */


package model.interfaces;

import java.util.List;
public interface IRepository<T> {
    void agregar(T obj);
    void eliminar(String id);
    T buscarPorId(String id);
    List<T> obtenerTodos();

}
