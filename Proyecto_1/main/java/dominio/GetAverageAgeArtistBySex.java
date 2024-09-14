package dominio;

public class GetAverageAgeArtistBySex{
	private ArrayListArtist artists;
	public GetAverageAgeArtistBySex(){
		artists = new ArrayListArtist();
	}
	public String getAverageAgeArtistBySex(Sexo s, GestorArtista miGestor) {
		if (artists.artistsList.isEmpty()) {
			String aux = "hay artistas "+ s+"s.";
			return "No " + aux.toLowerCase() ;
		}
		if (!artists.artistsList.stream().anyMatch(a->a.getSexo().equals(s))) {
			String aux = "hay artistas "+ s +"s.";
			return "No " + aux.toLowerCase() ;
		}
		String aux = s + "s";
		int tmp = (int) artists.artistsList.stream()
				.filter(a->a.getSexo().equals(s)).mapToDouble(Artist::getEdad)
				.average()
				.orElse(0);
		return "Hay "+artists.artistsList.size()+" artistas "+aux.toLowerCase()+" con un promedio de "+tmp+" años.";
	}
}
