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

    public void verEstadoEquipo(){
        //Muestra el estado de los 3 combatientes del equipo
        System.out.println(" Equipo " + this.nombre );
        Personaje[] combatientes = {this.combatienteGuerrero, this.combatienteMago, this.combatienteSanador};
        for (Personaje p : combatientes){
            // Un personaje con 0 de vida se marca como K.O.
            String estado = (p.getPuntosVida() <= 0) ? " (K.O.)" : "";
            //si el objeto es valido se muestra su nombre, si no se muestra "sin objeto"
            String objeto = (p.getItem() != null) ? p.getItem().getNombre() : "sin objeto";
            System.out.println(p.getNombre() + estado
                    + " | Vida: " + p.getPuntosVida()
                    + " | Maná: " + p.getPuntosMana()
                    + " | Ataque: " + p.getPuntosAtaque()
                    + " | Defensa: " + p.getPuntosDefensa()
                    + " | Objeto: " + objeto);
        }
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
