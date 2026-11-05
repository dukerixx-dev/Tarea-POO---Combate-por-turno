import java.util.Scanner;
abstract class Personaje{
    //Atributos
    private String nombre;
    private int puntosVida;
    private int puntosMana;
    private int puntosAtaque;
    private int puntosDefensa;
    private Item items;

    // Constructor
    public Personaje(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, int puntosDefensa, Item items){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.puntosMana = puntosMana;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.items = items;
    }

    public abstract void ejecutarAccion(Equipo jugador, Equipo equipoOponente,int numTurno, Scanner lectorScanner);

    /* 
    Residuo de maikel
    
    public void atacar(Personaje enemigo){
        enemigo.recibirDanio(this.ataque);
        System.out.println(this.nombre + " ataca al enemigo causando " + this.ataque + " de daño.");
}
    public void recibirDanio(int cantidad){
        this.vida -= cantidad;
        if(this.vida < 0){
            this.vida = 0;
        }
    }
    public boolean estaVivo(){
        return this.vida > 0;
    }
        */

    //  GETTERS Y SETTERS
    //Getters
    public String getNombre() {
        return nombre;
    }
    public int getPuntosVida() {
        return puntosVida;
    }
    public int getPuntosMana() {
        return puntosMana;
    }
    public int getPuntosAtaque() {
        return puntosAtaque;
    }
    public int getPuntosDefensa() {
        return puntosDefensa;
    }
    public Item getItem() {
        return items;
    }
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }
    public void setPuntosMana(int puntosMana) {
        this.puntosMana = puntosMana;
    }
    /* 
    public void setTemporalPuntosAtaque(int cantidad, int duracionTurnos){
        if (){
            this.puntosAtaque =;
        }
        
    }
    public void setTemporalPuntosDefensa(int duracionTurnos){
        int defensaOriginal ;
        if (duracionTurnos > 0){
            defensaOriginal = this.puntosDefensa;
            this.puntosDefensa = 2 * defensaOriginal;
            duracionTurnos--;
        } else{
            this.puntosDefensa = defensaOriginal;
        }
    }
        */
}