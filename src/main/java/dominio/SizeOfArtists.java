package dominio;

public class SizeOfArtists{
	private ArrayListArtist artists;
	public SizeOfArtists(){
		artists = new ArrayListArtist();
	}
	public int sizeOfArtists(GestorArtist miGestor) {
		return artists.artistsList.size();
	}
}
