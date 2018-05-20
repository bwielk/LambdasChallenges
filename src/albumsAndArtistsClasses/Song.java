package albumsAndArtistsClasses;

public class Song {

    private final Artist artist;
    private final String title;
    private final int length;

    public Song(Artist artist, String title, int length){
        this.artist = artist;
        this.title = title;
        this.length = length;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
