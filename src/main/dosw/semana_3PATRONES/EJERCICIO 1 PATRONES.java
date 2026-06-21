package main.dosw.semana_3PATRONES;

// Comportamiento para los métodos de pago
    public interface MetodoPago {

    void procesarPago(double monto);
}

// PSE
    public class PseStrategy implements MetodoPago {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago por PSE de " + monto);
    }
}

// Nequi
    public class NequiStrategy implements MetodoPago {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago por NEQUI de " + monto);
    }
}

// PayPal
    public class PaypalStrategy implements MetodoPago {

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago por PAYPAL de " + monto);
    }
}

// Factory Method  crea los métodos de pago
    public interface FabricaPago {

    MetodoPago crearMetodoPago(String tipo);
}

// Fábrica de Colombia
    public class FabricaColombia implements FabricaPago {

    @Override
    public MetodoPago crearMetodoPago(String tipo) {

        if (tipo.equalsIgnoreCase("PSE")) {
            return new PseStrategy();
        }

        if (tipo.equalsIgnoreCase("NEQUI")) {
            return new NequiStrategy();
        }

        return null;
    }
}

// Fábrica de USA
public class FabricaUSA implements FabricaPago {

    @Override
    public MetodoPago crearMetodoPago(String tipo) {

        if (tipo.equalsIgnoreCase("PAYPAL")) {
            return new PaypalStrategy();
        }

        return null;
    }
}

// Clase que procesa la compra
public class Checkout {

    private MetodoPago metodoPago;

    public Checkout(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void realizarPago(double monto) {
        metodoPago.procesarPago(monto);
    }
}

// Main
public class Main {

    public static void main(String[] args) {

        FabricaPago fabrica = new FabricaColombia();

        MetodoPago metodo = fabrica.crearMetodoPago("NEQUI");

        Checkout checkout = new Checkout(metodo);

        checkout.realizarPago(160000);
    }
}