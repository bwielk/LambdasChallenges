public class Song {

    private final Artist artist;
    private final String title;

    public Song(Artist artist, String title){
        this.artist = artist;
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }
}
