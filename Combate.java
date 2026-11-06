import java.util.Scanner;
public class Combate {
    private static Combate instancia;
    private Equipo equipo1;
    private Equipo equipo2;
    private int numTurno;
    private Equipo equipoGanador;

    //contructor privado, nadie puede instanciar directamente desde fuera
    private Combate(Equipo equipo1, Equipo equipo2, int numTurno, Equipo equipoGanador) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.numTurno = numTurno;
        this.equipoGanador = equipoGanador;
    }
    
    public static synchronized Combate getInstancia(Equipo equipo1, Equipo equipo2, 
                                int numTurno, Equipo equipoGanador){
        if (instancia == null){
            instancia = new Combate(equipo1, equipo2, numTurno, equipoGanador);
        }
        return instancia;
    }

    /**
     * Reune a los equipos y a sus combatientes, y los hace combatir.
     * 
     * @author Jorge almonacid
     * @version 1.0
     * @param lectorScanner: Recibe las entradas del jugador
     * @return Void
     */
    public void iniciarCombate(Scanner lectorScanner){ 
        Equipo jugador = equipo1;   //Se creó para empezar el ciclo while y para recibir uno de los equipos de los jugadores.
        Equipo equipoOponente;
        System.out.println("\n----Empezó el combate----");
        while (!finCombate(jugador)){  
            int personajeElegido = 0;   //Se creo empezar el ciclo while y recibir el personaje elegido.
            // -Mostrar y revisar estado equipos-
            System.out.println("Turno: " + this.numTurno);
            equipo1.verEstadoEquipo();
            equipo2.verEstadoEquipo();
            // -Determinar que equipo y jugador le toca segun numTurno- 
            if (numTurno % 2 == 1 ){
                jugador = equipo1;
                equipoOponente = equipo2;
            } else{
                jugador = equipo2;
                equipoOponente = equipo1;
            }
            // -Escoger personaje-
            while (personajeElegido < 1 | personajeElegido > 3){
                System.out.println(jugador.getNombre()+ " | ¿Qué personaje escoge?");
                System.out.println(jugador.getCombatienteGuerrero().getNombre() +" (1), "+ 
                                    jugador.getCombatienteMago().getNombre() + " (2), "+ 
                                    jugador.getCombatienteSanador().getNombre() +" (3)?");
                personajeElegido = lectorScanner.nextInt();        
                if (personajeElegido == 1){
                    jugador.getCombatienteGuerrero().ejecutarAccion(jugador, equipoOponente,numTurno, lectorScanner);
                }
                else if (personajeElegido == 2){
                    jugador.getCombatienteMago().ejecutarAccion(jugador, equipoOponente, numTurno, lectorScanner);
                }
                else if (personajeElegido == 3){
                    jugador.getCombatienteSanador().ejecutarAccion(jugador, equipoOponente, numTurno, lectorScanner);
                } 
                else{
                    System.out.println("Vuelva a elegir su personaje porfavor equipo " + jugador.getNombre());
                }
            }

            this.numTurno++;
            finCombate(jugador);
        }
        
    }
    /**
     * Determina el fin del combate si el jugador tiene todos sus personajes eliminados.
     * 
     * @author Jorge almonacid
     * @version 1.0
     * @param jugador: El jugador y su equipo concurrente.
     * @return si el combate a terminado o no.
     */
    public boolean finCombate(Equipo jugador){ 
        //-Declarar Ganador-
        if (jugador.getEsPerdedor()){
            // -Mostrar al jugador que equipo ganó-
            System.out.println("El equipo " + jugador.getNombre() + "tiene a todos su personajes eliminados.");
            return true;
        } else{
            return false;
        }
    }
    //  GETTERS Y SETTERS
    //getters
    public Equipo getEquipo1() {
        return equipo1;
    }
    public Equipo getEquipo2() {
        return equipo2;
    }
    public int getNumTurno() {
        return numTurno;
    }
    public Equipo getEquipoGanador() {
        return equipoGanador;
    }
    //setters
    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }
    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public static void setInstancia(Combate instancia) {
        Combate.instancia = instancia;
    }

    public void setNumTurno(int numTurno) {
        this.numTurno = numTurno;
    }
    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }
}
