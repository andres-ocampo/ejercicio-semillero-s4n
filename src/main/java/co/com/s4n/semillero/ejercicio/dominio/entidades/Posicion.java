package co.com.s4n.semillero.ejercicio.dominio.entidades;

import lombok.Getter;

public class Posicion {
    @Getter
    private int x;
    @Getter
    private int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
