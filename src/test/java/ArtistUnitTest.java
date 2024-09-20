import dominio.GestorArtist;
import dominio.Sexo;
import dominio.Artist;
import exceptions.ExceptionArtist;
import interfaz.interfazGestor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;

public class ArtistUnitTest implements interfazGestor {
    @Test
    public void InstanciaSocio_AssertNotNull()throws Exception{
        Artist theArtist = Artist.InstanceOfArtista("Juan", LocalDate.of(2002, 2, 16), Sexo.Femenino);
        Assertions.assertNotNull(theArtist);
    }
    @Test
    public void InstanciaSocio_AssertNull() throws Exception{
        Artist theArtist = null;
        Assertions.assertNull(theArtist);
    }
    @Test
    public void TestArtista() throws ExceptionArtist {
			LocalDate f = LocalDate.of(1943, 12, 23);
			Artist a = Artist.InstanceOfArtista (" julio    iglesias",f,Sexo.Masculino);

			Assertions.assertEquals(80, a.getEdad());
			Assertions.assertEquals ("El Artista: Julio Iglesias (23/12/43)", a.toString());
    }

    @Test
    public void TestCargaArtist()throws ExceptionArtist{
        LocalDate f = LocalDate.of(1943, 12, 23);
        Artist a = Artist.InstanceOfArtista (" julio    iglesias",f,Sexo.Masculino);
        LocalDate f2 = LocalDate.of(1943, 12, 23);
        Artist a2 = Artist.InstanceOfArtista ("   Celine   m.    C.  DION    ",f2,Sexo.Femenino);
        LocalDate f3 = LocalDate.of(1943, 12, 23);
        Artist a3 = Artist.InstanceOfArtista ("Madonna l. v. Ciccone",f3,Sexo.Femenino);

        GestorArtist ga;

    }
}
