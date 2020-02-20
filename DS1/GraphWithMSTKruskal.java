import java.util.Arrays;

public class GraphWithMSTKruskal {

	int V;
	int E;
	EDGE1[] edges ;
	Subset[] subsets;
	public GraphWithMSTKruskal(int V, int E)
	{
		this.V = V;
		this.E = E;
		edges = new EDGE1[E];
		
		for(int i=0;i<E;i++)
			edges[i]= new EDGE1();
		subsets = new Subset[V];
		
	}
	
	int find(Subset[] subsets, int x)
	{
		if(subsets[x].parent!=x)
			find(subsets, subsets[x].parent);
		
		return subsets[x].parent;
	}
	
	void union(Subset[] subset, int x, int y)
	{
		x = find(subset, x);
		y= find(subset, y);
		
		if(subset[x].rank<subset[y].rank)
			subset[x].parent = y;
		else if(subset[x].rank>subset[y].rank)
			subset[y].parent = x;
		else
		{
			subset[x].parent = y;
			subset[y].rank++;
		}
	}

	void kruskalMST()
	{
		for(int i=0;i<V;i++)
		{
			subsets[i]= new Subset();
			subsets[i].parent=i;
			subsets[i].rank=0;
		}

		Arrays.sort(edges);
		//Arrays.sort(edges);
		EDGE1[] results = new EDGE1[V-1];
		int e=0;
		int i=0;
		while(e<V-1)
		{
			EDGE1 nextEdge = edges[i++];
			int x = find(subsets, nextEdge.src);
			int y = find(subsets, nextEdge.dest);
			
			if(x!=y)
			{
				results[e++] = nextEdge;
				union(subsets, x, y);
			}
		}
		
		for( i=0;i<V-1;i++)
		{
			System.out.println(results[i].src +" - "+results[i].dest+" + "+results[i].weight);
		}
	}
	boolean isGraphCyclic(){
		
		for(int i=0;i<V;i++)
		{
			subsets[i]= new Subset();
			subsets[i].parent=i;
			subsets[i].rank=0;
		}
		
		for(int i=0;i<E;i++)
		{
			int x = find(subsets,edges[i].src);
			int y= find(subsets,edges[i].dest);
			
			if(x==y)
				return true;
			
			union(subsets, x, y);	
		}
		return false;
	}
	public static void main(String[] args) {
        int V = 5;  // Number of vertices in graph 
        int E = 8;  // Number of edges in graph 
        GraphWithMSTKruskal graph = new GraphWithMSTKruskal(V, E); 
  
        // add edge 0-1 
        graph.edges[0].src = 0; 
        graph.edges[0].dest = 1; 
        graph.edges[0].weight = 2; 
  
        // add edge 0-2 
        graph.edges[1].src = 1; 
        graph.edges[1].dest = 2; 
        graph.edges[1].weight = 7; 
  
        // add edge 0-3 
        graph.edges[2].src = 2; 
        graph.edges[2].dest = 3; 
        graph.edges[2].weight = 8; 
  
        // add edge 1-3 
        graph.edges[3].src = 3; 
        graph.edges[3].dest = 4; 
        graph.edges[3].weight = 5; 
  
        // add edge 2-3 
        graph.edges[4].src = 4; 
        graph.edges[4].dest = 0; 
        graph.edges[4].weight = 1; 
  
        graph.edges[5].src = 0; 
        graph.edges[5].dest = 2; 
        graph.edges[5].weight = 3; 
  
        graph.edges[6].src = 4; 
        graph.edges[6].dest = 2; 
        graph.edges[6].weight = 4; 
  
        graph.edges[7].src = 1; 
        graph.edges[7].dest = 3; 
        graph.edges[7].weight = 6; 
  
        graph.kruskalMST(); 
		
	}

}
class EDGE1 implements Comparable<EDGE1>
{
	int src;
	int dest;
	int weight;
	@Override
	public int compareTo(EDGE1 o) {
		return this.weight-o.weight;
	}
}