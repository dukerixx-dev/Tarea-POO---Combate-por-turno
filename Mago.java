import java.util.Scanner;
public class Mago extends Personaje {
    //constructor
    public Mago(String nombre, int puntosVida,  int puntosMana, int puntosAtaque, 
                    int puntosDefensa, Item items){
        super(nombre, puntosVida, puntosMana, puntosAtaque, puntosDefensa, items);
    }

    public void ejecutarAccion(Equipo jugador, Equipo equipoOponente,int numTurno, Scanner lectorScanner){
        //Ataca a sus oponentes usando mana
        int accionElegida = 0;
        int contDefensa = 0;
        while (accionElegida < 1 | accionElegida >3){
            //revisa si el jugador ha selecionado "defender" en su anterior turno

            System.out.println("¿Qué accion desea ejecutar?");
            System.out.println("Atacar (1), Defender (2), Usar Objeto (3).");
            accionElegida = lectorScanner.nextInt();
            // -si jugador escoge atacar-
            if (accionElegida == 1){
                int oponenteElegido = 0;
                //preguntar al jugador que combatiente enemigo escoge para realizar daño
                while (oponenteElegido < 1 | oponenteElegido > 3){
                    System.out.println("¿A quién desea atacar del equipo " + equipoOponente.getNombre() +"?");
                    System.out.println(equipoOponente.getCombatienteGuerrero().getNombre() +" (1), "+ 
                                        equipoOponente.getCombatienteMago().getNombre() + " (2), "+ 
                                        equipoOponente.getCombatienteSanador().getNombre() +" (3)?");
                    oponenteElegido = lectorScanner.nextInt();
                    //cambiar los stats del combatiente enemigo escogido segun los stats del Mago
                    if (oponenteElegido == 1){
                        //explicacion variable dano: dano = vida del oponente elegido - (puntos de ataque del Mago - defensa del oponente elegido)
                        int dano = equipoOponente.getCombatienteGuerrero().getPuntosVida() - (jugador.getCombatienteMago().getPuntosAtaque() - equipoOponente.getCombatienteGuerrero().getPuntosDefensa()); // se descuenta defensa
                        equipoOponente.getCombatienteGuerrero().setPuntosVida(dano); 
                        //restar maná del mago
                        jugador.getCombatienteMago().restarPuntosMana(35);
                        //muestra al jugador q el mago atacó
                        System.out.println(jugador.getCombatienteMago().getNombre() + " Atacó a " + equipoOponente.getCombatienteGuerrero().getNombre() +"!");
                        System.out.println(jugador.getCombatienteMago().getNombre() + " perdío maná!\n");
                        //como combate es un singleton, solo devuelve la instancia ya creada, asi q los parametros de getInstancia no afectan al objeto 
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++); 
                    }
                    else if (oponenteElegido == 2){
                        int dano = equipoOponente.getCombatienteMago().getPuntosVida() - (jugador.getCombatienteMago().getPuntosAtaque() - equipoOponente.getCombatienteMago().getPuntosDefensa()); // se descuenta defensa
                        //Resta vida del oponente
                        equipoOponente.getCombatienteMago().setPuntosVida(dano); //le resta la vida teniendo en cuenta la defensa
                        //restar maná del mago
                        jugador.getCombatienteMago().restarPuntosMana(35);
                        //muestra al jugador q el mago atacó
                        System.out.println(jugador.getCombatienteMago().getNombre() + " Atacó a " + equipoOponente.getCombatienteMago().getNombre() +"!");
                        System.out.println(jugador.getCombatienteMago().getNombre() + " perdío maná!\n");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    } 
                    else if (oponenteElegido == 3){
                        int dano = equipoOponente.getCombatienteSanador().getPuntosVida() - (jugador.getCombatienteMago().getPuntosAtaque() - equipoOponente.getCombatienteSanador().getPuntosDefensa()); // se descuenta defensa
                        //Resta vida del oponente
                        equipoOponente.getCombatienteSanador().setPuntosVida(dano); //le resta la vida teniendo en cuenta la defensa
                        //restar maná del mago
                        jugador.getCombatienteMago().restarPuntosMana(35);
                        //muestra al jugador q el mago atacó
                        System.out.println(jugador.getCombatienteMago().getNombre() + " Atacó a " + equipoOponente.getCombatienteSanador().getNombre() +"!");
                        System.out.println(jugador.getCombatienteMago().getNombre() + " perdío maná!\n");
                        Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
                    }
                    else{
                        System.out.println("Vuelva a elegir su oponente porfavor");
                    }
                }
            } 
            // si jugador escoge defender
            else if (accionElegida == 2){
               // jugador.getCombatienteGuerrero().setTemporalPuntosDefensa( 2);
            }
            // si jugador escoge usar objeto
            else if (accionElegida == 3){
                jugador.getCombatienteGuerrero().getItem().usar(numTurno);
                Combate.getInstancia(equipoOponente, equipoOponente, 67, null).setNumTurno(numTurno++);
            }
            else{
                System.out.println("Vuelva a elegir su acción porfavor");
            }
        }

        //si el jugador escoge defender:
    }         //se duplica la defensa del personaje elegido
}