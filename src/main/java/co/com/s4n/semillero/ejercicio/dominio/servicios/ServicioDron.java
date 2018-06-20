package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.archivos.servicios.ServicioManejoArchivo;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Almuerzo;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Entrega;
import co.com.s4n.semillero.ejercicio.dominio.vo.Direccion;
import io.vavr.collection.List;
import io.vavr.control.Option;

public class ServicioDron {

    static public Option<Dron> avanzar(Dron dron){
        int x = dron.getX();
        int y = dron.getY();
        switch (dron.getDireccion()) {
            case NORTE:
                y += 1;
                break;
            case ESTE:
                x += 1;
                break;
            case SUR:
                y -= 1;
                break;
            case OESTE:
                x -= 1;
                break;
            default:
                return null;
        }
        return Option.of(new Dron(dron.getId(),x,y,dron.getDireccion(),dron.getEntregas()));
    }

    static public Option<Dron> girarDerecha(Dron dron){
        Direccion d = dron.getDireccion();
        switch (dron.getDireccion()){
            case NORTE:
                d = Direccion.ESTE;
                break;
            case ESTE:
                d = Direccion.SUR;
                break;
            case SUR:
                d = Direccion.OESTE;
                break;
            case OESTE:
                d = Direccion.NORTE;
                break;
            default:
                break;
        }
        return Option.of(new Dron(dron.getId(),dron.getX(),dron.getY(),d,dron.getEntregas()));
    }

    static public Option<Dron> girarIzquierda(Dron dron){
        Direccion d = dron.getDireccion();
        switch (dron.getDireccion()){
            case NORTE:
                d = Direccion.OESTE;
                break;
            case ESTE:
                d = Direccion.NORTE;
                break;
            case SUR:
                d = Direccion.ESTE;
                break;
            case OESTE:
                d = Direccion.SUR;
                break;
            default:
                break;
        }
        return Option.of(new Dron(dron.getId(),dron.getX(),dron.getY(),d,dron.getEntregas()));
    }

}
