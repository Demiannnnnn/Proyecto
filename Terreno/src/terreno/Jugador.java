package terreno;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;



public class Jugador {

    String color = "";
    public int jugador;
    public Random rand;
    private Tank tanque;
    int random1;
    int random2;
    
    public Tank getTanque() {
        return tanque;
    }
  
    public Jugador(GraphicsContext gc, String color, int jugador){
        this.color = color;
        this.jugador = jugador;
        this.rand=new Random();
        this.random1=rand.nextInt(3);
        this.random2=rand.nextInt(3);
    }
    
    public void creaTanque(GraphicsContext gc, int[][] matriz, int vida, int opcion){
        Tank tanque = new Tank(color, jugador);
        tanque.agregarTanque(gc,this.random1,this.random2, matriz,vida, opcion);
        this.tanque=tanque;
    }

}

