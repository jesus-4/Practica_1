package dominio;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GetArtistByName{
	private ArrayListArtist artists;
	public GetArtistByName(){
		artists = new ArrayListArtist();
	}
	public ArrayList<Artist> getArtistByName(String parteNombre){
			return artists.artistsList.stream()
					.filter(s->s.getNombre().contains(parteNombre))
					.sorted((a1, a2)->a1.getNombre().compareTo(a2.getNombre()))
					.collect(Collectors.toCollection(ArrayList<Artist>::new));

	}
}
