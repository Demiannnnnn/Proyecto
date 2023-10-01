
package terreno;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Terreno{
    public int[][] matriz;
    public int pixel;
    public int[][]dunas;
    Image nieve = new Image(getClass().getResourceAsStream("frozen.jpg"));
    Image desierto  = new Image(getClass().getResourceAsStream("d3.jpg"));
    Image lol = new Image(getClass().getResourceAsStream("lolo.jpg"));
    Jugador jugador1;
    Jugador jugador2;


    public Terreno(int alto, int ancho, int pixel,Jugador jugador1, Jugador jugador2,GraphicsContext gc ) {
        this.pixel=pixel;
        this.matriz=new int[alto][ancho];
        this.dunas=new int[alto][ancho];
        this.jugador1=jugador1;
        this.jugador2 = jugador2;
    }

    public void iniciar() {
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++) {
                matriz[i][j]=0;
            }
        }
        for(int i=0;i<dunas.length;i++) {
            for(int j=0;j<dunas[i].length;j++) {
                dunas[i][j]=0;
            }
        }
    }
    public void agregarImagenDeFondo(GraphicsContext gc, int opcion) {
        if (opcion == 1) {
            gc.drawImage(nieve, 0, 0, 400 * pixel, 320 * pixel);//MODIFICACION
        }
        if (opcion == 2) {
            gc.drawImage(desierto, 0, 0, 400 * pixel, 320 * pixel);//MODIFICACION
        }
        if (opcion == 3) {
            gc.drawImage(lol, 0, 0, 400 * pixel, 320 * pixel);//MODIFICACION
        }

    }

    public void terreno_nieve(GraphicsContext gc, Double angulo, int vida) {
        int alto = 400;
        int ancho = 300;
        int escala = this.pixel;
        double nivel_mar = 0.5;//MODIFICACION
        double amplitud = 0.17;
        double frecuencia = 0.03;
        agregarImagenDeFondo(gc,2);
        
        for (int i = 0; i < alto/2; i++) {
            for (int j = 0; j < ancho; j++) {
                if (dunas[i][j] != -1) {
                    double nx = (double) i / alto;
                    double ny = (double) j / ancho;
                    double altura_dunas = nivel_mar + amplitud * Math.sin(frecuencia * nx * alto);
                    if (ny >= altura_dunas) {
                        gc.setFill(Color.rgb(255, 255, 255));
                        gc.fillRect(i * escala, j * escala, escala, escala);
                        dunas[i][j] = 1;
                    }
                }
            }
        }

        amplitud = 0.21;
        frecuencia = 0.0485;
        for (int i = alto/2; i < 326; i++) {
            for (int j = 0; j < ancho; j++) {
                if (dunas[i][j] != -1) {
                    double nx = (double) i / alto;
                    double ny = (double) j / ancho;
                    double altura_dunas = nivel_mar + amplitud * Math.sin(frecuencia * nx * alto);
                    if (ny >= altura_dunas) {
                        gc.setFill(Color.rgb(255, 255, 255));
                        gc.fillRect(i * escala, j * escala, escala, escala);
                        dunas[i][j] = 1;
                    }
                }
            }
        }

        amplitud = 0.1;
        frecuencia = 0.01;
        for (int i = 326; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (dunas[i][j] != -1) {
                    double nx = (double) i / alto;
                    double ny = (double) j / ancho;
                    double altura_dunas = nivel_mar + amplitud * Math.sin(frecuencia * nx * alto);
                    if (ny >= altura_dunas) {
                        gc.setFill(Color.rgb(255, 255, 255));
                        gc.fillRect(i * escala, j * escala, escala, escala);
                        dunas[i][j] = 1;
                    }
                }
            }
        }
        jugador1.creaTanque(gc,matriz,vida);
        jugador2.creaTanque(gc,matriz,vida);
        jugador1.getTanque().modificarCañon(gc,angulo,1);
        jugador2.getTanque().modificarCañon(gc,angulo,2);
    }

    public void terreno_desierto(GraphicsContext gc, Double angulo, int vida) {
        int alto = 400;
        int ancho = 300;
        int escala = this.pixel;
        double nivel_mar = 0.5;//MODIFICACION
        double amplitud = 0.17;
        double frecuencia = 0.0385;
        agregarImagenDeFondo(gc,2);

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (dunas[i][j] != -1) {
                    double nx = (double) i / alto;
                    double ny = (double) j / ancho;
                    double altura_dunas = nivel_mar + amplitud * Math.sin(frecuencia * nx * alto);
                    if (ny >= altura_dunas) {
                        gc.setFill(Color.rgb(128, 64, 0));
                        gc.fillRect(i * escala, j * escala, escala, escala);
                        dunas[i][j] = 1;
                    }
                }
            }
        }


        jugador1.creaTanque(gc,matriz,vida);
        jugador2.creaTanque(gc,matriz,vida);
        jugador1.getTanque().modificarCañon(gc,angulo,1);
        jugador2.getTanque().modificarCañon(gc,angulo,2);
    }

    public void terreno_aram(GraphicsContext gc, Double angulo, int vida) {
        int alto = 400;
        int ancho = 300;
        int escala = this.pixel;
        double nivel_mar = 0.5;//MODIFICACION
        double amplitud = 0.17;
        double frecuencia = 0.03;
        agregarImagenDeFondo(gc,3);


        amplitud = 0.1;
        frecuencia = 0.01;
        for (int i = 0; i < 65; i++) {
            for (int j = 0; j < ancho; j++) {
                if (dunas[i][j] != -1) {
                    double nx = (double) i / alto;
                    double ny = (double) j / ancho;
                    double altura_dunas = nivel_mar + amplitud * Math.sin(frecuencia * nx * alto);
                    if (ny >= altura_dunas) {
                        gc.setFill(Color.rgb(255, 255, 255));
                        gc.fillRect(i * escala, j * escala, escala, escala);
                        dunas[i][j] = 1;
                    }
                }
            }
        }

        amplitud = 0.21;
        frecuencia = 0.045;
        for (int i = 10; i < 330; i++) {
            for (int j = 0; j < ancho; j++) {
                if (dunas[i][j] != -1) {
                    double nx = (double) i / alto;
                    double ny = (double) j / ancho;
                    double altura_dunas = nivel_mar + amplitud * Math.sin(frecuencia * nx * alto);
                    if (ny >= altura_dunas) {
                        gc.setFill(Color.rgb(255, 255, 255));
                        gc.fillRect(i * escala, j * escala, escala, escala);
                        dunas[i][j] = 1;
                    }
                }
            }
        }







        amplitud = 0.1;
        frecuencia = 0.01;
        for (int i = 326; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (dunas[i][j] != -1) {
                    double nx = (double) i / alto;
                    double ny = (double) j / ancho;
                    double altura_dunas = nivel_mar + amplitud * Math.sin(frecuencia * nx * alto);
                    if (ny >= altura_dunas) {
                        gc.setFill(Color.rgb(255, 255, 255));
                        gc.fillRect(i * escala, j * escala, escala, escala);
                        dunas[i][j] = 1;
                    }
                }
            }
        }

        jugador1.creaTanque(gc,matriz,vida);
        jugador2.creaTanque(gc,matriz,vida);
        jugador1.getTanque().modificarCañon(gc,angulo,1);
        jugador2.getTanque().modificarCañon(gc,angulo,2);
    }





    public int colision_terreno(GraphicsContext gc, Bala jugador, int dunas[][], int matriz[][]) {
        int x=jugador.ejeX/pixel;
        int y=jugador.ejeY/pixel;
        if(x>=0 && x<400 && y>=0 && y<300){//MODIFICACION
            if(matriz[x][y]==2){
                System.out.println("Se acabo el juego");
                jugador.marcar();
                return 1;
            }
            if(matriz[x][y]==3){
                System.out.println("Se acabo el juego");
                jugador.marcar();
                return 2;
            }
            else if(dunas[x][y]==1){
                jugador.marcar();
                matriz[x][y]=0;
                int radius = 5; 
                for (int i = x - radius; i <= x + radius; i++) {
                    for (int j = y - radius; j <= y + radius; j++) {
                        if (i >= 0 && i < dunas.length && j >= 0 && j < dunas[i].length) {
                            dunas[i][j] = -1;
                            int x1 = i * pixel;
                            int y1 = j * pixel;
                            gc.clearRect(x1, y1, pixel, pixel);
                        }
                    }
                }
            }
        }
        if(x>399 || x<0 || y>300|| y<0){
            jugador.marcar();
        }
        return 0;
    }
   
}
