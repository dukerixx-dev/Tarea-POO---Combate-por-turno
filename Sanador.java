import java.util.Scanner;
public class Sanador extends Personaje {

    //constructor
    public Sanador(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, 
                    int puntosDefensa, Item items){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, items);
    }

    public void ejecutarAccion(Equipo jugador, Equipo equipoOponente, int numTurno, Scanner lectorScanner){
        //aumenta puntos de vida a sus aliados
        int accionElegida = 0;
        int contDefensa = 0;
        while (accionElegida < 1 | accionElegida >3){
            //revisa si el jugador ha selecionado "defender" en su anterior turno

            System.out.println("¿Qué accion desea ejecutar?");
            System.out.println("Curar (1), Defender (2), Usar Objeto (3).");
            accionElegida = lectorScanner.nextInt();
            // -si jugador escoge atacar-
            if (accionElegida == 1){
                int aliadoElegido = 0;
                //preguntar al jugador que combatiente enemigo escoge para realizar daño
                while (aliadoElegido < 1 | aliadoElegido > 3){
                    System.out.println("¿A quién desea atacar del equipo " + equipoOponente.getNombre() +"?");
                    System.out.println(equipoOponente.getCombatienteGuerrero().getNombre() +" (1), "+ 
                                        equipoOponente.getCombatienteMago().getNombre() + " (2), "+ 
                                        equipoOponente.getCombatienteSanador().getNombre() +" (3)?");
                    aliadoElegido = lectorScanner.nextInt();
                    if (aliadoElegido == 1){
                        //los puntos de ataque actuan como curacion
                        int curacion = jugador.getCombatienteSanador().getPuntosAtaque();
                        //añade los puntos de vida al aliado elegido
                        jugador.getCombatienteGuerrero().añadirPuntosVida(curacion);
                        System.out.println(jugador.getCombatienteSanador().getNombre() + " Curó a " + jugador.getCombatienteGuerrero().getNombre() +"!\n");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    }
                    else if (aliadoElegido == 2){
                        //los puntos de ataque actuan como curacion
                        int curacion = jugador.getCombatienteSanador().getPuntosAtaque();
                        //añade los puntos de vida al aliado elegido
                        jugador.getCombatienteMago().añadirPuntosVida(curacion);
                        System.out.println(jugador.getCombatienteSanador().getNombre() + " Curó a " + jugador.getCombatienteMago().getNombre() +"!\n");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    } 
                    else if (aliadoElegido == 3){
                        //los puntos de ataque actuan como curacion
                        int curacion = jugador.getCombatienteSanador().getPuntosAtaque();
                        //añade los puntos de vida al aliado elegido
                        jugador.getCombatienteSanador().añadirPuntosVida(curacion);
                        System.out.println(jugador.getCombatienteSanador().getNombre() + " se curó a si mismo!\n ");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    }
                    else{
                        System.out.println("Vuelva a elegir su aliado porfavor");
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
    }

}