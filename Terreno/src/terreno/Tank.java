package terreno;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Tank{
    public int []posicion={0,0};
    public String color;
    public int jugadorTanque;
    private double angulo;
    private int cañonX;
    private int cañonY;
    int ancho;
    int alto;   
    int vida;
    
    public Tank(String color, int jugador){
        this.color=color;
        this.jugadorTanque = jugador;
        this.ancho=19;
        this.alto=8;
        this.vida = 100;
    }
    
    public int getCañonX() {
        return cañonX;
    }

    public int getCañonY() {
        return cañonY;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public double getAngulo() {
        return angulo;
    }

    public int getVida() {
        return vida;
    }
    
    
    
    public void modificarCañon(GraphicsContext gc, double angulo,int jugador){
        this.angulo = angulo;
        int x = posicion[0];
        int y = posicion[1];
        
        int cx = x + 35;
        int cy = y + 35;
        double anguloRad = Math.toRadians(angulo);

        if (jugador == 1) {
            cañonX = (int) (cx + Math.cos(anguloRad) * 2);
            cañonY = (int) (cy + Math.sin(anguloRad) * 2);
        } 
        else if (jugador == 2) {      
            cañonX = (int) (cx - Math.cos(anguloRad) * 2);
            cañonY = (int) (cy - Math.sin(anguloRad) * 2);
        }
        gc.save();
        gc.translate(cañonX, cañonY);
        gc.rotate(angulo);
        gc.restore();
    }
    
    
    
    public void agregarTanque(GraphicsContext gc, int ran1, int ran2, int[][]matriz,int vida) {
        int[] x=null;
        int[] y=null;
        int opcion = Jugar.getRandom();
        if(opcion == 0){
            if(jugadorTanque == 1){
                x = new int[]{120, 60, 210, 268};
                y = new int[]{546, 500, 480, 390};
            }
            else if(jugadorTanque == 2){
                x = new int[]{842, 1020, 750, 647};
                y = new int[]{580,360, 370, 207};
            }
        }
        if(opcion == 1){
            if(jugadorTanque == 1){
                x = new int[]{100, 60, 160, 205};
                y = new int[]{543, 520, 480, 390};
            }
            else if(jugadorTanque == 2){
                x = new int[]{837, 1070, 738, 960};
                y = new int[]{245,550, 310, 400};
            }
            }
        if(opcion == 2){
            if(jugadorTanque == 1){
                x = new int[]{120, 60, 180, 50};
                y = new int[]{370, 400, 380,400};
            }
            else if(jugadorTanque == 2){
                x = new int[]{900, 1020, 1110, 695};
                y = new int[]{580,360, 340, 207};
            }
        }
        if (x != null && y != null) {
            Image tanque = new Image(getClass().getResourceAsStream(color));
            gc.drawImage(tanque, x[ran1], y[ran1], 70, 70);
            posicion[0] = x[ran1] + 6;
            posicion[1] = y[ran1] + 13;
        }
            int hitboxAncho=1;
            int hitboxLargo=2;
            for(int i=0;i<ancho+hitboxAncho;i++){
                for (int j=0;j<alto+hitboxLargo;j++){
                   //actualizar la colicion de la matriz
                   int posXMatriz = (posicion[0] / 3 + i);
                   int posYMatriz = (posicion[1] / 3 + j);
                   if (posXMatriz >= 0 && posXMatriz < matriz.length && posYMatriz >= 0 && posYMatriz < matriz[0].length){
                       matriz[posXMatriz][posYMatriz] = 2;
                   }
               }
            } 
            this.vida=vida;
        System.out.println(ran1);
    }
    

    public int ajustar_vida(int vida){
        this.vida-=vida;
        System.out.println("Vida actual del tanque = "+ this.vida);
        return this.vida;
    }
}
