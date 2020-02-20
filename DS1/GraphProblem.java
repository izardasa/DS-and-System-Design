import ds.impl.Graph;
import ds.impl.GraphList;

public class GraphProblem {

	public static void main(String[] args) {
		/*
		 * Graph graph = new Graph(); graph.addVertex('A');
		 * graph.addVertex('B'); graph.addVertex('C'); graph.addVertex('D');
		 * graph.addVertex('E'); graph.addVertex('F'); graph.addVertex('G');
		 * graph.addVertex('H');
		 * 
		 * graph.addEdge(0, 1); graph.addEdge(1, 2); graph.addEdge(1, 7);
		 * graph.addEdge(2, 3); graph.addEdge(2, 4); graph.addEdge(4, 5);
		 * graph.addEdge(4, 6); graph.addEdge(0, 1); graph.addEdge(0, 1);
		 * graph.addEdge(0, 1);
		 * 
		 * graph.bfs();
		 */
		GraphList graph = new GraphList(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 6);
		graph.printGraph();
		graph.topologicalSort();

	}

}
