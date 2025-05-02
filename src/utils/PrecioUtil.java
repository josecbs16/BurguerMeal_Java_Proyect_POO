package utils;

public class PrecioUtil {
    // IVA del 21%
    private static final double IVA = 0.21;

    // Calcula el precio con IVA
    public static double calcularPrecioConIVA(double precio) {
        return redondear(precio * (1 + IVA));
    }

    // Aplica un descuento (en porcentaje)
    public static double aplicarDescuento(double precio, double descuentoPorcentaje) {
        double precioConDescuento = precio * (1 - descuentoPorcentaje/100);
        return redondear(precioConDescuento);
    }

    // Redondea a 2 decimales
    public static double redondear(double precio) {
        return Math.round(precio * 100) / 100.0;
    }
}