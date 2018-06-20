package co.com.s4n.semillero.ejercicio.archivos.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Almuerzo;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Entrega;
import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Try;
import io.vavr.control.Validation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServicioManejoArchivo {

    private static Validation<String, String> tryEsExitoso(Try<List<String>> archivo) {
        if(archivo.isFailure()) return Validation.invalid("No se pudo leer el archivo");
        else return Validation.valid("Archivo leído con éxito");
    }

    private static Validation<String, String> tieneTresLineas(Try<List<String>> archivo) {
        if(archivo.getOrElse(List.of()).size() == 3) return Validation.valid("El archivo tiene tres líneas");
        else return Validation.invalid("El archivo no tiene tres líneas");
    }

    public static List<String> leerArchivo(){
        Path path = Paths.get("/home/s4n/fichero.txt");
        Try<List<String>> archivo = Try.of(() -> Files.lines(path).collect(List.collector()));
        Validation<Seq<String>, String> res = validar(archivo);
        return res.isValid() ? archivo.getOrElse(List.of()) : List.of();
    }

    private static Validation<Seq<String>, String> validar(Try<List<String>> archivo) {
        return Validation
                    .combine(tryEsExitoso(archivo),
                            tieneTresLineas(archivo))
                    .ap((x,y)->"");
    }

    public static Entrega getRutaEntrega(int posicion){
        List<String> archivo = leerArchivo();
        Entrega entrega = new Entrega(true,
                new Almuerzo(1,"Arroz Chino"),
                archivo.get(posicion).toCharArray());
        return entrega;
    }
}
