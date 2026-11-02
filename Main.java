public class Main{
    public static void main(String[] args) {
        //INSTANCIACION DE CLASES
        //items
        Item iAtaque = new Item("Ataque+", "Aumenta un 25 de daño en el siguiente ataque por 2 turnos"); // crearemos 3 items, cualquera de los combatientes lo pueden usar
        Item iDefensa = new Item("Defensa+", "Aumenta 30 de defensa por 3 turnos");
        Item iCuchillo = new Item("Cuchilo Arrojadizo", "Arroja un cuchillo a tu oponenta y da 45 de daño");
        //combatientes
            //el 67 y el item xd estan de plantilla, despues los cambiamos
        Guerrero Guerrero1 = new Guerrero("Enrique el Guerrero", 150, 0, 80, 40, );
        Mago Mago1 = new Mago("Pepe el Mago", 80, 100, 80, 20, xd);
        Sanador Sanador1 = new Sanador("Sulivan el Sanador", 120, 80, 0, 35, xd);

      
        //preguntar al jugador el nombre de su equipo

        //preguntar al jugador que combatiente escoge

        //preguntar al jugador que accion toma el combatiente (atacar, defender, usar objeto)

            //si jugador escoge atacar:
                //preguntar al juagor que combatiente enemigo escoge
                //se ejecuta la acccion del combatiente
            //si el jugador escoge defender:
                //
            //si el jugador escoge usar objeto
                //verificar si el combatiente ha usado un objeto o no (solo puede usar un objeto una sola vez)
                //preguntar al jugador que objeto quiere escoger (nombre descripcion del objeto)
                //usar accion del objeto


    }
}