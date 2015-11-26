package stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class Article {

	public String theme;
	public String subject;
	
	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		// ... add articles
		articles.stream()
			.sorted((a, b) -> a.theme.compareTo(b.theme))
			.forEach(article -> { /* output an article */});
		articles.stream()
			.sorted((a, b) -> a.subject.compareTo(b.subject))
			.forEach(article -> { /* output an article */});
			
	}
}
