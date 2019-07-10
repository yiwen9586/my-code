import java.util.*;

class Pair{
	int dist;
	int node;
	public Pair(int dist, int node) {
		this.dist = dist;
		this.node = node;
	}
}

public class TrustGraph {
	
	static boolean isTrusted(int node, int[][] graph, int[] peers, int thre) {
		int n = graph.length;
		int[] dist = new int[n]; //shortest distance from any nodes to node
		boolean[] visited = new boolean[n];
		HashSet<Integer> pretrusted = new HashSet<Integer>();
		for(int peer: peers)
			pretrusted.add(peer);
		for(int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;
		if(pretrusted.contains(node)) return true; // node already existed in the pretrusted peers
		dist[node] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>( (Pair a, Pair b)->{
			return a.dist - b.dist;
		});
		pq.add(new Pair(0,node));
		while(pq.size() != 0) {
			Pair curPair = pq.poll();
			int curNode = curPair.node;
			int curDist = curPair.dist;
			visited[curNode] = true;
			if(curNode != node && pretrusted.contains(curNode) && dist[curNode] <= thre) return true;
			for(int i = 0; i < n; i++) {
				if(!visited[i] && graph[curNode][i] > 0 && (dist[i] > curDist + graph[curNode][i])) {
					dist[i] = curDist + graph[curNode][i];
					pq.add(new Pair(dist[i], i));
				}
			}		
		}
		for(int i = 0; i < n; i++)
			System.out.println(dist[i]);
		
		return false;
		
	}
	
	 public static void main(String[] args) {
//		    int[][] graph = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
//		                                {4, 0, 8, 0, 0, 0, 0, 11, 0},
//		                                {0, 8, 0, 7, 0, 4, 0, 0, 2},
//		                                {0, 0, 7, 0, 9, 14, 0, 0, 0},
//		                                {0, 0, 0, 9, 0, 10, 0, 0, 0},
//		                                {0, 0, 4, 14, 10, 0, 2, 0, 0},
//		                                {0, 0, 0, 0, 0, 2, 0, 1, 6},
//		                                {8, 11, 0, 0, 0, 0, 1, 0, 7},
//		                                {0, 0, 2, 0, 0, 0, 6, 7, 0}
//		                               };
		 int[][] graph = new int[][]{ {0, 2, 0},{2,0,2},{0,2,0}};
		    System.out.println(isTrusted(0, graph, new int[]{2}, 1));
		  }
}
