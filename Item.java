public class Item{
    //quizas se agreguen atributos aca, como nombre, duracionTurnos, tipo
    private String nombre;
    private String descripcion;

    public Item(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public void usar(){

    }

    //  GETTERS Y SETTERS
    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}