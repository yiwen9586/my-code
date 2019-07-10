import java.util.*;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BuildOffice {
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,-1,0,1};
	
	static int shortest = Integer.MAX_VALUE;
	
	static int distance(int m, int n, List<Integer> res) {
		int[][] dist = new int[m][n];
		int ans = 0;
		Queue<Point> que = new LinkedList<>();
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
					dist[i][j] = -1;
			}
		}
		
		for(int building : res) {
			int x = building / n;
			int y = building % n;
			dist[x][y] = 0;
			que.offer(new Point(x, y));
		}
		
		while(!que.isEmpty()) {
			Point cur = que.poll();
			int curx = cur.x;
			int cury = cur.y;
			for(int i = 0; i < 4; i++) {
				int nxtx = cur.x + dx[i];
				int nxty = cur.y + dy[i];
				if(nxtx >=0 && nxtx < m && nxty >=0 && nxty < n && dist[nxtx][nxty] == -1) {
					dist[nxtx][nxty] = dist[curx][cury] + 1;
					ans = Math.max(ans, dist[nxtx][nxty]);
					que.offer(new Point(nxtx, nxty));
				}
			}
		}
		System.out.println(ans);
		return ans;
	}

	static void build(int m, int n, int[] mn, int k, List<Integer> res, int index) {
		if(res.size() == k) {
			System.out.println(res);
			//shortest = Math.min(shortest, distance(m, n, res));
			return;
		}
		if(index == mn.length) return;
		res.add(mn[index]);
		build(m, n, mn, k, res, index + 1);
		res.remove(res.size()-1);
		build(m, n, mn, k, res, index + 1);
	
		
			//solution 2 to find subset
//			if(res.size() == k) {
//				System.out.println(res);
//				return;
//			}
//			for (int i = index; i < mn.length; i++) {
//				res.add(mn[i]);
//				build(m, n, mn, k, res, index + 1);
//				res.remove(res.size()-1);
//				index += 1;
//			}	
			
	}
	
	public static void main(String[] args) {
		int m = 8 ;
		int n = 1;
		int k = 3;
		
	    int[] mn = new int[m * n];
	    for(int i = 0; i < m * n; i++)
	    	mn[i] = i;
	    
	    List<Integer> res = new ArrayList<Integer>();
	    build(m, n, mn, k, res, 0);
	    System.out.print(shortest);
	}
}
