package dominio;

public class GetAverageAgeArtists{
	private ArrayListArtist artists;
	public GetAverageAgeArtists(){
		artists = new ArrayListArtist();
	}
	public  String getAverageAgeArtists() {
		if (artists.artistsList.isEmpty()) {
			return "No hay artistas.";
		}
		int tmp = (int) artists.artistsList.stream().mapToDouble(Artist::getEdad).average().orElse(0);
		return "Hay "+ artists.artistsList.size() + " artistas con un promedio de "+tmp+" años.";
	}
}
