import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Challenges2 {

    public static void main(String[] args) {

        Function<String, String> capitalize = (s) -> {
            return s.substring(0,1).toUpperCase() + s.substring(1);
        };

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
            capitalize.apply(name);
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
        // returns the full list of sorted capitalizes names
        List<String> namesCapitalized2 = new ArrayList<>();
        names.stream()
                .map(name -> capitalize.apply(name))
                .sorted()
                .forEach(System.out::println);

        System.out.println("/////////////////////////challenge9///////////////////////////////");
        // returns number of names starting with "A"
        long namesStartingWithA = names.stream()
                .map(name -> capitalize.apply(name))
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println(namesStartingWithA);

        System.out.println("/////////////////////////challenge10///////////////////////////////");
        names.stream()
                .map(name -> capitalize.apply(name))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }
}
