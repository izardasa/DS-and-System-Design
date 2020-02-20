
public class GraphWithCycleUnionByRank {

	int V;
	int E;
	Edge[] edges ;
	Subset[] subsets;
	public GraphWithCycleUnionByRank(int V, int E)
	{
		this.V = V;
		this.E = E;
		edges = new Edge[E];
		
		for(int i=0;i<E;i++)
			edges[i]= new Edge();
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
		GraphWithCycleUnionByRank g = new GraphWithCycleUnionByRank(7, 7);
		g.edges[0].src =0;
		g.edges[0].dest =1;
		g.edges[1].src =0;
		g.edges[1].dest =2;
		g.edges[2].src =0;
		g.edges[2].dest =3;
		g.edges[3].src =0;
		g.edges[3].dest =4;
		g.edges[4].src =3;
		g.edges[4].dest =5;
		g.edges[5].src =4;
		g.edges[5].dest =6;
		g.edges[6].src =6;
		g.edges[6].dest =2;
		System.out.println(g.isGraphCyclic());
		
	}

}
class Subset
{
	int parent;
	int rank;
}