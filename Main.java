public class Main{
    public static void main(String[] args) {
        //INSTANCIACION DE CLASES
        //items
        Item xd = new Item(); // crearemos 3 items, cualquera de los combatientes lo pueden usar
        Item nombreI2 = new Item();
        Item nombreI3 = new Item();
        //combatientes
            //el 67 y el item xd estan de plantilla, despues los cambiamos
        Guerrero Guerrero1 = new Guerrero("Enrique el Guerrero", 100, 67, 67, 67, xd);
        Mago Mago1 = new Mago("Pepe el Mago", 100, 67, 67, 67, xd);
        Sanador Sanador1 = new Sanador("Sulivan el Sanador", 100, 67, 67, 67, xd);
        //(aqui irian los segundos combatientes, una vez hemos corregido a los anteriores copiaremos y pegaremos nomas)

    }
}