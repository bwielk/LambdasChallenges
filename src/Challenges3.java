import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

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
        months.sort(
                Comparator.comparing((String month) -> month.toUpperCase().startsWith("J")).reversed());
        printList(months);
    }

    private static void printList(List<String> months){
        for(String m : months){
            System.out.println(m + " ==> " + m.length());
        }
    }
}
