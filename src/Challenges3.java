import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
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
        int sum = Stream.of(10, 20, 30)
            .reduce(1, (accumulator, element) -> accumulator + element);
        System.out.println(sum);
        String conjoinedString = Stream.of("ABCD", "EFG", "HIJ", "KLMNO")
                .reduce("", (acc, el) -> acc + el);
        System.out.println(conjoinedString);
        String firstAndSecondDigits = Stream.of("9812344", "76342212", "54223452", "3210002", "10993")
                .reduce("", (acc, el) -> acc + el.substring(0,2));
        System.out.println(firstAndSecondDigits);
    }

    private static void printList(List<String> months){
        for(String m : months){
            System.out.println(m + " ==> " + m.length());
        }
    }


}
