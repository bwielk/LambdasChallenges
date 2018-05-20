import albumsAndArtistsClasses.Album;
import albumsAndArtistsClasses.Artist;
import albumsAndArtistsClasses.Song;
import java.util.stream.Stream;

public class LambdaExcercises1 {

    //The following tasks come from the "Java 8 Lambdas book" by Richard Warburton

    public static void main(String[] args) {
        System.out.println("EXERCISE 1 => \n" + addUp(Stream.of(12,14,16,100)));

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
        album1.addSong(song8);
        album2.addSong(song1);
        album2.addSong(song2);
        album2.addSong(song3);
        album2.addSong(song4);
    }

    ///////////////////////////////////////////////////TASK1//////////////////////////////////////////////////

    //Implement:
    //a. A function that adds up numbers
    private static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0, (acc, el) -> acc + el);
    }
    //b. A function that takes in artists and returns a list of strings with their names and places of origins

    //c. A function that takes in albums and returns a list of albums with at most three tracks

}
