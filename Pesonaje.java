abstract class Personaje{
    //Atributos
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int mana;

    // Constructor
    public Personaje(String nombre, int vida, int ataque, int defensa, int mana){
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.mana = mana;
    }
}