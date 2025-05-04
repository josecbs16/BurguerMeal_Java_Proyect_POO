🍔 Hamburguesería - Sistema de Gestión de Pedidos
Proyecto Java que simula un sistema de pedidos para una hamburguesería, con gestión de productos (hamburguesas, bebidas, complementos, menús) y carrito de compras.

🛠️ Estructura del Proyecto
📂 Estructura de Paquetes
src/  
├── app/  
│   └── Main.java                # Punto de entrada del programa  
├── model/  
│   ├── abstracts/  
│   │   └── Producto.java        # Clase abstracta base para todos los productos  
│   └── productos/  
│       ├── Bebida.java          # Bebidas (refrescos, agua, zumos)  
│       ├── Complemento.java      # Complementos (patatas, aros de cebolla)  
│       ├── Hamburguesa.java      # Hamburguesas con ingredientes  
│       ├── Ingredientes.java     # Ingredientes extra (opcionales)  
│       └── Menu.java            # Menús combinados (hamburguesa + bebida + complemento)  
├── repositories/  
│   ├── BaseRepo.java            # Repositorio genérico (CRUD en memoria)  
│   ├── BebidasRepo.java         # Repositorio de bebidas  
│   ├── ComplementosRepo.java    # Repositorio de complementos  
│   ├── HamburguesasRepo.java    # Repositorio de hamburguesas  
│   └── MenusRepo.java           # Repositorio de menús  
├── servicios/  
│   ├── CompraServicio.java      # Lógica del carrito de compras  
│   └── ProductosServicio.java   # Gestión centralizada de productos  
└── utils/  
    └── PrecioUtil.java          # Utilidades para cálculos de precios (IVA, descuentos)  
🚀 Cómo Ejecutar el Proyecto
Requisitos
Java JDK 11+

Git (para clonar el repositorio)

Pasos
Clona el repositorio:

bash
git clone https://github.com/tu-usuario/hamburgueseria-gourmet.git  
Abre el proyecto en IntelliJ IDEA (o cualquier IDE Java).

Ejecuta la clase Main.java (en src/app/).

🛒 Funcionalidades Principales
1. Menú Interactivo
Hamburguesas, Bebidas, Complementos, Menús.

Ver carrito y Pagar con generación de ticket.

2. Carrito de Compras
Añadir/eliminar productos.

Cálculo automático de:

Subtotal.

IVA (21%).

Descuentos (10% si hay 3+ productos).

3. Gestión de Productos
Todos los productos heredan de la clase abstracta Producto.

Los menús (Menu.java) usan composición para incluir:

1 Hamburguesa.

1 Bebida.

1 Complemento.

📝 Ejemplo de Uso
Añadir una hamburguesa al carrito:

--- HAMBURGUESAS ---  
H1. Hamburguesa Clásica - 5.99€  
H2. Hamburguesa Especial - 7.50€  
Introduce el ID de la hamburguesa: H1  
✅ Salida: Añadido al carrito: Hamburguesa Clásica!

Pagar:

--- TICKET DE COMPRA ---  
Hamburguesa Clásica x1 = 5.99€ (IVA incl.)  
SUBTOTAL: 5.99€  
IVA (21%): 1.26€  
TOTAL A PAGAR: 7.25€  
📚 Documentación de Clases
Clase	Descripción
Producto	Clase abstracta con id, nombre, precio y método getDescripcion().
Hamburguesa	Contiene una lista de ingredientes.
Menu	Combina Hamburguesa, Bebida y Complemento con precio especial.
CompraServicio	Gestiona el carrito (añadir, eliminar, calcular total).
BaseRepo	Implementa operaciones CRUD genéricas con HashMap.
