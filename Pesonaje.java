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

    public void atacar(Personaje enemigo){
        enemigo.recibirDanio(this.ataque);
        System.out.println(this.nombre + " ataca a " + enemigo.getNombre() + " causando " + this.ataque + " de daño.");
}
    public void recibirdanio(int cantidad){
        this.vida -= cantidad;
        if(this.vida < 0){
            this.vida = 0;
        }
    }
    public boolean estaVivo(){
        return this.vida > 0;
    }
}