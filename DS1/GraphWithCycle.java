
public class GraphWithCycle {

	public static void main(String[] args) {
	Graph g = new Graph(4,4);
		g.edge[0].src = 0;
		g.edge[0].dest = 1;
		
		g.edge[1].src = 1;
		g.edge[1].dest = 2;
		
		g.edge[2].src = 2;
		g.edge[2].dest = 3;
		
		g.edge[3].src = 3;
		g.edge[3].dest = 0;
		
		System.out.println(g.isGraphCyclic());

	}

}

class Graph {
	int E;
	int V;
	Edge[] edge;

	public Graph(int V, int E) {
		edge = new Edge[E];
		this.V = V;
		this.E = E;

		for (int i = 0; i < E; i++) {
			edge[i] = new Edge();
		}
	}

	public int find(int[] parent, int v) {
		if (parent[v] == -1)
			return v;

		return find(parent, parent[v]);
	}

	public void union(int[] parent, int v1, int v2) {
		int xSet = find(parent, v1);
		int ySet = find(parent, v2);
		parent[xSet] = ySet;

	}

	public boolean isGraphCyclic() {
		int[] parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < E; i++) {
			int x = find(parent, edge[i].src);
			int y = find(parent, edge[i].dest);

			if (x == y)
				return true;

			union(parent, x, y);

		}
		
		return false;
	}

}

class Edge {
	int src;
	int dest;
}
