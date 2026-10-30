

import java.awt.color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class paneldejuego extends JPanel implements Runnable {

    //configuracion de pantalla
    final int originalTileSIze = 16 ; //pantalla de 16x16
    final int scale = 3 ;

    final int TileSIze = originalTileSIze * scale; //48x48
    final int maxColumna = 20 ;
    final int maxFilas = 10 ;
    final int screenAltura = TileSIze * maxColumna; // 320 pixeles
    final int screeenAncho = TileSIze * maxFilas ; // 160 pixeles

    Thread GameThread ;

    public paneldejuego() {

        this.setPreferredSize(new Dimension(screenAltura ,screeenAncho));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {

        GameThread = new Thread(this);
        GameThread.start();

    }
    @override 
    
    public void run() {

    while(GameThread != null) {

        update();

        repaint();
        
    }
    }
    public void update(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g) ;

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

    }

}