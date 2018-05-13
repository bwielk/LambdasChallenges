import java.util.function.Function;

public class Challenge1 {

    public static void main(String[] args) {


        //CHALLENGE 1

//        Runnable runnable = new Runnable(){
//            @Override
//            public void run(){
//                String myString = "Let's make an array out of that";
//                String[] parts = myString.split(" ");
//                for(String part : parts){
//                    System.out.println(part);
//                }
//            }
//        };

        Runnable r = () -> {
            System.out.println("/////////////////////////challenge1///////////////////////////////");
            String myString = "Let's make an array out of that";
            String[] parts = myString.split(" ");
            for(String part : parts) {
                System.out.println(part);
            }
        };


        //TESTS
        r.run();
        System.out.println(everySecondChar.apply("ABCDEFGH")); //returns BDFH
        System.out.println(everySecondChar.apply("BlaiseBabey")); //returns lieae
        System.out.println(everySecondChar2.apply("0123456789")); //returns 13579
    }

    //CHALLENGE 2

//    public static String everySecondChar(String s){
//        StringBuilder returnVal = new StringBuilder();
//        for(int i=0; i<s.length(); i++){
//            if(i%2 == 1){
//                returnVal.append(s.charAt(i));
//            }
//        }
//        return returnVal.toString();
//    }

    public static Function<String, String> everySecondChar = s -> {
        System.out.println("/////////////////////////challenge2///////////////////////////////");
        StringBuilder returnVal = new StringBuilder();
        for(int i=0; i<s.length(); i++){
             if(i%2 == 1){
                 returnVal.append(s.charAt(i));
             }
         }
         return returnVal.toString();
    };

    //CHALLENGE 3

    public static Function<String, String> everySecondChar2 = s -> {
        System.out.println("/////////////////////////challenge3///////////////////////////////");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(i%2 == 1){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    };
}

