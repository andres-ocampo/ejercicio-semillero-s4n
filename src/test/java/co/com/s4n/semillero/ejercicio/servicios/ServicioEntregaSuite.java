package co.com.s4n.semillero.ejercicio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;
import co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioEntrega;
import co.com.s4n.semillero.ejercicio.dominio.vo.Direccion;
import io.vavr.collection.List;
import io.vavr.control.Option;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServicioEntregaSuite {

    @Test
    public void testRealizarEntrega(){
        Dron dron = new Dron(1,new Posicion(0,0),Direccion.NORTE,List.empty());
        Option<Dron> dronOption = ServicioEntrega.realizarEntrega(dron);
        assertEquals(dronOption.getOrElse(dron).getDireccion(),Direccion.NORTE);
        assertEquals(dronOption.getOrElse(dron).getPosicion().getX(),-2);
        assertEquals(dronOption.getOrElse(dron).getPosicion().getY(),4);
    }
}
