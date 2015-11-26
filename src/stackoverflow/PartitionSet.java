package stackoverflow;

import java.util.HashSet;
import java.util.Set;

public class PartitionSet {

	static <T> void partitioning(Set<Set<T>> partition, Set<T> set) {
		L: while (true) {
            for (Set<T> p : partition) {
                for (T e : set) {
                    if (p.contains(e)) {
                        partition.remove(p);
                    	p.addAll(set);
                    	set = p;
                        continue L;
                    }
                }
            }
            partition.add(set);
            return;
		}
	}
	
	public static void main(String[] args) {
		int[][] x = new int[6][6];
		x[1][2] = 0;
        x[1][3] = 0;
        x[1][4] = 1;
        x[1][5] = 1;
        x[2][1] = 0;
        x[2][3] = 0;
        x[2][4] = 1;
        x[2][5] = 1;
        x[3][1] = 0;
        x[3][2] = 0;
        x[3][4] = 1;
        x[3][5] = 1;
        x[4][1] = 1;
        x[4][2] = 1;
        x[4][3] = 1;
        x[4][5] = 0;
        x[5][1] = 1;
        x[5][2] = 1;
        x[5][3] = 1;
        x[5][4] = 1;
        Set<Set<Integer>> partition = new HashSet<>();
        for (int i = 1, is = x.length; i < is; ++i)
            for (int j = 1, js = x[i].length; j < js; ++j)
            	if (x[i][j] == 0) {
            		Set<Integer> set = new HashSet<>();
            		set.add(i);
            		set.add(j);
            		partitioning(partition, set);
            	}
        System.out.println(partition);
        // -> [[1, 2, 3], [4, 5]]
	}
}
