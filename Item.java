public class Item{
    //quizas se agreguen atributos aca, como nombre, duracionTurnos, tipo
    private String nombre;
    private String descripcion;
    private int duracionTurnos;
    private int tipo;
    private int contUsos;

    //constructor
    public Item(String nombre, String descripcion, int duracionTurnos, int tipo, int contUsos){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.duracionTurnos = duracionTurnos;
        this.contUsos = contUsos;
    }
    public void usar(int tipo, int numTurnos){
        //  Pseudocódigo
        //int contUsos = this.contUsos;
        //int contEfecto = 0 (o 1, nose)
        //verificar si el combatiente ha usado un objeto o no (solo puede usar un objeto una sola vez).
        //if contUsos < 1:
            //if tipo == 1 (ataque):
                //aplicar el efecto
            //if tipo == 2 (defensa):
                //aplicar el efecto
            //if tipo == 3 (curacion):
                //aplicar el efecto
            //this.cont++;
        //else:
            //decirle al jugador que no puede volver a usar un objeto

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