public class Item{
    //quizas se agreguen atributos aca, como nombre, duracionTurnos, tipo
    private String nombre;
    private String descripcion;
    private int duracionTurnos;
    private int tipo;
    private int contUsos;
    private int valorEfecto = 67; // lo usamos para aplicar o quitar el efecto 
    private int turnoFinEfecto = 0; //con turno controlamos los efectos activos

    //constructor
    public Item(String nombre, String descripcion, int duracionTurnos, int tipo, int contUsos){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.duracionTurnos = duracionTurnos;
        this.contUsos = contUsos;
    }
    public void usar(Personaje portador, int numTurno){

    if (this.contUsos < 1){
        int duracionEfecto = this.duracionTurnos; //en el enunciado se limita el efecto a 3 turnos como max
        if (duracionEfecto > 3){
            duracionEfecto = 3;
        }
        if (this.tipo == 1){
            portador.añadirPuntosAtaque(this.valorEfecto);
            System.out.println(portador.getNombre() + " subio su ataque en " + this.valorEfecto);
        }
        if(this.tipo == 2){
            portador.añadirPuntosDefensa(this.valorEfecto);
            System.out.println(portador.getNombre() + " subio su defensa en " + this.valorEfecto);
        }
        if (this.tipo == 3){
            portador.setPuntosVida(this.valorEfecto);
            System.out.println(portador.getNombre() + " recuperas " + this.valorEfecto + "de vida" );
        }
        if(this.tipo == 1 || this.tipo == 2 ){
            this.turnoFinEfecto = numTurno + duracionEfecto * 2;
        }
        this.contUsos++;
    }    
        else {
            System.out.println(portador.getNombre() +  "no puedes volver a usar un objeto ");
        }
    }
    public void verificarEfecto(Personaje portador, int numTurno){
    if (this.turnoFinEfecto > 0 && numTurno >= this.turnoFinEfecto){
        if (this.tipo == 1){
            portador.añadirPuntosAtaque(-this.valorEfecto);
        }
        if (this.tipo == 2){
            portador.añadirPuntosDefensa(-this.valorEfecto);
        }
        this.turnoFinEfecto = 0;
        System.out.println("Se acabó el efecto de " + this.nombre + " en " + portador.getNombre());
    }
}
    //  GETTERS Y SETTERS
    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getDuracionTurnos() {
        return duracionTurnos;
    }
    public int getTipo() {
        return tipo;
    }
    public int getCont() {
        return contUsos;
    }
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setDuracionTurnos(int duracionTurnos) {
        this.duracionTurnos = duracionTurnos;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public void setCont(int contUsos) {
        this.contUsos = contUsos;
    }
}