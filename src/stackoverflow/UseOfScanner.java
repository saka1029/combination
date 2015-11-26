package stackoverflow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UseOfScanner {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){
		scan();
//	    System.out.print("Enter an integer: ");
//	    int a = getInt();
//	    System.out.print("Enter a second integer: ");
//	    int b = getInt();
//	    int result = a + b;
//	    System.out.println(result);
	}

	public static void scan() {
		StringBuilder builder = new StringBuilder();
		File file = new File("UseOfScanner.txt");
		try (Scanner scanner = new Scanner(file)) {
		    while (scanner.hasNextLine() ) {
		        builder.append(scanner.nextLine()).append("\n");
		    }
		} catch (FileNotFoundException ex) {
		    System.out.println("Error");
		}
		System.out.println(builder.toString());
	}

	public static int getInt(){
	    while (true){
	        try {
	            return sc.nextInt();
	        }
	        catch(InputMismatchException e){
	            System.out.print("I'm sorry, that's not an integer."
	                    + " Please try again: ");
	            sc.next();
	        }
	    }
	}
}
