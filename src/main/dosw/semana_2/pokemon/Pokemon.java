package main.dosw.semana_2.pokemon;

public class Pokemon {
    private String nombre;
    private String tipo;
    private int nivel;
    private double poderCombate;
    
    // Constructor para nombre y tipo (ejercicios 1, 2)
    public Pokemon(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    // Constructor para nombre y nivel (ejercicios 3, 4, 5)
    public Pokemon(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
    
    // Constructor para nombre y poderCombate (ejercicios 9+)
    public Pokemon(String nombre, double poderCombate) {
        this.nombre = nombre;
        this.poderCombate = poderCombate;
    }
    
    // Getters (solo los que necesitas)
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getNivel() { return nivel; }
    public double getPoderCombate() { return poderCombate; }
}