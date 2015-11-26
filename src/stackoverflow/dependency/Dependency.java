package stackoverflow.dependency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dependency {

	public static class Node {
		final String name;
		final List<String> and = new ArrayList<>();
		final List<String> or = new ArrayList<>();

		Node(String name) {
			this.name = name;
		}

		public Node and(String... and) {
			for (String e : and)
				this.and.add(e);
			return this;
		}

		public Node or(String... or) {
			for (String e : or)
				this.or.add(e);
			return this;
		}
		
		@Override
		public String toString() {
			return name + " and" + and + " or" + or;
		}
	}

	final Map<String, Node> map = new HashMap<>();
	
	public Node node(String name) {
		Node node = map.get(name);
		if (node == null)
			map.put(name, node = new Node(name));
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Node e : map.values())
			sb.append(e).append("\n");
		return sb.toString();
	}

	public Node get(String name) {
		return map.get(name);
	}

	static void expand(List<List<String>> targetOr, int index, List<String> set, List<Set<String>> expanded) {
		int size = targetOr.size();
		if (index >= size)
			expanded.add(new HashSet<>(set));
		else
			for (String s : targetOr.get(index)) {
				set.add(s);
				expand(targetOr, index + 1, set, expanded);
				set.remove(set.size() - 1);
			}
	}

	public List<String> dependents(String start) {
		List<String> targetAnd = new ArrayList<>();
		List<List<String>> targetOr = new ArrayList<>();
		List<String> result = new ArrayList<>();
		targetAnd.add(start);
        while (!targetAnd.isEmpty()) {
            System.out.println("target=AND" + targetAnd + " OR" + targetOr + ", result=" + result);
            String single = targetAnd.remove(0);
            Node singleNode = get(single);
            result.add(single);
            for (Iterator<List<String>> i = targetOr.iterator(); i.hasNext(); )
                if (i.next().contains(single))
                    i.remove();
            System.out.println("target=AND" + targetAnd + " OR" + targetOr + ", result=" + result);
            targetAnd.addAll(singleNode.and);
            if (singleNode.or.size() > 0)
                targetOr.add(singleNode.or);
        }
        if (!targetOr.isEmpty()) {
        	List<Set<String>> expanded = new ArrayList<>();
        	expand(targetOr, 0, new ArrayList<>(), expanded);
        	System.out.println("expanded=OR" + expanded);
        	int min = Integer.MAX_VALUE;
        	Set<String> minSet = null;
        	for (Set<String> set : expanded)
        		if (set.size() < min) {
        			min = set.size();
        			minSet = set;
        		}
        	result.addAll(minSet);
        }
		return result;
	}

	public static void main(String[] args) {
		Dependency d = new Dependency();
		d.node("X").and("A").or("E", "C");
		d.node("E").and("B").or("Y", "Z");
		d.node("A").and("E").or("H", "Y");
		d.node("C").or("A", "K");
		d.node("Z");
		d.node("B");
		d.node("H");
		d.node("K");
		System.out.println(d);
		List<String> result = d.dependents("X");
		System.out.println(result);
	}
}
