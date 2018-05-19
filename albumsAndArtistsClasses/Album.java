public class Album {

    private final String title;
    private List<Song> songs;

    public Album(String title){
        this.title = title;
        this.songs = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public boolean addSong(Song song){
        if(song != null){
            songs.add(song);
            return true;
        }
        return false;
    }
}
