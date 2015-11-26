package stackoverflow.dependency;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Or implements OrNode {

	public final List<Node> elements = new ArrayList<>();
	
	public Or(Node... elements) {
		for (Node e : elements)
			this.elements.add(e);
	}
	
	@Override
	public String toString() {
		return "OR" + elements.stream().map(n -> n.name).collect(Collectors.toList());
	}
}
