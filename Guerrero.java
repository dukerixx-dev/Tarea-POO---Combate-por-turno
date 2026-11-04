public class Guerrero extends Personaje {
    //constructor
    public Guerrero(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, 
                    int puntosDefensa, Item[] items){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, items);
        }

    public void ejecutarAccion(){
        //Ataca a sus oponentes directamente, sin usar mana.

        //si jugador escoge atacar:
            //preguntar al jugagor que combatiente enemigo escoge

        //si el jugador escoge defender:
        //¿Al atacar, se resta los puntos de ataque con la defensa del oponente, y lo que sobre de los puntos de ataque, se resta a los puntos de vida.?
        
        //si el jugador escoge usar objeto
            //preguntar al jugador que objeto quiere escoger (nombre descripcion del objeto)
            //if itemElegido == 1:
                //iAtaque.usar(1)
            //if itemElegido == 2:
                //iDefensa.usar(2)
            //if itemElegido():
                //iCuracion.usar(3)

    }
}