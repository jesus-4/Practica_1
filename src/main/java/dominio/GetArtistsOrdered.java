package dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GetArtistsOrdered{
	private ArrayListArtist artists;
	public GetArtistsOrdered(){
		artists = new ArrayListArtist();
	}
	public ArrayList<Artist> getArtistsOrdered() {
		Comparator<Artist> c = new Comparator<Artist>() {
			@Override
			public int compare(Artist a1, Artist a2) {
				int tmp = a2.getSexo().compareTo(a1.getSexo());
				if (tmp!= 0) {
					return tmp;
				}
				tmp = Integer.compare(a1.getEdad(), a2.getEdad());
				if (tmp!= 0) {
					return tmp;
				}
				return a2.getNombre().compareTo(a1.getNombre());

			}};
		return artists.artistsList.stream()
				.sorted(c)
				.collect(Collectors.toCollection(ArrayList<Artist>::new));
	}
}
