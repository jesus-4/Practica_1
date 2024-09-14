package dominio;

public class ClearArtists{
	private ArrayListArtist artists;
	public ClearArtists(){
		artists = new ArrayListArtist();
	}
	public void clearArtist() {
		artists.artistsList.clear();
	}
}
