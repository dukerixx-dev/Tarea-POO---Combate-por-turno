import java.util.Scanner;
public class Sanador extends Personaje {

    //constructor
    public Sanador(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, 
                    int puntosDefensa, Item items, int contTurnosDefensa){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, items, contTurnosDefensa);
    }

    public void ejecutarAccion(Equipo jugador, Equipo equipoOponente, int numTurno, Scanner lectorScanner){
        //aumenta puntos de vida a sus aliados
        int accionElegida = 0;
        // -Escoger accion-
        while (accionElegida < 1 | accionElegida >3){
            //revisa si el jugador ha selecionado "defender" en su anterior turno

            System.out.println("¿Qué accion desea ejecutar?");
            System.out.println("Curar (1), Defender (2), Usar Objeto (3).");
            accionElegida = lectorScanner.nextInt();
            // -Escoge atacar-
            if (accionElegida == 1){
                int aliadoElegido = 0;
                // -Escoger oponente-
                while (aliadoElegido < 1 | aliadoElegido > 3){
                    System.out.println("¿A quién desea atacar del equipo " + equipoOponente.getNombre() +"?");
                    System.out.println(equipoOponente.getCombatienteGuerrero().getNombre() +" (1), "+ 
                                        equipoOponente.getCombatienteMago().getNombre() + " (2), "+ 
                                        equipoOponente.getCombatienteSanador().getNombre() +" (3)?");
                    aliadoElegido = lectorScanner.nextInt();
                    // -Cura al aliado, segun los puntos de ataque del sanador, el cual actua como curacion-
                    if (aliadoElegido == 1){
                        //explicacion variable vidaCurada: vidacurada = vida concurrente del aliado + puntos de ataque del sanador
                        int vidaCurada = jugador.getCombatienteGuerrero().getPuntosVida() + jugador.getCombatienteSanador().getPuntosAtaque();
                        //añade los puntos de vida al aliado elegido
                        jugador.getCombatienteGuerrero().setPuntosVida(vidaCurada);
                        //Muestra al jugador que el sanador curó
                        System.out.println(jugador.getCombatienteSanador().getNombre() + " Curó a " + jugador.getCombatienteGuerrero().getNombre() +"!\n");
                        //como combate es un singleton, solo devuelve la instancia ya creada, asi q los parametros de getInstancia no afectan al objeto
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    }
                    else if (aliadoElegido == 2){
                        int vidaCurada = jugador.getCombatienteMago().getPuntosVida() + jugador.getCombatienteSanador().getPuntosAtaque();
                        jugador.getCombatienteMago().setPuntosVida(vidaCurada);
                        System.out.println(jugador.getCombatienteSanador().getNombre() + " Curó a " + jugador.getCombatienteMago().getNombre() +"!\n");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    } 
                    else if (aliadoElegido == 3){
                        int vidaCurada = jugador.getCombatienteSanador().getPuntosVida() + jugador.getCombatienteSanador().getPuntosAtaque();
                        jugador.getCombatienteSanador().setPuntosVida(vidaCurada);
                        System.out.println(jugador.getCombatienteSanador().getNombre() + " se curó a si mismo!\n ");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    }
                    else{
                        System.out.println("Vuelva a elegir su aliado porfavor");
                    }
                }
            } 
            // -Escoge defender-
            else if (accionElegida == 2){
               // -Duracion de la accion defender: va a durar 2 turnos por defecto-
                if (jugador.getCombatienteSanador().getContTurnosDefensa() < 1){
                    int defensaDuplicada = 2 * jugador.getCombatienteSanador().getPuntosDefensa();
                    jugador.getCombatienteSanador().setPuntosDefensa(defensaDuplicada);
                    jugador.getCombatienteSanador().setContTurnosDefensa(2);
                    System.out.println(jugador.getCombatienteSanador().getNombre() + " ha duplicado su defensa!");
                    Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                }
                else{
                    // -Defensa original: si los 2 turnos de defensa ya pasaron, vuelve a su valor original-
                    jugador.getCombatienteSanador().setContTurnosDefensa(jugador.getCombatienteGuerrero().getContTurnosDefensa()-1);
                    if (jugador.getCombatienteSanador().getContTurnosDefensa() <= 0){
                        int defensaOriginal = jugador.getCombatienteSanador().getPuntosDefensa() / 2;
                        jugador.getCombatienteSanador().setPuntosDefensa(defensaOriginal);
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