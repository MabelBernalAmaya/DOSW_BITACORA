package main.dosw.semana_3PATRONES;

// Observer para las notificaciones
 interface Notificador {

    void actualizar(String mensaje);

}

// Correo
class CorreoNotifier implements Notificador {

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Correo enviado: " + mensaje);
    }
}

// SMS
 class SmsNotifier implements Notificador {

    @Override
    public void actualizar(String mensaje) {
        System.out.println("SMS enviado: " + mensaje);
    }
}

// Push
 class PushNotifier implements Notificador {

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Push enviado: " + mensaje);
    }
}

// Factory Method
 interface FabricaNotificacion {

    Notificador crearNotificacion();

}

// Fabrica para correo
class FabricaCorreo implements FabricaNotificacion {

    @Override
    public Notificador crearNotificacion() {
        return new CorreoNotifier();
    }
}

// Fabrica para SMS
 class FabricaSms implements FabricaNotificacion {

    @Override
    public Notificador crearNotificacion() {
        return new SmsNotifier();
    }
}

// Fabrica para Push
 class FabricaPush implements FabricaNotificacion {

    @Override
    public Notificador crearNotificacion() {
        return new PushNotifier();
    }
}

// el que notifica
 class SistemaNotificaciones {

    private Notificador[] observadores = new Notificador[10];
    private int cantidad = 0;

    // Registrar observadores
    public void agregarObservador(Notificador observador) {
        observadores[cantidad] = observador;
        cantidad++;
    }

    // Notificar a todos
    public void enviarNotificacion(String mensaje) {

        for (int i = 0; i < cantidad; i++) {
            observadores[i].actualizar(mensaje);
        }

    }
}

// Main
public class Main {

    public static void main(String[] args) {

        SistemaNotificaciones sistema =
                new SistemaNotificaciones();

        // Factory Method  es el crea los observadores
        FabricaNotificacion fabricaCorreo =
                new FabricaCorreo();

        FabricaNotificacion fabricaSms =
                new FabricaSms();

        FabricaNotificacion fabricaPush =
                new FabricaPush();

        // Se agregan al sistema
        sistema.agregarObservador(
                fabricaCorreo.crearNotificacion());

        sistema.agregarObservador(
                fabricaSms.crearNotificacion());

        sistema.agregarObservador(
                fabricaPush.crearNotificacion());

        // Evento
        sistema.enviarNotificacion(
                "Pedido confirmado");
    }
}