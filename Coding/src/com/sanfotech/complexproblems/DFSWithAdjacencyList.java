package com.sanfotech.complexproblems;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSWithAdjacencyList
{

    public static void main( String[] args )
    {
        Graph graph = new Graph( 4 );
        graph.addEdge( 0,1 );
        graph.addEdge( 0,2 );
        graph.addEdge( 1,2 );
        graph.addEdge( 2,0 );
        graph.addEdge( 2,3 );
        graph.addEdge( 3,3 );

        graph.dfs( 2 );
    }

}

class Graph
{
    int V;
    LinkedList[] adj;
    
    Graph(int v )
    {
        this.V = v;
        adj = new LinkedList[v];
        
        for(int i=0;i<v;i++)
            adj[i] = new LinkedList<>();
    }
    
    public void addEdge(int v1, int v2)
    {
        adj[v1].add( v2 );
    }
    
    public void dfs(int v)
    {
        boolean[] visited = new boolean[this.V];
        dfsUtil(v, visited);
    }

    private void dfsUtil( int v, boolean[] visited )
    {
        if(visited[v])
            return;
        
        System.out.println( v );
        visited[v] = true;
        
        Iterator iterator = adj[v].listIterator();
        
        while(iterator.hasNext())
        {
            int v1 = (int)iterator.next();
            if(!visited[v1])
                dfsUtil( v1, visited );
        }

        
    }
}
