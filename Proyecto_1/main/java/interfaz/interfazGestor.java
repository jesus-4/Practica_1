package interfaz;
import dominio.Artist;

import java.util.ArrayList;

public interface interfazGestor {
    void AddArtist(Artist artist);
    ArrayList<Artist> GetArtistByName(String name);
    Artist GetArtistAgeLimit();
    ArrayList<Artist> GetArtistOrdered();
    double GetAverageAgeArtistBySex(String sex);
    double GetAverageAgeArtist();
    void ClearArtist();
    int SizeOfArtist();
}

