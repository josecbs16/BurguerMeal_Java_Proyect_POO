/*
    Qué hace:

Es la clase base que representa cualquier producto vendible en la hamburguesería.
Define atributos comunes como id, nombre y precio, y métodos para acceder y modificar estos atributos.
También declara un metodo abstracto getDescripcion() que debe ser implementado por las clases hijas
para proporcionar una descripción específica de cada producto.

    POO utilizado:

Abstracción: Define una estructura común para todos los productos.

Herencia: Las clases Hamburguesa, Bebida, Complemento y Menu heredan de Producto.

Polimorfismo: El metodo getDescripcion() se implementa de manera diferente en cada subclase.

    Futuras mejoras:

Añadir más atributos comunes, como categoría o disponibilidad.

Implementar validaciones en los setters para evitar valores inválidos (ej: precio negativo).*/




package model.abstracts;

public abstract class Producto {
    protected String id;
    protected String nombre;
    protected double precio;


    public Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }



    public abstract String getDescripcion();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}