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

        List<String> namesCapitalized1 = new ArrayList<>();
        names.forEach(name -> {
            name = name.substring(0,1).toUpperCase() + name.substring(1);
            namesCapitalized1.add(name);
            //namesCapitalized.sort((n1, n2)-> n1.compareTo(n2));
            namesCapitalized1.sort(String::compareTo);
        });

        //TESTS
        System.out.println("/////////////////////////challenge6and7///////////////////////////////");
        // returns the full list of sorted capitalizes names
        //namesCapitalized.forEach(n -> System.out.println(n));
        namesCapitalized1.forEach(System.out::println);
        System.out.println("/////////////////////////challenge8///////////////////////////////");
        List<String> namesCapitalized2 = new ArrayList<>();
        names.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted()
                .forEach(System.out::println);
    }

}
