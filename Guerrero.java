import java.util.Scanner;
public class Guerrero extends Personaje{
    //constructor
    public Guerrero(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, 
                    int puntosDefensa, Item items){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, items);
        }

    public void ejecutarAccion(Equipo jugador, Equipo equipoOponente, int numTurno){
        //Ataca a sus oponentes directamente, sin usar mana.
        Scanner lectorScanner = new Scanner(System.in);
        System.out.println("¿Qué accion desea ejecutar?");

        //si jugador escoge atacar:
        //preguntar al jugador que combatiente enemigo escoge para realizar daño
        //cambiar los stats del combatiente enemigo escogido segun los stats del guerrero
        if (accionG == 1){
            System.out.println("¿A quién desea atacar?");
            System.out.println("1. Guerrero");
            System.out.println("2. Mago");
            System.out.println("3. Sanador");
            int ataqueG = lectorScanner.nextInt();
            if (ataqueG == 1){
                private void haceDano(Personaje Guerrero){
                   guerrero1.getPuntosAtaque() == guerrero1.getPuntosAtaque() - guerrero2.getPuntosDefensa(); // se descuenta defensa
                    guerrero2.getPuntosVida() == guerrero2.getPuntosVida() - guerrero1.getPuntosAtaque(); //le resta la vida teniendo en cuenta la defensa
                    guerrero1.getPuntosAtaque() == guerrero1.getPuntosAtaque() + guerrero2.getPuntosDefensa(); //vuelve a su valor original de daño en caso de querer atacar a otro en turnos siguientes
                }
            
            }
        }

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