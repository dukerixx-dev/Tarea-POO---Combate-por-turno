import java.util.Scanner;
public class Guerrero extends Personaje{
    //constructor
    public Guerrero(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, 
                    int puntosDefensa, Item items){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, items);
    }
    /**    
     * proposito de la funcion
     * 
     * @author
     * @version
     * @param
     * @param
     * @param
     * @return 
     */
    public void ejecutarAccion(Equipo jugador, Equipo equipoOponente,int numTurno, Scanner lectorScanner){
        //Ataca a sus oponentes directamente, sin usar mana.
        int accionElegida = 0;
        int contDefensa = 0;
        while (accionElegida < 1 | accionElegida >3){
            //revisa si el jugador ha selecionado "defender" en su anterior turno

            System.out.println("¿Qué accion desea ejecutar?");
            System.out.println("Atacar (1), Defender (2), Usar Objeto (3).");
            accionElegida = lectorScanner.nextInt();
            // -si jugador escoge atacar-
            if (accionElegida == 1){
                int oponenteElegido = 0;
                //preguntar al jugador que combatiente enemigo escoge para realizar daño
                while (oponenteElegido < 1 | oponenteElegido > 3){
                    System.out.println("¿A quién desea atacar del equipo " + equipoOponente.getNombre() +"?");
                    System.out.println(equipoOponente.getCombatienteGuerrero().getNombre() +" (1), "+ 
                                        equipoOponente.getCombatienteMago().getNombre() + " (2), "+ 
                                        equipoOponente.getCombatienteSanador().getNombre() +" (3)?");
                    oponenteElegido = lectorScanner.nextInt();
                    //cambiar los stats del combatiente enemigo escogido segun los stats del guerrero
                    if (oponenteElegido == 1){
                        //explicacion variable dano: dano = vida del oponente elegido - (puntos de ataque del guerrero - defensa del oponente elegido)
                        int dano = equipoOponente.getCombatienteGuerrero().getPuntosVida() - (jugador.getCombatienteGuerrero().getPuntosAtaque() - equipoOponente.getCombatienteGuerrero().getPuntosDefensa()); // se descuenta defensa
                        equipoOponente.getCombatienteGuerrero().setPuntosVida(dano); //le resta la vida teniendo en cuenta la defensa
                        System.out.println(jugador.getCombatienteGuerrero().getNombre() + " Atacó a " + equipoOponente.getCombatienteGuerrero().getNombre() +"!\n");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    }
                    else if (oponenteElegido == 2){
                        int dano = equipoOponente.getCombatienteMago().getPuntosVida() - (jugador.getCombatienteGuerrero().getPuntosAtaque() - equipoOponente.getCombatienteMago().getPuntosDefensa()); // se descuenta defensa
                        equipoOponente.getCombatienteMago().setPuntosVida(dano); //le resta la vida teniendo en cuenta la defensa
                        System.out.println(jugador.getCombatienteGuerrero().getNombre() + " Atacó a " + equipoOponente.getCombatienteMago().getNombre() +"!\n");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    } 
                    else if (oponenteElegido == 3){
                        int dano = equipoOponente.getCombatienteSanador().getPuntosVida() - (jugador.getCombatienteGuerrero().getPuntosAtaque() - equipoOponente.getCombatienteSanador().getPuntosDefensa()); // se descuenta defensa
                        equipoOponente.getCombatienteSanador().setPuntosVida(dano); //le resta la vida teniendo en cuenta la defensa
                        System.out.println(jugador.getCombatienteGuerrero().getNombre() + " Atacó a " + equipoOponente.getCombatienteSanador().getNombre() +"!\n");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    }
                    else{
                        System.out.println("Vuelva a elegir su oponente porfavor");
                    }
                }
            } 
            // si jugador escoge defender
            else if (accionElegida == 2){
               // jugador.getCombatienteGuerrero().setTemporalPuntosDefensa( 2);
            }
            // si jugador escoge usar objeto
            else if (accionElegida == 3){
                jugador.getCombatienteGuerrero().getItem().usar(numTurno);
                Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
            }
            else{
                System.out.println("Vuelva a elegir su acción porfavor");
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