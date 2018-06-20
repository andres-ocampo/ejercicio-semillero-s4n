package co.com.s4n.semillero.ejercicio.dominio.entidades;

import co.com.s4n.semillero.ejercicio.dominio.vo.Direccion;
import io.vavr.collection.List;
import lombok.Getter;

public class Dron {

    @Getter
    private int id;
    @Getter
    private int x;
    @Getter
    private int y;
    @Getter
    private Direccion direccion;
    @Getter
    private List<Entrega> entregas;

    public Dron() {
        this.x = 0;
        this.y = 0;
        this.direccion = Direccion.NORTE;
    }

    public Dron(int id, int x, int y, Direccion direccion, List<Entrega> entregas) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.direccion = direccion;
        this.entregas = entregas;
    }

    @Override
    public String toString() {
        return "Dron{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", direccion=" + direccion +
                ", entregas=" + entregas +
                '}';
    }
}
