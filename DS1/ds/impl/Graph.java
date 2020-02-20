package ds.impl;

import java.util.Queue;
import java.util.Stack;

import ds.model.Vertex;

public class Graph {
	private int vertexCount = 0;
	private static final int MAX_VERTICES = 20;
	private Vertex[] vertexList;
	private int[][] adjMatrix;
	private Stack<Integer> stack;
	Queue<Integer> queue;

	public Graph() {
		vertexList = new Vertex[MAX_VERTICES];
		adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
		for (int i = 0; i < MAX_VERTICES; i++) {
			for (int j = 0; j < MAX_VERTICES; j++) {
				adjMatrix[i][j] = 0;
			}
		}
		stack = new Stack<Integer>();
		queue = new java.util.LinkedList<>();
	}

	public void addEdge(int i, int j) {
		if (i >= 0 && j >= 0) {
			adjMatrix[i][j] = 1;
			adjMatrix[j][i] = 1;
		}
	}

	public void addVertex(char label) {
		vertexList[vertexCount++] = new Vertex(false, label);
	}

	private void displayVertex(int index) {
		System.out.println(vertexList[index].getLabel());

	}

	private int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < vertexCount; j++) {
			if (adjMatrix[v][j] == 1 && !vertexList[j].isVisited())
				return j;
		}
		return -1;
	}

	public void bfs()
	{
		queue.add(0);
		displayVertex(0);
		vertexList[0].setVisited(true);
		while(!queue.isEmpty())
		{
			int v = queue.remove();
			int v1;
			while((v1 = getAdjUnvisitedVertex(v))!=-1)
			{
				queue.add(v1);
				displayVertex(v1);
				vertexList[v1].setVisited(true);
			}
		}
	}

	public void dfs() {
		displayVertex(0);
		stack.push(0);
		vertexList[0].setVisited(true);
		while (!stack.isEmpty()) {
			int v = getAdjUnvisitedVertex(stack.peek());
			if (v == -1) {
				stack.pop();
			} else {
				displayVertex(v);
				stack.push(v);
				vertexList[v].setVisited(true);
			}

		}

		for (int i = 0; i < vertexCount; i++)
			vertexList[i].setVisited(false);
	}
}
