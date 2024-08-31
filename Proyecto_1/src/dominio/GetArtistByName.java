package dominio;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GetArtistByName{
	public static ArrayList<Artista> getArtistByName(String parteNombre, GestorArtista miGestor){
			return miGestor.misArtistas.stream()
					.filter(s->s.getNombre().contains(parteNombre))
					.sorted((a1, a2)->a1.getNombre().compareTo(a2.getNombre()))
					.collect(Collectors.toCollection(ArrayList<Artista>::new));

	}
}
