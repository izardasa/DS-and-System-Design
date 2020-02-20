
public class ShortestPathDjikstra {

	final int V = 9;

	int minIndex(int[] dist, boolean[] sptSet)
	{
		int min_index = -1;
		int minDistance = Integer.MAX_VALUE;
		
		for(int i=0;i<V;i++)
		{
			if(sptSet[i]==false && dist[i]<=minDistance)
			{
				min_index = i;
				minDistance =dist[i];
			}
		}
		return min_index;
	}
	
	void djikstra(int[][] graph, int source)
	{
		boolean[] sptSet = new boolean[V];
		int[] dist = new int[V];
		
		for(int i=0;i<V;i++)
			dist[i]= Integer.MAX_VALUE;
		
		dist[source]=0;
		for(int count=0;count<V-1;count++)
		{
			int u = minIndex(dist, sptSet);
			sptSet[u]= true;
			
			for(int v=0;v<V;v++)
			{
				if(sptSet[v]!=true && dist[u]!=Integer.MAX_VALUE && graph[u][v]!=0 && dist[v]>dist[u]+graph[u][v])
				{
					dist[v]= dist[u]+graph[u][v];
				}
			}
		}
		
		printDistance(dist);
	}
	private void printDistance(int[] dist) {
		System.out.println("Distance from souce");
		for(int i=0;i<V;i++)
		{
			System.out.println(i+"\t"+dist[i]);
		}
		
	}

	public static void main(String[] args) {
		/* Let us create the example graph discussed above */
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		ShortestPathDjikstra t = new ShortestPathDjikstra();
		t.djikstra(graph, 0);
	}

}
