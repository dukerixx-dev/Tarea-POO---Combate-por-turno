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
            System.err.println("se creó la instancia Combate");
        }
        System.err.println("Devolvio la instancia Combate");
        return instancia;
    }

    public void iniciarCombate(){ 
        //reune a los equipos y sus combatientes
        System.out.println("Empezó el combate");
        //equipo1.verEstado()
        //equipo2.verEstado()
        //while Combate.finCombate() == false:
            //determinar a q equipo le toca segun el numTurno
            //preguntar al jugador x (segun q equipo le toca) que combatiente escoge (perElegido)
            //preguntar al jugador x que accion toma el combatiente (atacar, defender, usar objeto)
            //if perElegido == guerrero:
                //guerrero.ejecutarAccion()
            //if perElegido == mago:
                //mago.ejecutarAccion()
            //if perElegido == sanador:
                //sanador.ejecutarAccion()
            //this.numTurno++;
            
            //Combate.finCombate();
    }
    public boolean finCombate(){ 
        //    Pseudocódigo
        //equipo1.verEstado()
        //equipo2.verEstado()
        //Revisar si uno de los equipos tiene todos sus personajes eliminados
        // -Declarar Ganador-
        //if equipo1 == todos personajes Muertos
            //equipo1.setEsPerdedor(true)
            //return true
        //else if equipo2 == todos personajes Muertos: 
            //equipo2.setEsPerdedor(true)
            //return true
        //else:
            return false; 
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
    public void setNumTurno(int numTurno) {
        this.numTurno = numTurno;
    }
    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }
}
