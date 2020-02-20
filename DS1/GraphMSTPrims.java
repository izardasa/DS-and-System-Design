
public class GraphMSTPrims
{

    int V;

    public GraphMSTPrims( int V )
    {
        this.V = V;
    }

    int minIndex( int[] keys, boolean[] sptSet )
    {
        int min_key = Integer.MAX_VALUE;
        int min_index = -1;
        for( int i = 0; i < V; i++ )
        {
            if( sptSet[i] == false && keys[i] < min_key )
            {
                min_key = keys[i];
                min_index = i;
            }
        }
        return min_index;
    }

    void prims( int[][] graph )
    {
        boolean[] sptSet = new boolean[ V ];
        int[] parent = new int[ V ];
        int[] keys = new int[ V ];
        for( int i = 0; i < V; i++ )
        {
            keys[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        parent[0] = -1;
        keys[0] = 0;

        for( int count = 0; count < V - 1; count++ )
        {
            int u = minIndex( parent, sptSet );
            sptSet[u] = true;

            for( int v = 0; v < V; v++ )
            {
                if( sptSet[v] != true && graph[u][v] != 0 && keys[v] > graph[u][v] )
                {
                    keys[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printMST( parent, keys, graph );
    }

    private void printMST( int[] parent, int[] keys, int[][] graph )
    {
        System.out.println( "Distance from souce" );
        for( int i = 1; i < V; i++ )
        {
            System.out.println( parent[i] + " - " + i + " - " + graph[i][parent[i]] );
        }

    }

    public void floydWarshal(int[][] graph)
    {
        for(int k=0;k<V;k++)
        {
            for(int i=0;i<V;i++)
            {
                for(int j=0;j<V;j++)
                {
                    graph[i][j]=Math.min( graph[i][j], graph[i][k]+graph[k][j] );
                }
            }
        }
    }
    
    public void printGraph(int[][] graph)
    {
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[0].length;j++)
            {
                System.out.print( graph[i][j]+" " );
            }
            System.out.println(  );
        }
    }

    /* Let us create the example graph discussed above */
    public static void main( String[] args )
    {
        /*  int graph[][] = new int[][]{ { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 } };
        GraphMSTPrims t = new GraphMSTPrims( 5 );
        t.prims( graph );*/
        
        int Inf = 1000000000;
        
        GraphMSTPrims t = new GraphMSTPrims( 4 );
        int[][] graph = new int[][] {{0,3,Inf,7},{8,0,2,Inf},{5,Inf,0,1},{2,Inf,Inf,0}};
        System.out.println( "Graph -- Before floyd warshall" );
        t.printGraph( graph );
        System.out.println( "Graph-- After floyd Warshall" );
        t.floydWarshal( graph );
        t.printGraph( graph );
    }

}
