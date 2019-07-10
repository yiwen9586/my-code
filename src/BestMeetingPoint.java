import java.util.*;

public class BestMeetingPoint {
	public static long solution(long[][] clients){
		if(clients == null || clients.length == 0) return 0;
		List<Long> xs = new ArrayList<Long>();
		List<Long> ys = new ArrayList<Long>();
		int dist = 0;
		
		for(long[] client : clients) {
			xs.add(client[0]);
			ys.add(client[1]);
		}
		Collections.sort(xs);
		Collections.sort(ys);
		int i = 0;
		int j = xs.size() - 1;
		while(i < j) {
			dist += xs.get(j) - xs.get(i) + ys.get(j) - ys.get(i);
			i++;
			j--;
		}
		
		return dist;		
	}
	
	public static void main(String[] args) {

		 long[][] clients = new long[][]{ {-4, 3}, {-2, 1}, {1, 0}, {3, 2}};
		 System.out.println(solution(clients));
	 }
}
