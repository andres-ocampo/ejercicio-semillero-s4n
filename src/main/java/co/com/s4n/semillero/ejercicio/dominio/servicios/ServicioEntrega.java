package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.archivos.servicios.ServicioManejoArchivo;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Entrega;
import io.vavr.control.Option;

public class ServicioEntrega {

    public static Option<Dron> realizarEntrega(Dron dron){

        Entrega entrega = ServicioManejoArchivo.getRutaEntrega(0);
        ServicioManejoArchivo.leerArchivo();
        System.out.println(entrega.getRuta());
        Option<Dron> dronOption = Option.of(dron);
        for (int i = 0; i < entrega.getRuta().length; i++)
            if (entrega.getRuta()[i] == 'A') dronOption = ServicioDron.avanzar(dronOption.getOrElse(dron));
            else if (entrega.getRuta()[i] == 'D') dronOption = ServicioDron.girarDerecha(dronOption.getOrElse(dron));
            else dronOption = ServicioDron.girarIzquierda(dronOption.getOrElse(dron));

            return dronOption;
    }

}
