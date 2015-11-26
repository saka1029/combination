package stackoverflow;

import java.util.Comparator;

public class LambdaCode {

	public static void main(String[] args) {
        Comparator<String> x = String::compareTo;
        Comparator<String> y = (a,b) -> a.compareTo(b);
	}
}
