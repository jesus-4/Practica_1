import dominio.Sexo;
import dominio.Artist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ArtistUnitTest {
    @Test
    public void InstanciaSocio_Assert()throws Exception{
        Artist theArtist = Artist.InstanceOfArtista("Juan", LocalDate.of(2002, 2, 16), Sexo.Femenino);
        Assertions.assertNotNull(theArtist);
    }
}
