import albumsAndArtistsClasses.*;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class Challenge4ArtistsMusic {

    public static void main(String[] args) {
        //SETUP
        //Album
        Album album = new Album("Compilation");
        Album album2 = new Album("Compilation2");
        //Artists
        Artist theBeatles = new Artist("The Beatles", "English", true);
        Artist theBlackKeys = new Artist("The Black Keys", "American", true);
        Artist theSmiths = new Artist("The Smiths", "English", true);
        Artist adele = new Artist("Adele", "English", false);
        Artist coldplay = new Artist("Coldplay", "English", true);
        Artist bjork = new Artist("Bjork", "Icelandic", false);
        Artist anitaBaker = new Artist("Anita Baker", "American", false);
        //Songs
        Song song1 = new Song(theBeatles, "Yesterday", 201);
        Song song2 = new Song(theBlackKeys, "Lonely Boy", 190);
        Song song3 = new Song(theSmiths, "How Soon Is Now", 290);
        Song song4 = new Song(adele, "Rolling In The Deep", 274);
        Song song5 = new Song(coldplay, "In My Place", 256);
        Song song6 = new Song(bjork, "Isobel", 281);
        Song song7 = new Song(anitaBaker, "Sweet Love", 233);
        Song song8 = new Song(anitaBaker, "No One In The World", 250);
        Song song9 = new Song(anitaBaker, "Soul of Inspiration", 267);
        Song song10 = new Song(adele, "Someone Like You", 283);
        Song song11 = new Song(bjork, "Venus As a Boy", 276);
        Song song12 = new Song(bjork, "Human Behaviour", 288);
        //Adding Songs to the first album
        album.addSong(song1);
        album.addSong(song2);
        album.addSong(song3);
        album.addSong(song4);
        album.addSong(song5);
        album.addSong(song6);
        album.addSong(song7);
        //Adding Songs to the second album
        album2.addSong(song8);
        album2.addSong(song9);
        album2.addSong(song10);
        album2.addSong(song11);
        album2.addSong(song12);
        //Creating a list of albums
        List<Album> albums = new ArrayList<>();
        albums.add(album);
        albums.add(album2);
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


        System.out.println("///////////////Display all the English bands with 'The' in the beginnings and all their possible details////////////////////////");

        album.getSongs().stream()
                .filter(song -> song.getArtist().isBand())
                .filter(song -> song.getArtist().getName().startsWith("The"))
                .filter(song -> song.getArtist().getNationality().equals("English"))
                .forEach(song -> System.out.println("========>\tName: " + song.getArtist().getName() +
                                                    "\tNationality: " + song.getArtist().getNationality() +
                                                    "\tIs it a band? : " + song.getArtist().isBand() +
                                                    "\tSong Title: " + song.getTitle()));

        System.out.println("///////////////findLongTracks method refactor////////////////////////");
        System.out.println(findLongTracks(albums, 280).toString());
        System.out.println("================>>>REFACTOR<<<================");
        System.out.println(findLongTracks(albums, 285).toString());

    }

    public static Set<String> findLongTracks(List<Album> albums, int searchedLength) {
        Set<String> trackNames = new HashSet<>();
        albums.stream().forEach(album -> {
            album.getSongs().stream().filter(song -> song.getLength()>searchedLength)
                    .map(track -> "''" + track.getTitle() + "'' by " + track.getArtist().getName() +
                            " LENGTH: " + track.getLength())
                    .forEach(song -> trackNames.add(song));
        });
        return trackNames;
    }
}
