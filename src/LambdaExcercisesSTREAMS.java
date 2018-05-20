import albumsAndArtistsClasses.Album;
import albumsAndArtistsClasses.Artist;
import albumsAndArtistsClasses.Song;

import java.util.*;
import java.util.stream.*;

public class LambdaExcercisesSTREAMS {

    //The following tasks come from the "Java 8 Lambdas book" by Richard Warburton

    public static void main(String[] args) {
        System.out.println("//////////////////////////////////////////////////TASK1//////////////////////////////////////////////////");
        System.out.println("EXERCISE 1 => \n" + addUp(Stream.of(12,14,16,100)));//should return 142
        System.out.println("EXERCISE 1 => \n" + addUp(Stream.of(100,240,160,200)));//should return 700

        Album album1 = new Album("Pop Compilation");
        Album album2 = new Album("Rock Compilation");

        Artist theBeatles = new Artist("The Beatles", "English", true);
        Artist theBlackKeys = new Artist("The Black Keys", "American", true);
        Artist theSmiths = new Artist("The Smiths", "English", true);
        Artist adele = new Artist("Adele", "English", false);

        Song song1 = new Song(theBeatles, "Yesterday", 201);
        Song song2 = new Song(theBeatles, "Hey Jude", 211);
        Song song3 = new Song(theBlackKeys, "Lonely Boy", 190);
        Song song4 = new Song(theBlackKeys, "Howling for you", 210);
        Song song5 = new Song(theSmiths, "How Soon Is Now", 290);
        Song song6 = new Song(theSmiths, "Bigmouth Strikes Again", 320);
        Song song7 = new Song(adele, "Rolling In The Deep", 274);
        Song song8 = new Song(adele, "Hello", 287);

        album1.addSong(song5);
        album1.addSong(song6);
        album1.addSong(song7);
        //album1.addSong(song8);
        album2.addSong(song1);
        album2.addSong(song2);
        album2.addSong(song3);
        album2.addSong(song4);

        System.out.println("EXERCISE 2 => \n" + getArtistNamesAndOrigins(Stream.of(adele, theBeatles, theSmiths)).toString());
        System.out.println("EXERCISE 2 => \n" + getArtistNamesAndOrigins(Stream.of(theSmiths, theBlackKeys)).toString());

        System.out.println("EXERCISE 3 =>");
        getAlbumsWith3TracksAtMost(Stream.of(album1, album2)).forEach(album -> System.out.println(album.getTitle()));//Should return the Pop Compilation

        System.out.println("//////////////////////////////////////////////////TASK2//////////////////////////////////////////////////");
        System.out.println(numberOfSongsInAlbums(Stream.of(album1, album2)));//should return 7

        System.out.println("//////////////////////////////////////////////////TASK6//////////////////////////////////////////////////");
        System.out.println(numOfLowerCaseChars("AngoLA"));//should return 3
        System.out.println(numOfLowerCaseChars("ToBE or Not TO Beee1"));//should return 8
        System.out.println(numOfLowerCaseChars("CrepuscuLAR SOLIdao"));//should return 10
    }

    ///////////////////////////////////////////////////TASK1//////////////////////////////////////////////////

    //Implement:
    //a. A function that adds up numbers
    private static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0, (acc, el) -> acc + el);
    }
    //b. A function that takes in artists and returns a list of strings with their names and places of origins
    private static List<String> getArtistNamesAndOrigins(Stream<Artist> artists){
        return artists
                .map(artist -> artist.getName() + " NATIONALITY: " +  artist.getNationality())
                .collect(Collectors.toList());
    }
    //c. A function that takes in albums and returns a list of albums with at most three tracks
    private static List<Album> getAlbumsWith3TracksAtMost(Stream<Album> albums){
        return albums
                .filter(album -> album.getSongs().size()<=3)
                .collect(Collectors.toList());
    }

    ///////////////////////////////////////////////////TASK2//////////////////////////////////////////////////
    //Iteration. Convert this code sample from using external iteration to internal iteration:

    //    int totalMembers = 0;
    //    for (Artist artist : artists) {
    //            Stream<Artist> members = artist.getMembers();
    //            totalMembers += members.count();
    //    }

    public static int numberOfSongsInAlbums(Stream<Album> albums){
        return (int) StreamSupport
                .stream(albums.flatMap(album -> album.getSongs().stream()).spliterator(), true).count();
    }

    ///////////////////////////////////////////////////TASK6//////////////////////////////////////////////////
    //Count the number of lowercase letters in a String

    public static int numOfLowerCaseChars(String word){
        return (int) word.chars().filter(c -> Character.isLowerCase(c)).count();
    }

}
