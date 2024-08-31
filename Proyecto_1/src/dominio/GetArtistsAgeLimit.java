package dominio;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GetArtistsAgeLimit{
	public static ArrayList<Artista> getArtistas(int edadLimiteSuperior, GestorArtista miGestor) {
		return miGestor.misArtistas.stream()
				.filter(s->s.getEdad()<= edadLimiteSuperior)
				.sorted((a1, a2)->a1.getNombre().compareTo(a2.getNombre()))
				.collect(Collectors.toCollection(ArrayList<Artista>::new));
	}
}
