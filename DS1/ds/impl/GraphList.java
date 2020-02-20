package ds.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphList {

	int numberOfVertices ;
	private java.util.LinkedList<Integer>[] adjGraphList;
	public GraphList(int numberOfVertices){
		adjGraphList = new java.util.LinkedList[numberOfVertices];
		this.numberOfVertices = numberOfVertices;
		
		for(int i=0;i<numberOfVertices;i++)
			adjGraphList[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int source, int destination)
	{
		adjGraphList[source].add(destination);
		//adjGraphList[destination].add(source);
	}
	
	public void topologicalSort()
	{
		Stack<Integer> theStack = new Stack<Integer>();
		boolean[] visited = new boolean[numberOfVertices];
		for(int i=0;i<numberOfVertices;i++)
		{
			visited[i]=false;
		}
		
		for(int i=0;i<numberOfVertices;i++)
		{
			if(!visited[i])
			{
				topologicalSortUtil(visited, theStack, i);
			}
		}
		
		while(!theStack.isEmpty())
		{
			System.out.println(theStack.pop());
		}
	}
	
	private void topologicalSortUtil(boolean[] visited, Stack<Integer> theStack, int v)
	{
		visited[v]= true;
		int i;
		Iterator<Integer> it = adjGraphList[v].iterator(); 
		while(it.hasNext())
		{
			i = it.next();
			if(!visited[i])
			{
			topologicalSortUtil(visited, theStack, i);
			}
			
		}
		
		theStack.push(v);
	}

	public void printGraph()
	{
		System.out.println("Print garph");
		for(int i=0;i<adjGraphList.length;i++)
		{
			System.out.print("head ("+i+")");
			for(Integer pCrawl: adjGraphList[i])
			{
				System.out.print("->" +pCrawl);
			}
			System.out.println();
		}
	}
}
