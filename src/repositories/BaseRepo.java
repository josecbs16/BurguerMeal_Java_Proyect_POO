
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
    public void eliminar(String id) {
        elementos.remove(id);
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