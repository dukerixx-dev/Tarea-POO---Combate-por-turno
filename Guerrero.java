public class Guerrero extends Personaje {
    //constructor
    public Guerrero(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, 
                    int puntosDefensa, Item items){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, items);
        }

    public void ejecutarAccion(Equipo jugador, Equipo equipoOponente, int numTurno){
        //Ataca a sus oponentes directamente, sin usar mana.
        System.out.println("¿Qué accion desea ejecutar?");
        System.out.println(jugador.getNombre() + "hizo una accion");
        //si jugador escoge atacar:
            //preguntar al jugador que combatiente enemigo escoge
            //cambiar los stats del combatiente enemigo escogido segun los stats del guerrero

        //si el jugador escoge defender:
        //se duplica los puntos de defensa.
        
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