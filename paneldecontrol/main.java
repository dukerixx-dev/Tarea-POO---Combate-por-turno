package paneldecontrol;

import javax.swing.JFrame;

public class  main{
    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("la travesia de tung tung sahur :O");

        paneldejuego paneldejuego = new paneldejuego();
        window.add(paneldejuego);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        paneldejuego.starGameThread();

    }
}