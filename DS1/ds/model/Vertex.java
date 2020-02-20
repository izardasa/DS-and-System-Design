package ds.model;

public class Vertex {
	private boolean visited;
	private char label;
	public Vertex(boolean visited, char label)
	{
		this.visited = visited;
		this.label = label;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public char getLabel() {
		return label;
	}
	public void setLabel(char label) {
		this.label = label;
	}

}
