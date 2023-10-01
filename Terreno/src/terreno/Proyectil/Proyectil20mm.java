package terreno.Proyectil;

import terreno.Bala;

public class Proyectil20mm extends Bala {
    int dano;
    public Proyectil20mm(int x, int y, int radio, double anguloLanzamiento, double velocidadLanzamiento, int contador) {
        super(x, y, radio,anguloLanzamiento, velocidadLanzamiento, contador);
        this.dano = 20;
    }
}
