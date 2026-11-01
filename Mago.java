public class Mago extends Personaje{

    //constructor
    public Mago(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, int puntosDefensa, Item item){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, item);
    }

    public void ejecutarAccion(){
        //ataca a sus oponentes usando mana
    }
}