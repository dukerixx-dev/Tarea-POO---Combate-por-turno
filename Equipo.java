public class Equipo {
    private String nombre;
    private Guerrero combatienteGuerrero;
    private Mago combatienteMago;
    private Sanador combatienteSanador;

    //constructor
    public Equipo(String nombre, Guerrero combatienteGuerrero, Mago combatienteMago, Sanador combatienteSanador) {
        this.nombre = nombre;
        this.combatienteGuerrero = combatienteGuerrero;
        this.combatienteMago = combatienteMago;
        this.combatienteSanador = combatienteSanador;
    }

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

    e
}
