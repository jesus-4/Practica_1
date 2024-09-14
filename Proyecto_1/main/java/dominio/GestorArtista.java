package dominio;
import interfaz.interfazGestor;

import java.util.ArrayList;

abstract class GestorArtista implements interfazGestor {
	private ArrayList<Artist> artists;
    private AddArtist addArtist;
	private ClearArtists clearArtists;
	private GetArtistByName getArtistByName;
	private GetAverageAgeArtistBySex getAverageAgeArtistBySex;
	private GetArtistsAgeLimit getArtistsAgeLimit;
	private GetArtistsOrdered artistsOrdered;
	private GetAverageAgeArtists getAverageAgeArtists;
	private Artist artist;


//	private GestorArtista() {
//		misArtistas= new ArrayList<Artist>();
//	}
//
//	public static GestorArtista getInstancia() {
//		if(ga==null)
//			ga=new GestorArtista();
//		return ga;
//	}
}

