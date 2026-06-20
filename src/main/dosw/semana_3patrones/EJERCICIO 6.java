package main.dosw.semana_3patrones;

// Strategy
interface RecommendationAlgorithm {

    void recomendar();

}

// Recomendacion por genero
class GenreStrategy implements RecommendationAlgorithm {

    @Override
    public void recomendar() {
        System.out.println("Recomendando contenido por genero");
    }

}

// Recomendacion por historial
class HistoryStrategy implements RecommendationAlgorithm {

    @Override
    public void recomendar() {
        System.out.println("Recomendando contenido por historial");
    }

}

// Recomendacion por popularidad
class PopularityStrategy implements RecommendationAlgorithm {

    @Override
    public void recomendar() {
        System.out.println("Recomendando contenido por popularidad");
    }

}

// Observer
interface PreferenceObserver {

    void onPreferenceChanged();

}

// Home
class HomePageComponent implements PreferenceObserver {

    @Override
    public void onPreferenceChanged() {
        System.out.println("Home Page actualizada");
    }

}

// Notificaciones
class NotificationService implements PreferenceObserver {

    @Override
    public void onPreferenceChanged() {
        System.out.println("Notificaciones actualizadas");
    }

}

// Sugeridos
class SuggestedListComponent implements PreferenceObserver {

    @Override
    public void onPreferenceChanged() {
        System.out.println("Lista de sugeridos actualizada");
    }

}

// Subject
class UserProfile {

    private PreferenceObserver[] observadores =
            new PreferenceObserver[10];

    private int cantidad = 0;

    private RecommendationAlgorithm algoritmo;

    public void agregarObservador(
            PreferenceObserver observador) {

        observadores[cantidad] = observador;
        cantidad++;

    }

    public void cambiarAlgoritmo(
            RecommendationAlgorithm algoritmo) {

        this.algoritmo = algoritmo;

        algoritmo.recomendar();

        notificarObservadores();

    }

    private void notificarObservadores() {

        for (int i = 0; i < cantidad; i++) {

            observadores[i].onPreferenceChanged();

        }

    }

}

// Main
public class EJERCICIO6 {

    public static void main(String[] args) {

        UserProfile usuario = new UserProfile();

        usuario.agregarObservador(
                new HomePageComponent());

        usuario.agregarObservador(
                new NotificationService());

        usuario.agregarObservador(
                new SuggestedListComponent());

        usuario.cambiarAlgoritmo(
                new GenreStrategy());

    }

}