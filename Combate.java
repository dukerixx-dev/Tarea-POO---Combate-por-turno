public class Combate {
    //private nose algo del singleton
    private Equipo equipo1;
    private Equipo equipo2;
    private int numRonda;
    private Equipo equipoGanador;

    //contructor
    public Combate(Equipo equipo1, Equipo equipo2, int numRonda, Equipo equipoGanador) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.numRonda = numRonda;
        this.equipoGanador = equipoGanador;
    }
    
    

    //public static obtenerInstancia(){} -> Singleton

    private void iniciarCombate(){
        //reune a los equipos y sus combatientes
        //fin (lo demas lo hace los metodos de los combatientes)

    }
    private void verificarEstadoEquipo(){
        //revisa los puntos de vida de los combatientes que hay en un equipo
        //si hay uno o dos que estan 0 de vida, no participan en el combate.
    }
    private void examinarYCambiarEstadoCombatiente(){
        //revisa los atributos del combatiente elegido por el jugador y del oponente elegido.
        //en base a eso, cambia los valores del combatiente oponente.
        //si el cambio llega a hacer los puntos de vida 0 o negativos, envia al combatiente al metodo eliminarCombatienteEliminado()
    }
    private void eliminarCombatienteEliminado(){
        //hace el proceso de eliminar el combatiente segun su hp al llegar a 0
    }
    private String definirEquipoGanador(){
        //revisa los puntos de vida de los combatientes que hay en un equipo
        //si evalua que todos los combatientes en un equipo tienen 0 de vida , significa que ese perdió
        //por lo que el otro equipo ganó
        
    }
}
