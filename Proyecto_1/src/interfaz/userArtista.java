package interfaz;

import dominio.Artista;
import dominio.Sexo;

import java.util.Calendar;

public interface userArtista {
    Artista crearArtist(String nombre, Calendar fechaNacto, Sexo sexo );
}
