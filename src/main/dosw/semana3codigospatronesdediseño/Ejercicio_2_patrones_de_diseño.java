package main.dosw.semana3codigospatronesdediseño;


 interface JuegoAventura {
    void iniciarAventura();
}

 interface JuegoDeportes {
    void iniciarDeportes();
}

 class JuegoAventuraPlayStation implements JuegoAventura {
    public void iniciarAventura() {
        System.out.println("Iniciando 'Uncharted' en PlayStation... ¡Disfruta la aventura!");
    }
}


 class JuegoDeportesPlayStation implements JuegoDeportes {
    public void iniciarDeportes() {
        System.out.println("Iniciando 'FIFA' en PlayStation... ¡A la cancha!");
    }
}

 class JuegoAventuraXbox implements JuegoAventura {
    public void iniciarAventura() {
        System.out.println("Iniciando 'Halo' en Xbox... ¡Explora el universo!");
    }
}


 class JuegoDeportesXbox implements JuegoDeportes {
    public void iniciarDeportes() {
        System.out.println("Iniciando 'Forza Motorsport' en Xbox... ¡A correr!");
    }
}

 interface VideojuegoFactory {
    JuegoAventura crearJuegoAventura();
    JuegoDeportes crearJuegoDeportes();
}

 class PlayStationFactory implements VideojuegoFactory {
    public JuegoAventura crearJuegoAventura() {
        return new JuegoAventuraPlayStation();
    }
    public JuegoDeportes crearJuegoDeportes() {
        return new JuegoDeportesPlayStation();
    }
}

class XboxFactory implements VideojuegoFactory {
    public JuegoAventura crearJuegoAventura() {
        return new JuegoAventuraXbox();
    }
    public JuegoDeportes crearJuegoDeportes() {
        return new JuegoDeportesXbox();
    }
}
// Archivo: MainEjercicio2.java
public class MainEjercicio2 {
    public static void main(String[] args) {
        System.out.println("--- Probando Fábrica de PlayStation ---");
        VideojuegoFactory fabricaPS = new PlayStationFactory();
        JuegoAventura aventuraPS = fabricaPS.crearJuegoAventura();
        JuegoDeportes deportesPS = fabricaPS.crearJuegoDeportes();

        aventuraPS.marcarInicio();
        aventuraPS.iniciarAventura();
        deportesPS.iniciarDeportes();

        System.out.println("\n--- Probando Fábrica de Xbox ---");
        VideojuegoFactory fabricaXbox = new XboxFactory();
        JuegoAventura aventuraXbox = fabricaXbox.crearJuegoAventura();
        JuegoDeportes deportesXbox = fabricaXbox.crearJuegoDeportes();

        aventuraXbox.iniciarAventura();
        deportesXbox.iniciarDeportes();
    }
}