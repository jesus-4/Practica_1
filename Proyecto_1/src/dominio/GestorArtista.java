package dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GestorArtista {
	private static GestorArtista ga;
	public static ArrayList<Artista> misArtistas;

	private GestorArtista() {
		misArtistas= new ArrayList<Artista>();
	}

	public static GestorArtista getInstancia() {
		if(ga==null)
			ga=new GestorArtista();
		return ga;
	}
}

