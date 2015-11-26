package stackoverflow.dependency;

public class Node implements OrNode {

	public final String name;
	public And depends = new And();
	
	Node(String name) {
		this.name = name;
	}
	
	public void depends(OrNode... elements) {
		this.depends = new And(elements);
	}

	@Override
	public String toString() {
		return name;
	}
}
