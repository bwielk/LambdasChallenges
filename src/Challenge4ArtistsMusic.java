import albumsAndArtistsClasses.*;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Challenge4ArtistsMusic {

    public static void main(String[] args) {
        //SETUP
        //Album
        Album album = new Album("Compilation");
        //Artists
        Artist theBeatles = new Artist("The Beatles", "English", true);
        Artist theBlackKeys = new Artist("The Black Keys", "American", true);
        Artist theSmiths = new Artist("The Smiths", "English", true);
        Artist adele = new Artist("Adele", "English", false);
        Artist coldplay = new Artist("Coldplay", "English", true);
        Artist bjork = new Artist("Bjork", "Icelandic", false);
        Artist anitaBaker = new Artist("Anita Baker", "American", false);
        //Songs
        Song song1 = new Song(theBeatles, "Yesterday");
        Song song2 = new Song(theBlackKeys, "Lonely Boy");
        Song song3 = new Song(theSmiths, "How Soon Is Now");
        Song song4 = new Song(adele, "Rolling In The Deep");
        Song song5 = new Song(coldplay, "In My Place");
        Song song6 = new Song(bjork, "Isobel");
        Song song7 = new Song(anitaBaker, "Sweet Love");
        //Adding Songs to the album
        album.addSong(song1);
        album.addSong(song2);
        album.addSong(song3);
        album.addSong(song4);
        album.addSong(song5);
        album.addSong(song6);
        album.addSong(song7);
        //Listing the contents
        album.getSongs().forEach(song -> System.out.println(song.getArtist().getName() + " -> " + song.getTitle()));
        System.out.println("There are " + album.getSongs().size() + " songs");

        System.out.println("///////////////Get all the artists for an album////////////////////////");
        List<String> allArtists = album.getSongs().stream()
                .map(song -> song.getArtist().getName())
                .collect(toList());
        System.out.println(allArtists + "  class -> " + allArtists.getClass());

        System.out.println("///////////////Figure out which artists are bands////////////////////////");
        List<String> allBands = album.getSongs().stream()
                .filter(song -> song.getArtist().isBand())
                .map(song -> song.getArtist().getName())
                .collect(toList());
        System.out.println(allBands);
        System.out.println("///////////////Find the nationalities of each band////////////////////////");
        Map<String, String> bandsAndNationalities = album.getSongs().stream()
                .filter(song -> song.getArtist().isBand())
                .collect(Collectors.toMap(song -> song.getArtist().getName(), song -> song.getArtist().getNationality()));
        System.out.println(bandsAndNationalities);
        //4. Put together a set of these values.
    }
}
