/*
    Qué hace:
Representa un combo:
Un menú no es un producto individual, sino un "paquete" que incluye:

1 Hamburguesa

1 Bebida

1 Complemento

Calcula el precio total:
El precio del menú podría ser:

La suma simple de los precios de sus componentes.

Un precio fijo (con descuento incluido por ser combo).
(Actualmente, en el código, el precio se pasa al constructor, pero podría calcularse automáticamente).

Genera una descripción:
El mwtodo getDescripcion() muestra los detalles del menú, como los nombres de sus componentes y el precio.

    POO utilizado:

a) Herencia
Por qué:
Un Menu es un tipo de Producto (se vende en la hamburguesería, tiene ID, nombre y precio).

Beneficio:
Permite tratar un Menu igual que otros productos (ej: agregarlo a una compra usando List<Producto>).

b) Composición (Contiene otros productos)
Por qué:
Un Menu no es una hamburguesa, bebida o complemento, sino que los usa para formar un combo.

Tiene atributos que son instancias de Hamburguesa, Bebida y Complemento.


Beneficio:

Reutiliza las clases existentes sin duplicar código.

Si cambia la Hamburguesa, el Menu se actualiza automáticamente.

c) Polimorfismo (Sobrescribe getDescripcion())
Por qué:
Cada producto (Hamburguesa, Bebida, Menu, etc.) debe describirse de forma única.

  Futuras mejoras:

  que un cliente pueda personalizar su menu y poder cambiar
  una bebida por otra si le apetece y que se recalcule el precio

  mirar el precio del menu y aadirle un descuento al comprar el combo
   junto y que no te cueste lo mismo que la suma de los otros productos por separado

   para ello podiamos hacer el 10% de la suma de ellos


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
