import java.util.*;

public class MazeFindPath {
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,-1,0,1};
	
	public static int ShortestPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return 0;
		if (matrix[0][0] == 9) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int curDist = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		HashMap<Integer, Integer> dist = new HashMap<Integer,Integer>();
		q.offer(new int[] {0,0});
		matrix[0][0] = 0; //visted
	    dist.put(0, 0);

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			curDist = dist.get(cur[0] * n + cur[1]);
			if(matrix[cur[0]][cur[1]] == 9) return curDist;
			matrix[cur[0]][cur[1]] = 0; // visited
			for(int i = 0; i < 4; i++) {
				int nextX = cur[0] + dx[i];
				int nextY = cur[1] + dy[i];
				if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
					if(matrix[nextX][nextY] == 1) { //not visited
						q.offer(new int[] {nextX, nextY});
						matrix[nextX][nextY] = 0;
						dist.put(nextX * n + nextY, curDist + 1);
					}
				}						
			}
		}
		return curDist-1;
	}
	
	public static void main(String[] args) {
		int matrix[][] = 
			{ 
		        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
		        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
		        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
		        { 0, 0, 0, 0, 9, 0, 0, 0, 0, 1 }, 
		        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
		        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
		        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
		        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
		        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } 
		    }; 
		
		int matrix1[][] = {{1,0,0},{1,1,1},{1,9,1}};
		System.out.println(MazeFindPath.ShortestPath(matrix1));
	}
}
