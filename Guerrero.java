public class Guerrero extends Personaje {
    //constructor
    public Guerrero(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, int puntosDefensa, Item item){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, item);
    }

    public void ejecutarAccion(){
        //-ataca a sus oponentes directamente, sin usar mana
        //-Al atacar, se resta los puntos de ataque con la defensa del oponente, 
        //y lo que sobre de los puntos de ataque, se resta a los puntos de vida.

    }
}