package dominio;

public class AddArtist{
	public static boolean addArtist(Artista a, GestorArtista miGestor){
		if(!miGestor.misArtistas.contains(a)){
			return miGestor.misArtistas.add(a);
		}
		return false;
	}
}
