import java.util.Scanner;
public class Guerrero extends Personaje{
    //constructor
    public Guerrero(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, 
                    int puntosDefensa, Item items, int contTurnosDefensa){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, items, contTurnosDefensa);
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
        // -Escoger accion-
        while (accionElegida < 1 | accionElegida >3){
            //revisa si el jugador ha selecionado "defender" en su anterior turno
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
                    // -cambia los puntos de vida del oponente, segun la defensa de este y los puntos de ataque del guerrero-
                    if (oponenteElegido == 1){
                        //explicacion variable dano: dano = vida del oponente elegido - (puntos de ataque del guerrero - defensa del oponente elegido)
                        int dano = equipoOponente.getCombatienteGuerrero().getPuntosVida() - (jugador.getCombatienteGuerrero().getPuntosAtaque() - equipoOponente.getCombatienteGuerrero().getPuntosDefensa()); // se descuenta defensa
                        //Resta vida del oponente
                        equipoOponente.getCombatienteGuerrero().setPuntosVida(dano); 
                        System.out.println(jugador.getCombatienteGuerrero().getNombre() + " Atacó a " + equipoOponente.getCombatienteGuerrero().getNombre() +"!\n");
                        //como combate es un singleton, solo devuelve la instancia ya creada, asi q los parametros de getInstancia no afectan al objeto 
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
            // -Escoge defender-
            else if (accionElegida == 2){
                // -Duracion de la accion defender: va a durar 2 turnos por defecto-
                if (jugador.getCombatienteGuerrero().getContTurnosDefensa() < 1){
                    int defensaDuplicada = 2 * jugador.getCombatienteGuerrero().getPuntosDefensa();
                    jugador.getCombatienteGuerrero().setPuntosDefensa(defensaDuplicada);
                    jugador.getCombatienteGuerrero().setContTurnosDefensa(2);
                    System.out.println(jugador.getCombatienteGuerrero().getNombre() + " ha duplicado su defensa!");
                    Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                }
                else{
                    // -defensa original: si los 2 turnos de defensa ya pasaron, vuelve a su valor original
                    jugador.getCombatienteGuerrero().setContTurnosDefensa(jugador.getCombatienteGuerrero().getContTurnosDefensa()-1);
                    if (jugador.getCombatienteGuerrero().getContTurnosDefensa() <= 0){
                        int defensaOriginal = jugador.getCombatienteGuerrero().getPuntosDefensa() / 2;
                        jugador.getCombatienteGuerrero().setPuntosDefensa(defensaOriginal);
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