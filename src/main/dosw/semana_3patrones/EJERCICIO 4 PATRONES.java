package main.dosw.semana_3patrones;

// Componente
interface Personaje {

    String descripcion();

}

// Personaje base
class Guerrero implements Personaje {

    @Override
    public String descripcion() {
        return "Guerrero";
    }

}

// Decorator base
abstract class DecoradorPersonaje implements Personaje {

    protected Personaje personaje;

    public DecoradorPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

}

// Espada
class EspadaDecorator extends DecoradorPersonaje {

    public EspadaDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public String descripcion() {
        return personaje.descripcion() + " + Espada Legendaria";
    }

}

// Escudo
class EscudoDecorator extends DecoradorPersonaje {

    public EscudoDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public String descripcion() {
        return personaje.descripcion() + " + Escudo Magico";
    }

}

// Builder
class PersonajeBuilder {

    private String tipo;

    public PersonajeBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public Personaje construir() {

        if (tipo.equalsIgnoreCase("GUERRERO")) {
            return new Guerrero();
        }

        return null;
    }

}

// Main
public class Main {

    public static void main(String[] args) {

        PersonajeBuilder builder = new PersonajeBuilder();

        Personaje personaje =
                builder.setTipo("GUERRERO")
                        .construir();

        personaje = new EspadaDecorator(personaje);
        personaje = new EscudoDecorator(personaje);

        System.out.println(personaje.descripcion());

    }

}