package stackoverflow;

import java.util.Scanner;

public class ScannerStop {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        while (true){
            System.out.println("Eneter a number to check if it is odd or even, then hit enter: ");
            System.out.println("Type 'STOP' to end the program");
            String token = input.next();
            if (token.equalsIgnoreCase("stop"))
                break;
            try {
                n = Integer.parseInt(token);
                System.out.println(n + " is " + (n % 2 == 0 ? "even" : "odd"));
            } catch (NumberFormatException e) {
            }

//            String strN = String.valueOf(n); //convert integer to string
//            if (new String(strN).equals("STOP")){ //if string is STOP, breaks
//                System.out.println("Thanks for using my program");
//                break;
//            }

//            if (n % 2 == 0){
//                System.out.println(n+" is even");
//                continue;
//            }
//            else{
//                System.out.println(n+" is odd");
//                continue;
//            }
        }
    }
}
