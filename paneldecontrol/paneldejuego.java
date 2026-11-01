import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    //FpS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread GameThread ;

    //posicion del jugador
    int jugadorX = 100;
    int jugadorY = 100;
    int Velocidad = 4;

    public paneldejuego() {

        this.setPreferredSize(new Dimension(screenAltura ,screeenAncho));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        GameThread = new Thread(this);
        GameThread.start();

    }
    @Override
    
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        
    while(GameThread != null) {

        
        update();

        repaint();
        
        try {
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime/1000000;

            if(remainingTime < 0){
                remainingTime = 0;
            }

            Thread.sleep((long)remainingTime);

            nextDrawTime += drawInterval;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
    public void update(){

        if(keyH.arriba == true){
            jugadorY -= Velocidad;
        }
        else if(keyH.abajo == true){
            jugadorY += Velocidad;
        }
        else if(keyH.izquierda == true){
            jugadorX -= Velocidad;
        }
        else if(keyH.derecha == true){
            jugadorX += Velocidad;
        }

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.fillRect(jugadorX, jugadorY, TileSIze, TileSIze);
        g2.dispose();
    }

    public class KeyHandler implements KeyListener {
        boolean arriba;
        boolean abajo;
        boolean izquierda;
        boolean derecha;

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> arriba = true;
                case KeyEvent.VK_DOWN -> abajo = true;
                case KeyEvent.VK_LEFT -> izquierda = true;
                case KeyEvent.VK_RIGHT -> derecha = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> arriba = false;
                case KeyEvent.VK_DOWN -> abajo = false;
                case KeyEvent.VK_LEFT -> izquierda = false;
                case KeyEvent.VK_RIGHT -> derecha = false;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }
}