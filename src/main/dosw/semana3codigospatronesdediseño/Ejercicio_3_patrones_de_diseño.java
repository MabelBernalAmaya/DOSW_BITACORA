package main.dosw.semana3codigospatronesdediseño;


 class Juguete {
    private String tipo;
    private String cabeza;
    private String cuerpo;
    private String brazos;
    private String piernas;
    private String accesorio; // Es opcional


    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCabeza(String cabeza) { this.cabeza = cabeza; }
    public void setCuerpo(String cuerpo) { this.cuerpo = cuerpo; }
    public void setBrazos(String brazos) { this.brazos = brazos; }
    public void setPiernas(String piernas) { this.piernas = piernas; }
    public void setAccesorio(String accesorio) { this.accesorio = accesorio; }

    public void mostrarDetalles() {
        System.out.println("Muñeco: [" + tipo + "]");
        System.out.println(" - Cabeza: " + cabeza);
        System.out.println(" - Cuerpo: " + cuerpo);
        System.out.println(" - Brazos: " + brazos);
        System.out.println(" - Piernas: " + piernas);
        System.out.println(" - Accesorio: " + (accesorio != null ? accesorio : "Ninguno"));
        System.out.println("---------------------------------------");
    }

     public interface JugueteBuilder {
         void definirTipo();
         void buildCabeza();
         void buildCuerpo();
         void buildBrazos();
         void buildPiernas();
         void buildAccesorio();
         Juguete getResultado();
     }
     // Archivo: MunecoAccionBuilder.java
     public class MunecoAccionBuilder implements JugueteBuilder {
         private Juguete juguete = new Juguete();

         public void definirTipo() { juguete.setTipo("Muñeco de Acción (Guerrero Sci-Fi)"); }
         public void buildCabeza() { juguete.setCabeza("Casco táctico con visor LED"); }
         public void buildCuerpo() { juguete.setCuerpo("Armadura de titanio reforzada"); }
         public void buildBrazos() { juguete.setBrazos("Brazos robóticos articulados"); }
         public void buildPiernas() { juguete.setPiernas("Piernas con propulsores de salto"); }
         public void buildAccesorio() { juguete.setAccesorio("Espada láser de plasma"); } // Tiene accesorio

         public Juguete getResultado() { return this.juguete; }
     }
     // Archivo: MunecaClasicaBuilder.java
     public class MunecaClasicaBuilder implements JugueteBuilder {
         private Juguete juguete = new Juguete();

         public void definirTipo() { juguete.setTipo("Muñeca Clásica"); }
         public void buildCabeza() { juguete.setCabeza("Cabello rubio con tiara de princesa"); }
         public void buildCuerpo() { juguete.setCuerpo("Vestido de gala elegante"); }
         public void buildBrazos() { juguete.setBrazos("Brazos de porcelana estilizados"); }
         public void buildPiernas() { juguete.setPiernas("Zapatos de cristal"); }
         public void buildAccesorio() { juguete.setAccesorio(null); } // No tiene accesorio

         public Juguete getResultado() { return this.juguete; }
     }
     // Archivo: DirectorFabrica.java
     public class DirectorFabrica {
         public void construirJuguete(JugueteBuilder builder) {
             builder.definirTipo();
             builder.buildCabeza();
             builder.buildCuerpo();
             builder.buildBrazos();
             builder.buildPiernas();
             builder.buildAccesorio(); // Pasos ordenados secuencialmente
         }
     }
}
