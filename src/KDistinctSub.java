import java.util.*;

public class KDistinctSub {
	public static int kdistinct(String str, int K) {
		int[] count = new int[26];
		int res = 0;
		int N = str.length();
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(count, 0);
			int charCount = 0;
			for(int j = i; j < N; j++) {
				if(count[str.charAt(j) - 'a'] == 0)
					charCount++;
				count[str.charAt(j) - 'a'] += 1;
				if(charCount == K)
					res++;
			}				
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(KDistinctSub.kdistinct("pqpqs", 2));
	}
}
