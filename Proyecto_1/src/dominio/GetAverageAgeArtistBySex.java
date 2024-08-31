package dominio;

public class GetAverageAgeArtistBySex{
	public static String getAverageAgeArtistBySex(Sexo s, GestorArtista miGestor) {
		if (miGestor.misArtistas.isEmpty()) {
			String aux = "hay artistas "+ s+"s.";
			return "No " + aux.toLowerCase() ;
		}
		if (!miGestor.misArtistas.stream().anyMatch(a->a.getSexo().equals(s))) {
			String aux = "hay artistas "+ s +"s.";
			return "No " + aux.toLowerCase() ;
		}
		String aux = s + "s";
		int tmp = (int) miGestor.misArtistas.stream()
				.filter(a->a.getSexo().equals(s)).mapToDouble(Artista::getEdad)
				.average()
				.orElse(0);
		return "Hay "+miGestor.misArtistas.size()+" artistas "+aux.toLowerCase()+" con un promedio de "+tmp+" años.";
	}
}
