import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner lectorScanner = new Scanner(System.in);
        //INSTANCIACION DE CLASES
        //items
        // crearemos 3 items, cualquiera de los combatientes lo pueden usar
        Item iAtaque = new Item("Ataque+", "Aumenta un 25 de daño en el siguiente ataque por 2 turnos", 
                        2,1,0); //(tipo 1 = ataque)
        Item iDefensa = new Item("Defensa+", "Aumenta 30 de defensa por 3 turnos",
                        3, 2,0); //(tipo 2 = defensa)
        Item iCuracion = new Item("pocion de Curación", "Aumenta x de puntos de vida al personaje",
                        1, 3, 0); //(tipo 3 = curacion)
        Item[] items = {iAtaque, iDefensa, iCuracion};
        //combatientes
        Guerrero guerrero1 = new Guerrero("Enrique el Guerrero", 150, 
                            0, 80, 40, items); //(1 = perElegido)
        Mago mago1 = new Mago("Pepe el Mago", 80, 
                            100, 80, 20, items); //(2 = perElegido)
        Sanador sanador1 = new Sanador("Sulivan el Sanador", 
                            120, 67, 0, 35, items); //(3 = perElegido)
        Guerrero guerrero2 = new Guerrero("Paco el Guerrero", 150, 
                            0, 80, 40, items); //(1 = perElegido)
        Mago mago2 = new Mago("Epep el Mago", 80, 
                            100, 80, 20, items); //(2 = perElegido)
        Sanador sanador2 = new Sanador("Mike el Sanador", 
                            120, 67, 0, 35, items); //(3 = perElegido)
        //equipos
        // el equipo 1 tendra su turno cuando este sea impar, y el equipo 2 cuando sea par.
        System.out.println("Que nombre quiere colocarle a su equipo jugador 1?: ");
        String nombreEquipo1 = lectorScanner.next();
        Equipo equipo1 = new Equipo(nombreEquipo1, guerrero1, mago1, sanador1,1,false);
        System.out.println("Que nombre quiere colocarle a su equipo jugador 2?: ");
        String nombreEquipo2 = lectorScanner.next();
        Equipo equipo2 = new Equipo(nombreEquipo2, guerrero2, mago2, sanador2, 2, false);
        //combate
        Combate.getInstancia(equipo1, equipo2, 1, null);

        //  pseudocódigo
        //Combate.iniciarCombate(Scanner lectorScanner);
        //ver q equipo gano y mostrarselo al jugador (usuario)
    }
}