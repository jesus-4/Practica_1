package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GestorArtista {

	private static GestorArtista ga;
	private ArrayList<Artista> misArtistas;

	private GestorArtista() {
		misArtistas= new ArrayList<Artista>();
	}

	public static GestorArtista getInstancia() {
		if(ga==null)
			ga=new GestorArtista();
		return ga;
	}

	public boolean addArtista(Artista a) {
		if(!misArtistas.contains(a)){
			return misArtistas.add(a);
		}
		return false;
	}

	public int cantidadDeArtistas() {
		return misArtistas.size();
	}

	public void blanquearArtistas() {
		misArtistas.clear();
	}

	public ArrayList<Artista> getArtistas(String parteNombre) {
		ArrayList<Artista> tmp= new ArrayList<Artista>();
		for (Artista artista : misArtistas) {
			if (artista.getNombre().contains(parteNombre)) {
				tmp.add(artista);
			}
		}
		return tmp;
	}

	public ArrayList<Artista> getArtistasImplementarConLambda(String parteNombre) {
		return misArtistas.stream()
				.filter(s->s.getNombre().contains(parteNombre))
				.sorted((a1, a2)->a1.getNombre().compareTo(a2.getNombre()))
				.collect(Collectors.toCollection(ArrayList<Artista>::new));
	}

	public ArrayList<Artista> getArtistasImplementarConLambda(int edadLimiteSuperior) {
		return misArtistas.stream()
				.filter(s->s.getEdad()<= edadLimiteSuperior)
				.sorted((a1, a2)->a1.getNombre().compareTo(a2.getNombre()))
				.collect(Collectors.toCollection(ArrayList<Artista>::new));
	}

	public ArrayList<Artista> getArtistas(int edadLimiteSuperior) {
		ArrayList<Artista> tmp= new ArrayList<Artista>();
		for (Artista artista : misArtistas) {
			if (artista.getEdad() < edadLimiteSuperior) {
				tmp.add(artista);
			}
		}
		return tmp;
	}

	public ArrayList<Artista> getArtistas() {
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
		return misArtistas.stream()
				.sorted(c)
				.collect(Collectors.toCollection(ArrayList<Artista>::new));
	}

	public String getPromedioEdadArtistas(){
		if (misArtistas.size()==0) {
			return "No hay artistas.";
		}
		int tmp = (int) misArtistas.stream().mapToDouble(s->s.getEdad()).average().orElse(0);
		return "Hay "+misArtistas.size()+" artistas con un promedio de "+tmp+" años.";
	}

	public String getPromedioEdadArtistas(Sexo s){
		if (misArtistas.size()==0) {
			String aux = "hay artistas "+ s+"s.";
			return "No " + aux.toLowerCase() ;
		}
		if (!misArtistas.stream().anyMatch(a->a.getSexo().equals(s))) {
			String aux = "hay artistas "+ s+"s.";
			return "No " + aux.toLowerCase() ;
		}
		String aux = s + "s";
		int tmp = (int) misArtistas.stream().filter(a->a.getSexo().equals(s)).mapToDouble(a->a.getEdad()).average().orElse(0);
		return "Hay "+misArtistas.size()+" artistas "+aux.toLowerCase()+" con un promedio de "+tmp+" años.";
	}

}

