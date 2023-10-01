
package terreno;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;


public class Jugar extends Application {

    static Random random = new Random();
    private int turno = 1;
    double angulo;
    double velocidad;
    int victoria=0;
    int distancia=0;
    int altura=0;
    int validar=0;
    int vidatanque1=100;
    int vidatanque2=100;
    public Label textodistancia;
    public Label textoaltura;
    public StackPane root = new StackPane();
    public Scene scene = new Scene(root, 1200, 700);
    public Canvas canvas = new Canvas(1200, 900);
    public GraphicsContext gc = canvas.getGraphicsContext2D();

    //ANGULO
    HBox boxangulo = new HBox();
    Text text1 = new Text("Angulo");
    TextField entradaangulo = new TextField();

    //VELOCIDAD
    HBox boxvelocidad = new HBox();
    TextField entradavelocidad = new TextField();

    //JUGADOR
    HBox boxjugador = new HBox();
    Text textjugador=new Text("Turno Actual");

    //TANQUE 1
    HBox boxtanque1 = new HBox();
    Image tanque1 = new Image(getClass().getResourceAsStream("tanque1.png"));
    ImageView imagentanque1 = new ImageView(tanque1);

    //TANQUE 2
    HBox boxtanque2 = new HBox();
    Image tanque2 = new Image(getClass().getResourceAsStream("tanque2.png"));
    ImageView imagentanque2 = new ImageView(tanque2);

    //DISPARO
    HBox boxdisparo= new HBox();
    Button disparar = new Button("!DISPARAR!");

    //DISTANCIA
    HBox boxdistancia=new HBox();
    Text textdistancia= new Text("Distancia = ");

    //ALTURA
    HBox boxaltura=new HBox();
    Text textaltura= new Text("Altura = ");

    //PROYECTILES
    HBox boxProyectil1 = new HBox();
    Image proyectil1 = new Image(getClass().getResourceAsStream("proyectil1.png"));
    ImageView imagen1 = new ImageView(proyectil1);



    //MARCO
    Rectangle marco = new Rectangle(310, 560, 480, 100);

    int alto = 400;
    int ancho=300;
    int pixel = 3;

    Jugador jugador1 = new Jugador(gc, "tanque1.png", 1);
    Jugador jugador2 = new Jugador(gc, "tanque2.png", 2);

    static final int terreno_random;

    static {
        terreno_random = random.nextInt(3);
    }

    Terreno terrain = new Terreno(alto,ancho, pixel,jugador1, jugador2,gc);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        /////////////////////////////////////////////////////  
        


        primaryStage.setScene(scene);
        Pane canvasPane = new Pane();
        canvasPane.setPrefSize(1200, 900);
        root.getChildren().add(canvasPane);
        canvasPane.getChildren().add(canvas);

        
        
        //ANGULO

        boxangulo.setSpacing(10);
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        entradaangulo.setPrefWidth(40);
        boxangulo.getChildren().addAll(text1, entradaangulo);
        boxangulo.setLayoutX(350); 
        boxangulo.setLayoutY(585);
        
        
        //VELOCIDAD

        boxvelocidad.setSpacing(10);
        Text text2 = new Text("Velocidad");
        text2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        entradavelocidad.setPrefWidth(40);
        boxvelocidad.getChildren().addAll(text2, entradavelocidad);
        boxvelocidad.setLayoutX(325); 
        boxvelocidad.setLayoutY(615);
        
               
        //JUGADOR
        boxjugador.getChildren().add(textjugador);
        textjugador.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        boxjugador.setLayoutX(498); 
        boxjugador.setLayoutY(570);


        //TANQUE 1
        imagentanque1.setFitWidth(120);
        imagentanque1.setFitHeight(120);
        boxtanque1.getChildren().add(imagentanque1);
        boxtanque1.setLayoutX(500); 
        boxtanque1.setLayoutY(550);
        
        
        //TANQUE 2
        imagentanque2.setFitWidth(120);
        imagentanque2.setFitHeight(120);
        boxtanque2.getChildren().add(imagentanque2);
        boxtanque2.setLayoutX(500);
        boxtanque2.setLayoutY(550);

        
        //DISPARO
        disparar.setStyle("-fx-font-size: 16px; -fx-font-family: 'Monospaced';");
        boxdisparo.getChildren().add(disparar);
        boxdisparo.setLayoutX(650); 
        boxdisparo.setLayoutY(595);
        
               
        //DISTANCIA   

