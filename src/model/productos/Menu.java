/*
Responsabilidad:
Representa un combo compuesto por:

1 Hamburguesa

1 Bebida

1 Complemento

Principios POO aplicados:

Herencia:

Extiende Producto para ser tratado como cualquier otro producto en el sistema.

Composición:

Contiene instancias de Hamburguesa, Bebida y Complemento.

Polimorfismo:

Sobrescribe getDescripcion() para mostrar detalles específicos del combo.

Métodos clave:

public Menu(String id, String nombre, double precio, Hamburguesa hamburguesa, Bebida bebida, Complemento complemento)
Propósito: Inicializa el menú con sus componentes.

Parámetros:

precio: Debería calcularse automáticamente (suma de componentes - 10% descuento).

@Override public String getDescripcion()


 */
package model.productos;

import model.abstracts.Producto;

public class Menu extends Producto {
    private Hamburguesa hamburguesa;
    private Bebida bebida;
    private Complemento complemento;

    public Menu(String id, String nombre, double precio, Hamburguesa hamburguesa,
                Bebida bebida, Complemento complemento) {
        super(id, nombre, precio);
        this.hamburguesa = hamburguesa;
        this.bebida = bebida;
        this.complemento = complemento;
    }

    @Override
    public String getDescripcion() {
        return "Menú " + nombre + " (Precio: " + precio + "€)\n" +
                "Incluye:\n" +
                "- Hamburguesa: " + hamburguesa.getNombre() + "\n" +
                "- Bebida: " + bebida.getNombre() + "\n" +
                "- Complemento: " + complemento.getNombre();
    }

    public Hamburguesa getHamburguesa() {
        return hamburguesa;
    }

    public void setHamburguesa(Hamburguesa hamburguesa) {
        this.hamburguesa = hamburguesa;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }
}
