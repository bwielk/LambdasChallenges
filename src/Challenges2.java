import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenges2 {

    public static void main(String[] args) {
        //CHALLENGE 6

        List<String> names = Arrays.asList(
            "Amelia",
            "olivia",
            "emily",
            "Isla",
            "Ava",
            "oliver",
            "Jack",
            "Charlie",
            "Jacob"
        );

        List<String> namesCapitalized = new ArrayList<>();
        names.forEach(name -> {
            name = name.substring(0,1).toUpperCase() + name.substring(1);
            namesCapitalized.add(name);
            namesCapitalized.sort((n1, n2)->
                n1.compareTo(n2));
        });

        //TESTS
        System.out.println("/////////////////////////challenge6///////////////////////////////");
        namesCapitalized.forEach(n -> System.out.println(n)); //returns the full list of sorted capitalizes names
    }

}
