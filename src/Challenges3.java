import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Challenges3 {

    public static void main(String[] args) {

        List<String> months = Arrays.asList(
                "January",
                "February",
                "March",
                "april",
                "may",
                "june",
                "july",
                "August",
                "September",
                "october",
                "november",
                "december"
        );

        System.out.println("////////////////////////SORTING BY LENGTH FROM HIGHEST TO LOWEST//////////////////////////");
        months.sort(
                Comparator.comparing((String month) -> month.length()).reversed());
        printList(months);
        System.out.println("////////////////////////SORTING BY FIRST CHAR//////////////////////////");
        months.sort(
                Comparator.comparing((String month) -> month.toUpperCase()));
        printList(months);
        System.out.println("////////////////////////MONTHS WITH J FIRST//////////////////////////");
        String character = "M";
        months.sort(
                Comparator.comparing((String month) -> month.toUpperCase().startsWith(character)).reversed());
        printList(months);

        System.out.println("///////////////////////THE USE OF THE REDUCE METHOD//////////////////////////");
        List<Double> doubles = new ArrayList<>();
        doubles.add(0.1);
        doubles.add(0.4);
        doubles.add(0.5);
        doubles.add(1.2);

        int sum = Stream.of(10, 20, 30)
            .reduce(1, (accumulator, element) -> accumulator + element);
        System.out.println(sum);
        String conjoinedString = Stream.of("ABCD", "EFG", "HIJ", "KLMNO")
                .reduce("", (acc, el) -> acc + el);
        System.out.println(conjoinedString);
        String firstAndSecondDigits = Stream.of("9812344", "76342212", "54223452", "3210002", "10993")
                .reduce("", (acc, el) -> acc + el.substring(0,2));
        System.out.println(firstAndSecondDigits);

        double doublesSum = doubles.stream()
                .reduce(0.0, (acc, el) -> acc + (el-0.1));
        BigDecimal result = new BigDecimal("" + doublesSum + "");
        System.out.println(String.format("%.1f", result));

        System.out.println("///////////////////////THE USE OF THE MAP METHOD//////////////////////////");
        List<String> names = new ArrayList<>();
        names.add("EVE");
        names.add("ALICIA");
        names.add("JASON");
        names.add("EVELINE");
        names.add("ALABAMA");
        names.add("ANTON");
        List<String> changedNames = names.stream()
                .map(name -> name.concat("OOOHHH"))
                .collect(Collectors.toList());
        System.out.println(names.toString());
        System.out.println(changedNames.toString());

        List<String> namesStartingWithE = names.stream()
                .filter(name -> name.startsWith("A"))
                .sorted(Comparator.comparing(s -> s.length()))
                .collect(Collectors.toList());
        System.out.println(namesStartingWithE.toString());
    }

    private static void printList(List<String> months){
        for(String m : months){
            System.out.println(m + " ==> " + m.length());
        }
    }


}
