package stackoverflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopologicalSort {

	  static void dfs(List<Integer>[] graph, boolean[] used, List<Integer> res, int u) {
	    used[u] = true;
	    for (int v : graph[u])
	      if (!used[v])
	        dfs(graph, used, res, v);
	    res.add(u);
	  }

	  public static List<Integer> topologicalSort(List<Integer>[] graph) {
	    int n = graph.length;
	    boolean[] used = new boolean[n];
	    List<Integer> res = new ArrayList<>();
	    for (int i = 0; i < n; i++)
	      if (!used[i])
	        dfs(graph, used, res, i);
	    Collections.reverse(res);
	    return res;
	  }

	  // Usage example
	  public static void main(String[] args) {
//	    int n = 3;
		int n = 12;
	    List<Integer>[] g = new List[n];
	    for (int i = 0; i < n; i++) {
	      g[i] = new ArrayList<>();
	    }
//	    g[2].add(0);
//	    g[2].add(1);
//	    g[0].add(1);
	    g[7].add(8);
	    g[7].add(11);
	    g[5].add(11);
	    g[3].add(8);
	    g[3].add(10);
	    g[11].add(2);
	    g[11].add(9);
	    g[11].add(10);
	    g[8].add(9);
	    

	    List<Integer> res = topologicalSort(g);
	    System.out.println(res);
	  }
	}