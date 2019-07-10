import java.util.*;

public class MergeFiles {
	
	public static int merge(List<Integer> files) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int res = 0;
		for(int file:files) {
			pq.offer(file);
		}
		while(pq.size() > 1) {
			int min1 = pq.poll();
			int min2 = pq.poll();
			res += min1 + min2;
			pq.offer(min1 + min2);
		}
		return res;
	}
	
	public static void main(String[] args) {
		List<Integer> files = new ArrayList<Integer>();
		System.out.println(merge(Arrays.asList(1, 2, 5, 10, 35, 89)));
	}
}
