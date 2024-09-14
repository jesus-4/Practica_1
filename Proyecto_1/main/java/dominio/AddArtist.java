package dominio;

public class AddArtist{
	private ArrayListArtist artist;

	public AddArtist(){
		artist = new ArrayListArtist();
	}
	public boolean addArtist(Artist a){
        if (!artist.artistsList.contains(a)) {
            return false;
        }
        return artist.artistsList.add(a);
    }
}
