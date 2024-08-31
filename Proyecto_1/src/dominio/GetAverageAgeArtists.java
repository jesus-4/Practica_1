package dominio;

public class GetAverageAgeArtists{
	public static String getAverageAgeArtists(GestorArtista miGestor) {
		if (miGestor.misArtistas.isEmpty()) {
			return "No hay artistas.";
		}
		int tmp = (int) miGestor.misArtistas.stream().mapToDouble(Artista::getEdad).average().orElse(0);
		return "Hay "+ miGestor.misArtistas.size() + " artistas con un promedio de "+tmp+" años.";
	}
}
