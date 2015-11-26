package stackoverflow.dependency;

import java.util.ArrayList;
import java.util.List;

public class And {

	public final List<OrNode> elements = new ArrayList<>();
	
	public And(OrNode... elements) {
		for (OrNode e : elements)
			this.elements.add(e);
	}
	
	@Override
	public String toString() {
		return "AND" + elements;
	}
	
}
