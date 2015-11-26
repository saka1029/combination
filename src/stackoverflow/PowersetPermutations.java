package stackoverflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowersetPermutations {

	static void add(List<List<String>> result, List<List<String>> sub, int[] sel) {
		int subsize = sel.length;
        System.out.println("sel=" + Arrays.toString(sel));
        List<String> group = new ArrayList<>();
        for (int j = 0; j < subsize; ++j)
            group.add(sub.get(j).get(sel[j]));
        result.add(group);
	}

	static void generatePermutations(List<List<String>> groups, List<List<String>> result, boolean[] selection) {
		int size = selection.length;
		List<List<String>> sub = new ArrayList<>();
		for (int i = 0; i < size; ++i)
			if (selection[i])
				sub.add(groups.get(i));
        System.out.println("sub=" + sub);
        int subsize = sub.size();
		int[] sel = new int[subsize];
        add(result, sub, sel);
		L: while (true) {
			for (int i = 0; i < subsize; ++i) {
				if (sel[i] >= sub.get(i).size() - 1)
					sel[i] = 0;
				else {
					++sel[i];
					add(result, sub, sel);
					continue L;
				}
			}
			break;
		}
	}

	static List<List<String>> generatePermutations(List<List<String>> groups) {
		int size = groups.size();
		List<List<String>> result = new ArrayList<>();
		boolean[] selection = new boolean[size];
		L: while (true) {
            for (int i = 0; i < size; ++i) {
                if (selection[i])
                    selection[i] = false;
                else {
                    selection[i] = true;
                    generatePermutations(groups, result, selection);
                    continue L;
                }
            }
            break;
		}
		return result;
	}

	public static void main(String[] args) {
        List<String> g1 = new ArrayList<String>();
        g1.add("a");
        g1.add("b");
        List<String> g2 = new ArrayList<String>();
        g2.add("c");
        g2.add("d");
        g2.add("e");
        List<String> g3 = new ArrayList<String>();
        g3.add("f");
        g3.add("g");
        List<List<String>> groups = new ArrayList<List<String>>();
        groups.add(g1);
        groups.add(g2);
        groups.add(g3);

        List<List<String>> perms = generatePermutations(groups);
        System.out.println(perms);

	}
}
