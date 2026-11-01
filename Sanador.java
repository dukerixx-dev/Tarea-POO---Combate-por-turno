public class Sanador extends Personaje{

    //constructor
    public Sanador(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, int puntosDefensa, Item item){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, item);
    }

    public void ejecutarAccion(){
        //sana a sus aliados, consume mana
    }

}