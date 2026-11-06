import java.util.Scanner;
public class Mago extends Personaje {
    //constructor
    public Mago(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, 
                    int puntosDefensa, Item items, int contTurnosDefensa){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, items, contTurnosDefensa);
    }

    /**    
     * Permite al jugador atacar, defender y usar objeto con su personaje elegido.
     * 
     * @author Jorge Almonacid
     * @version 1.2
     * @param jugador Equipo al cual le toca su turno.
     * @param equipoOponente Equipo al cual va a ser afectado por el jugador.
     * @param numTurno El turno concurrente del combate.
     * @param lectorScanner Recibe las entradas del jugador.
     * @return void
     */
    public void ejecutarAccion(Equipo jugador, Equipo equipoOponente,int numTurno, Scanner lectorScanner){
        //Ataca a sus oponentes usando mana
        int accionElegida = 0;
        // -Escoger accion-
        while (accionElegida < 1 | accionElegida >3){
            System.out.println("¿Qué accion desea ejecutar?");
            System.out.println("Atacar (1), Defender (2), Usar Objeto (3).");
            accionElegida = lectorScanner.nextInt();
            // -Escoge atacar-
            if (accionElegida == 1){
                int oponenteElegido = 0;
                // -Escoger oponente-
                while (oponenteElegido < 1 | oponenteElegido > 3){
                    System.out.println("¿A quién desea atacar del equipo " + equipoOponente.getNombre() +"?");
                    System.out.println(equipoOponente.getCombatienteGuerrero().getNombre() +" (1), "+ 
                                        equipoOponente.getCombatienteMago().getNombre() + " (2), "+ 
                                        equipoOponente.getCombatienteSanador().getNombre() +" (3)?");
                    oponenteElegido = lectorScanner.nextInt();
                    // -cambia los puntos de vida del oponente, segun la defensa de este y los puntos de ataque del Mago-
                    if (oponenteElegido == 1){
                        //explicacion variable dano: dano = vida del oponente elegido - (puntos de ataque del Mago - defensa del oponente elegido)
                        int dano = equipoOponente.getCombatienteGuerrero().getPuntosVida() - (jugador.getCombatienteMago().getPuntosAtaque() - equipoOponente.getCombatienteGuerrero().getPuntosDefensa()); // se descuenta defensa
                        //Resta vida del oponente
                        equipoOponente.getCombatienteGuerrero().setPuntosVida(dano); 
                        //resta el maná del mago
                        // explicacion variable manaRestado: manaRestado = mana del mago - x
                        int manaRestado = jugador.getCombatienteMago().getPuntosMana() - 35;
                        jugador.getCombatienteMago().setPuntosMana(manaRestado);
                        //muestra al jugador q el mago atacó
                        System.out.println(jugador.getCombatienteMago().getNombre() + " Atacó a " + equipoOponente.getCombatienteGuerrero().getNombre() +"!");
                        System.out.println(jugador.getCombatienteMago().getNombre() + " perdío maná!\n");
                        //como combate es un singleton, solo devuelve la instancia ya creada, asi q los parametros de getInstancia no afectan al objeto 
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++); 
                    }
                    else if (oponenteElegido == 2){
                        int dano = equipoOponente.getCombatienteMago().getPuntosVida() - (jugador.getCombatienteMago().getPuntosAtaque() - equipoOponente.getCombatienteMago().getPuntosDefensa()); // se descuenta defensa
                        equipoOponente.getCombatienteMago().setPuntosVida(dano); //le resta la vida teniendo en cuenta la defensa
                        int manaRestado = jugador.getCombatienteMago().getPuntosMana() - 35;
                        jugador.getCombatienteMago().setPuntosMana(manaRestado);
                        System.out.println(jugador.getCombatienteMago().getNombre() + " Atacó a " + equipoOponente.getCombatienteMago().getNombre() +"!");
                        System.out.println(jugador.getCombatienteMago().getNombre() + " perdío maná!\n");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    } 
                    else if (oponenteElegido == 3){
                        int dano = equipoOponente.getCombatienteSanador().getPuntosVida() - (jugador.getCombatienteMago().getPuntosAtaque() - equipoOponente.getCombatienteSanador().getPuntosDefensa()); // se descuenta defensa
                        equipoOponente.getCombatienteSanador().setPuntosVida(dano); //le resta la vida teniendo en cuenta la defensa
                        int manaRestado = jugador.getCombatienteMago().getPuntosMana() - 35;
                        jugador.getCombatienteMago().setPuntosMana(manaRestado);
                        System.out.println(jugador.getCombatienteMago().getNombre() + " Atacó a " + equipoOponente.getCombatienteSanador().getNombre() +"!");
                        System.out.println(jugador.getCombatienteMago().getNombre() + " perdío maná!\n");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    }
                    else{
                        System.out.println("Vuelva a elegir su oponente porfavor");
                    }
                }
            } 
            // -Escoge defender-
            else if (accionElegida == 2){
               // -Duracion de la accion defender: va a durar 2 turnos por defecto-
                if (jugador.getCombatienteMago().getContTurnosDefensa() < 1){
                    int defensaDuplicada = 2 * jugador.getCombatienteMago().getPuntosDefensa();
                    jugador.getCombatienteMago().setPuntosDefensa(defensaDuplicada);
                    jugador.getCombatienteMago().setContTurnosDefensa(2);
                    System.out.println(jugador.getCombatienteMago().getNombre() + " ha duplicado su defensa!");
                    Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                }
                else{
                    // -Defensa original: si los 2 turnos de defensa ya pasaron, vuelve a su valor original-
                    jugador.getCombatienteMago().setContTurnosDefensa(jugador.getCombatienteGuerrero().getContTurnosDefensa()-1);
                    if (jugador.getCombatienteMago().getContTurnosDefensa() <= 0){
                        int defensaOriginal = jugador.getCombatienteMago().getPuntosDefensa() / 2;
                        jugador.getCombatienteMago().setPuntosDefensa(defensaOriginal);
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    }
                }
            }
            // -Escoge usar objeto-
            else if (accionElegida == 3){
                jugador.getCombatienteGuerrero().getItem().usar(numTurno);
                Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
            }
            else{
                System.out.println("Vuelva a elegir su acción porfavor");
            }
        }
    }         
}