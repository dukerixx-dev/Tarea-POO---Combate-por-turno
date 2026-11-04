public class Equipo {
    private String nombre;
    private Guerrero combatienteGuerrero;
    private Mago combatienteMago;
    private Sanador combatienteSanador;
    private int turno;
    private boolean esPerdedor;

    //constructor
    public Equipo(String nombre, Guerrero combatienteGuerrero, Mago combatienteMago,
                    Sanador combatienteSanador,int turno, boolean esPerdedor){
        this.nombre = nombre;
        this.combatienteGuerrero = combatienteGuerrero;
        this.combatienteMago = combatienteMago;
        this.combatienteSanador = combatienteSanador;
        this.turno = turno;
        this.esPerdedor = esPerdedor;
    }

    private void verEstadoEquipo(){
        //Revisa el estado y las estadisticas de los personajes y los muestra al jugador.
    }

    //  GETTERS Y SETTERS
    //Getters
    public String getNombre() {
        return nombre;
    }
    public Guerrero getCombatienteGuerrero() {
        return combatienteGuerrero;
    }
    public Mago getCombatienteMago() {
        return combatienteMago;
    }
    public Sanador getCombatienteSanador() {
        return combatienteSanador;
    }
    public int getTurno() {
        return turno;
    }
    public boolean getEsPerdedor() {
        return esPerdedor;
    }
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCombatienteGuerrero(Guerrero combatienteGuerrero) {
        this.combatienteGuerrero = combatienteGuerrero;
    }
    public void setCombatienteMago(Mago combatienteMago) {
        this.combatienteMago = combatienteMago;
    }
    public void setCombatienteSanador(Sanador combatienteSanador) {
        this.combatienteSanador = combatienteSanador;
    }
    public void setTurno(int turno) {
        this.turno = turno;
    }
    public void setEsPerdedor(boolean esPerdedor) {
        this.esPerdedor = esPerdedor;
    }
}
