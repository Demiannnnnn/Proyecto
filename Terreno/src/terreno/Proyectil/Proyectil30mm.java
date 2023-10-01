package terreno.Proyectil;

import terreno.Bala;

public class Proyectil30mm extends Bala {

    int dano;
    public Proyectil30mm(int x, int y, int radio, double anguloLanzamiento, double velocidadLanzamiento, int contador) {
        super(x, y, radio,anguloLanzamiento, velocidadLanzamiento, contador);
        this.dano = 30;

    }

}
