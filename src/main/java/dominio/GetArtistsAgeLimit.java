package dominio;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GetArtistsAgeLimit{
	private ArrayListArtist artists;
	public GetArtistsAgeLimit(){
		artists = new ArrayListArtist();
	}
	public ArrayList<Artist> getArtistas(int edadLimiteSuperior) {
		return artists.artistsList.stream()
				.filter(s->s.getEdad()<= edadLimiteSuperior)
				.sorted((a1, a2)->a1.getNombre().compareTo(a2.getNombre()))
				.collect(Collectors.toCollection(ArrayList<Artist>::new));
	}
}
