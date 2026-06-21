package main.dosw.semana3codigospatronesdediseño;

// 1. La interfaz base
interface MetodoPago {
    void procesarPago(double monto);
}


class TarjetaCredito implements MetodoPago {
    public void procesarPago(double monto) {
        System.out.println("Pago con Tarjeta de Crédito por $ " + monto);
    }
}

class PayPal implements MetodoPago {
    public void procesarPago(double monto) {
        System.out.println("Pago con PayPal por $ " + monto);
    }
}


class PagoFactory {
    public static MetodoPago creadorPago(String tipo) {
        if (tipo.equalsIgnoreCase("TARJETA")) return new TarjetaCredito();
        if (tipo.equalsIgnoreCase("PAYPAL")) return new PayPal();
        throw new IllegalArgumentException("Método no soportado");
    }
}


 class Main {
    public static void main(String[] args) {
        // Aquí validas tu solución
        MetodoPago pago1 = PagoFactory.creadorPago("TARJETA");
        pago1.procesarPago(150.50);

        MetodoPago pago2 = PagoFactory.creadorPago("PAYPAL");
        pago2.procesarPago(85.00);
    }
}