        boxdistancia.setSpacing(6);
        textodistancia = new Label(distancia + " Metros");
        textdistancia.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        textdistancia.setFill(Color.BLACK);
        textodistancia.setTextFill(Color.RED);
        textodistancia.setFont(Font.font("Arial", 16));
        textdistancia.setTranslateY(-1); 
        boxdistancia.getChildren().addAll(textdistancia,textodistancia);
        boxdistancia.setLayoutY(5);
        
        
        //ALTURA
        boxaltura.setSpacing(6);
        textoaltura = new Label(altura + " Metros");      
        textaltura.setFont(Font.font("Arial", FontWeight.BOLD, 20));       
        textaltura.setFill(Color.BLACK);       
        textoaltura.setTextFill(Color.RED);
        textoaltura.setFont(Font.font("Arial", 16));                
        textaltura.setTranslateY(-1);   
        boxaltura.getChildren().addAll(textaltura,textoaltura);
        boxaltura.setLayoutX(31);
        boxaltura.setLayoutY(30);
        
        
        //MARCO
        marco.setFill(null); // Relleno transparente
        marco.setStroke(Color.SKYBLUE); // Color de la línea del marco
        canvasPane.getChildren().add(marco);

        //PROYECTILES





        
        
        
        //SE AGREGA TODO AL CANVASPANE
        canvasPane.getChildren().addAll(boxangulo,boxvelocidad,boxjugador,boxtanque1,boxtanque2, boxdisparo, boxdistancia, boxaltura, boxProyectil1);
         
        ///////////////////////////////////////


        terrain.iniciar();
        if(terreno_random == 0) {
            terrain.terreno_nieve(gc, 0.0, validar);
        }
        if(terreno_random == 1) {
            terrain.terreno_desierto(gc, 0.0, validar);
        }
        if(terreno_random == 2) {
            terrain.terreno_aram(gc, 0.0, validar);
        }
        primaryStage.show();
        validar=1;

