package stackoverflow;

public class Split {

	public static void main(String[] args) {
		String value = "carriage\n return\r\n in\n a\r\n string\n" ;

				for(String line : value.split("\n")) {
				    if(line.contains("\r")) {
				       System.out.println("Carriage return found in " + line.trim());
				    }
				}
	}
}
