public class Guerrero extends Personaje {

    //constructor
    public Guerrero(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, int puntosDefensa, Item item){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, item);
    }

    public void ejecutarAccion(){
        //ataca a sus oponentes directamente, sin usar mana
    }
}