        boxtanque2.setVisible(false);
        boxtanque1.setVisible(true);
        disparar.setOnAction(event ->{         
                disparar.setDisable(true);
                Label distanciaLabel = (Label) boxdistancia.getChildren().get(1);
                distanciaLabel.setText(" ");                               
                Label alturaLabel = (Label) boxaltura.getChildren().get(1);
                alturaLabel.setText(" ");
                String anguloTexto = entradaangulo.getText();
                String velocidadTexto = entradavelocidad.getText();        
                if(anguloTexto.isEmpty() || velocidadTexto.isEmpty() || anguloTexto.equals("0") || velocidadTexto.equals("0")){                
                    disparar.setDisable(false);
                    return;
                }
                angulo = -Double.parseDouble(anguloTexto);
                velocidad = Double.parseDouble(velocidadTexto);
                
                if (turno == 1) {                   
                    double cañonX = jugador1.getTanque().getCañonX();
                    double cañonY = jugador1.getTanque().getCañonY();
                    Bala nuevaBala = new Bala((int) cañonX, (int) cañonY, pixel , angulo, velocidad,0);
                    
                    new AnimationTimer() {
                        double tiempoAnterior = System.nanoTime() / 1e9*5;
                        @Override

                        public void handle(long now){

                            
                            nuevaBala.dibujo(gc);
                            double tiempoActual = System.nanoTime() / 1e9*5;
                            double deltaTiempo = tiempoActual - tiempoAnterior;
                            nuevaBala.actualizarPosicion(deltaTiempo, nuevaBala, distancia, altura,boxdistancia,boxaltura,cañonY,cañonX);
                            tiempoAnterior = tiempoActual;
                            victoria=terrain.colision_terreno(gc, nuevaBala,terrain.dunas, terrain.matriz);
                            if(victoria==1){
                                vidatanque1=jugador1.getTanque().ajustar_vida(50);
                                turno=2;
                                boxtanque1.setVisible(false);
                                boxtanque2.setVisible(true);
                                if(jugador1.getTanque().getVida()<=0){
                                    System.out.println("HA GANADO EL JUGADOR 2!!");
                                    Platform.exit(); 
                                }
                                
                            }
                            else if(victoria==2){
                                vidatanque2=jugador2.getTanque().ajustar_vida(50);
                                turno=1;
                                boxtanque2.setVisible(false);
                                boxtanque1.setVisible(true);
                                if(jugador2.getTanque().getVida()<=0){
                                    System.out.println("HA GANADO EL JUGADOR 1!!");
                                    Platform.exit(); 
                                }
                            }
                            if (nuevaBala.eliminar()) {                               
                                //gc.clearRect(0, 0, 400, 300);
                                if(terreno_random == 0) {
                                    terrain.terreno_nieve(gc, 0.0, vidatanque1);
                                }
                                if(terreno_random == 1) {
                                    terrain.terreno_desierto(gc, 0.0, vidatanque1);
                                }
                                if(terreno_random == 2) {
                                    terrain.terreno_aram(gc, 0.0, vidatanque1);
                                }
                                turno = 2;
                                disparar.setDisable(false);
                                boxtanque1.setVisible(false);
                                boxtanque2.setVisible(true);
                                stop();      
                            }
                        }
                    }.start();
                     
                }               
                else if (turno == 2) {                            
                    double cañonX = jugador2.getTanque().getCañonX();
                    double cañonY = jugador2.getTanque().getCañonY();
                    angulo = 180 - angulo; // Invertir el ángulo                   
                    Bala nuevaBala = new Bala((int) cañonX, (int) cañonY, pixel, angulo, velocidad,0);

                    new AnimationTimer() {

                        double tiempoAnterior = System.nanoTime() / 1e9*5;
                        @Override

                        public void handle(long now){

                            
                            double tiempoActual = System.nanoTime() / 1e9*5;
                            double deltaTiempo = tiempoActual - tiempoAnterior;
                            int contador=0;
                            nuevaBala.actualizarPosicion(deltaTiempo, nuevaBala, distancia, altura,boxdistancia,boxaltura,cañonY,cañonX);
                            tiempoAnterior = tiempoActual;
                            victoria=terrain.colision_terreno(gc, nuevaBala,terrain.dunas, terrain.matriz);
                            nuevaBala.dibujo(gc);

                            if(victoria==1){
                                vidatanque1=jugador1.getTanque().ajustar_vida(50);
                                turno=2;
                                boxtanque1.setVisible(false);
                                boxtanque2.setVisible(true);
                                if(jugador1.getTanque().getVida()<=0){
                                    System.out.println("HA GANADO EL JUGADOR 2!!");
                                    Platform.exit(); 
                                }
                                
                            }
                            else if(victoria==2){
                                vidatanque2=jugador2.getTanque().ajustar_vida(50);
                                turno=1;
                                boxtanque2.setVisible(false);
                                boxtanque1.setVisible(true);
                                if(jugador2.getTanque().getVida()<=0){
                                    System.out.println("HA GANADO EL JUGADOR 1!!");
                                    Platform.exit(); 
                                }
                            }
                            if (nuevaBala.eliminar()) {                               
                                //gc.clearRect(0, 0, 400, 300);
                                if(terreno_random == 0) {
                                    terrain.terreno_nieve(gc, 0.0, vidatanque2);
                                }
                                if(terreno_random == 1) {
                                    terrain.terreno_desierto(gc, 0.0, vidatanque2);
                                }
                                if(terreno_random == 2) {
                                    terrain.terreno_aram(gc, 0.0, vidatanque2);
                                }
                                turno = 1;
                                disparar.setDisable(false);
                                boxtanque2.setVisible(false);
                                boxtanque1.setVisible(true);
                                stop();
                            }
                        }
                    }.start();
                }
                entradaangulo.setText("");
                entradavelocidad.setText("");
            }
        );

    }

    public static int getRandom(){
        return terreno_random;
    }

}
