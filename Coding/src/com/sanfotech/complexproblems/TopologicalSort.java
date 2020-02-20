package com.sanfotech.complexproblems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort
{

    public static void main( String[] args )
    {
        Graph1 g = new Graph1( 6 );
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 

        g.topologicalSort();
    }

}

class Graph1
{
    int V;
    LinkedList[] adj;

    Graph1( int v )
    {
        this.V = v;
        adj = new LinkedList[ v ];

        for( int i = 0; i < v; i++ )
            adj[i] = new LinkedList<>();
    }

    public void addEdge( int v1, int v2 )
    {
        adj[v1].add( v2 );
    }

    public void dfs( int v )
    {
        boolean[] visited = new boolean[ this.V ];
        dfsUtil( v, visited );
    }

    private void dfsUtil( int v, boolean[] visited )
    {
        if( visited[v] )
            return;

        System.out.println( v );
        visited[v] = true;

        Iterator iterator = adj[v].listIterator();

        while( iterator.hasNext() )
        {
            int v1 = (int)iterator.next();
            if( !visited[v1] )
                dfsUtil( v1, visited );
        }

    }

    public void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[ this.V ];

        for( int i = 0; i < this.V; i++ )
        {
            if( !visited[i] )
            {
                topologicalSortUtil( stack, visited, i , this.adj);
            }
        }
        
        while(!stack.isEmpty())
            System.out.println( stack.pop() );
    }

    private void topologicalSortUtil( Stack<Integer> stack, boolean[] visited, int i, LinkedList<Integer>[] adj )
    {
        if(visited[i])
            return;
        
        visited[i] = true;
        
        
        Iterator<Integer> iterator =  adj[i].listIterator();
        
        while(iterator.hasNext())
        {
            int v = iterator.next();
            topologicalSortUtil( stack, visited, v, adj );
        }
        
        stack.push( i );
    }
}
