import java.util.Scanner;

public class Sanador extends Personaje {

    //constructor
    public Sanador(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, 
                    int puntosDefensa, Item items){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, items);
    }

    public void ejecutarAccion(Equipo jugador, Equipo equipoOponente, int numTurno, Scanner lectorScanner){
        //aumenta puntos de vida a sus aliados
        System.out.println("¿Qué accion desea ejecutar?");

        System.out.println(jugador.getNombre() + "hizo una accion");
        //si jugador escoge atacar:
            //preguntar al jugador que combatiente enemigo escoge

        //si el jugador escoge defender:
            //se duplica la defensa del personaje elegido
        

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