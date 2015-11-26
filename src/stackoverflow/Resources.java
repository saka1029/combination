package stackoverflow;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resources {

	public static void main(String[] args) {
		 ResourceBundle resourceBundle =
			      ResourceBundle.getBundle("MyResources");
		 System.out.println(resourceBundle.getString("a"));
		 System.out.println("*" + resourceBundle.getString("listing") + "*");

		 String s = "// the \"then\" clause: decrease";

         System.out.println(s.matches(resourceBundle.getString("listing")));
         System.out.println(s.matches(resourceBundle.getString("listing2")));
	}
}
