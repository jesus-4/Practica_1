package dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GetArtistsOrdered{
	public static ArrayList<Artista> getArtistsOrdered(GestorArtista miGestor) {
		Comparator<Artista> c = new Comparator<Artista>() {
			@Override
			public int compare(Artista a1, Artista a2) {
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
		return miGestor.misArtistas.stream()
				.sorted(c)
				.collect(Collectors.toCollection(ArrayList<Artista>::new));
	}
}
