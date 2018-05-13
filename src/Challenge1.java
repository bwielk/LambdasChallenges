public class Challenge1 {

    public static void main(String[] args) {

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
            String myString = "Let's make an array out of that";
            String[] parts = myString.split(" ");
            for(String part : parts) {
                System.out.println(part);
            }
        };

        r.run();
    }
}

