import java.util.*;

public class KMinusOneDistinct {
	public static List<String> find(String input, int K){
		List<String> res = new ArrayList<String>();
		int[] count = new int[26];
		for(int i = 0; i <= input.length() - K; i++) {//each K window
			Arrays.fill(count, 0);
			boolean repeated = false;
			for(int j = i; j < i + K; j++) {
				if(count[input.charAt(j) - 'a'] == 0) {
					//new character
					count[input.charAt(j) - 'a']++;
				}else { //return character
					if(repeated == true) {
						repeated = false;
						break; //invalid answer
					}
					else {
						repeated = true;
						count[input.charAt(j) - 'a']++;
					}
				}
			}
			if(repeated)
				res.add(input.substring(i, i + K));
				
		}
		return res;		
	}
	
	public static void main(String[] args) {
		System.out.println(find("aawwwaglkk",4));
	}
}
