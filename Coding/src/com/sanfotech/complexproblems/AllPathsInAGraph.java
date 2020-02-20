package com.sanfotech.complexproblems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class AllPathsInAGraph
{

    public static void main( String[] args )
    {
        GraphAllPath graph = new GraphAllPath( 4 );
        graph.addEdge( 0, 1 );
        graph.addEdge( 0, 2 );
        graph.addEdge( 0, 3 );
        graph.addEdge( 2, 0 );
        graph.addEdge( 2, 1 );
        graph.addEdge( 1, 3 );

        graph.findAllPaths( 2, 3 );
    }

}

class GraphAllPath
{
    int V;
    LinkedList[] adj;
    boolean[] visited;

    public GraphAllPath( int v )
    {
        this.V = v;
        adj = new LinkedList[ v ];
        for( int i = 0; i < v; i++ )
            adj[i] = new LinkedList<Integer>();

        visited = new boolean[ v ];
    }

    public void addEdge( int u, int v )
    {
        if( u < 0 || v < 0 || u >= this.V || v >= this.V )
        {
            System.out.println( "Invalid Edge" );
            return;
        }
        adj[u].add( v );
    }

    public void findAllPaths( int source, int dest )
    {
        ArrayList<Integer> pathList = new ArrayList<Integer>();
        pathList.add( source );
        findAllPaths( source, dest, visited, pathList );
    }

    private boolean isSafe( int s )
    {
        if( s < 0 || s >= this.V )
            return false;
        return true;
    }

    private ArrayList<Integer[]> getNeighbours( int s, int d )
    {
        ArrayList<Integer[]> neighbours = new ArrayList<Integer[]>();
        neighbours.add( new Integer[]{ s - 1, d } );
        neighbours.add( new Integer[]{ s, d - 1 } );
        neighbours.add( new Integer[]{ s + 1, d } );
        neighbours.add( new Integer[]{ s, d + 1 } );
        return neighbours;
    }

    private void findAllPaths( int source, int dest, boolean[] visited, ArrayList<Integer> pathList )
    {
        visited[source] = true;
        if( source == dest )
        {
            printAllPaths( pathList );
            visited[source] = false;
             return;
        }

        Iterator<Integer> iterator = this.adj[source].listIterator();

        while( iterator.hasNext() )
        {
            Integer d = iterator.next();
            if( !visited[d]  )
            {
                pathList.add( d );
                findAllPaths( d, dest, visited, pathList );
                pathList.remove( d );
            }

        }
        
        visited[source] = false;
        
    }

    private void printAllPaths( ArrayList<Integer> pathList )
    {
        for( int vertex : pathList )
            System.out.print( vertex + "-> " );
        
        System.out.println(  );

    }
}