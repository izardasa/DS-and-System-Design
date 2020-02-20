import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxNumberOfIslands {

	private static List<Integer> countIslands(int[][] A)
	{
		int row= A.length;
		int col = A[0].length;
		List<Integer> countIslands = new ArrayList<Integer>();
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(A[i][j]==1 && !visited[i][j])
					findIslands(i,j, A, visited, countIslands);
			}
		}
		return countIslands;
	}
	
	private static void findIslands(int i, int j, int[][] a, boolean[][] visited, List<Integer> countIslands) {
		int islandSize=0;
		List<Integer[]> nodesToExplore = new ArrayList<>();
		nodesToExplore.add(new Integer[] {i,j});
		while(nodesToExplore.size()>0)
		{
			Integer[] currentNode = nodesToExplore.get(nodesToExplore.size()-1);
			nodesToExplore.remove(nodesToExplore.size()-1);
			
			 i = currentNode[0];
			 j = currentNode[1];
			 
			 if(visited[i][j])
				 continue;
			 
			 visited[i][j] =true;
			 
			 if(a[i][j]==0)
				 continue;
			 
			 System.out.println(i+","+j);
			 islandSize++;
			 
			 nodesToExplore.addAll(getUnvistedAdjacentElements(i,j,a,visited));
			
		}
		
		countIslands.add(islandSize);
		
	}

	private static List<Integer[]> getUnvistedAdjacentElements(int i, int j, int[][] a, boolean[][] visited) {
		List<Integer[]> unvistedNodes = new ArrayList<>();
		if(i>0 && !visited[i-1][j])
			unvistedNodes.add(new Integer[] {i-1,j});
		if(i<a.length-1 && !visited[i+1][j])
			unvistedNodes.add(new Integer[] {i+1,j});
		if(j>0 && !visited[i][j-1])
			unvistedNodes.add(new Integer[] {i,j-1});
		if(j<a[0].length-1 && !visited[i][j+1])
			unvistedNodes.add(new Integer[] {i,j+1});
		return unvistedNodes;
			
			
	}

	public static void main(String[] args) {
		int[][] setOfIslands = new int[][]
				{
						{1,1,0,0,1},
						{1,1,1,1,0},
						{0,0,1,0,0},
						{0,0,1,1,0},
						{0,1,0,0,0}
				};
				
				System.out.println(countIslands(setOfIslands));

	}
	


}
