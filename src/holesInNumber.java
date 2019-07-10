import java.util.*;

public class holesInNumber {

	public static int countHoles(int num) {
		int res = 0;
		int[] holeMap = {1, 0, 0, 0, 1, 0, 1, 0, 2, 1};
		while(num > 0) {
			int digit = num %10;
			res += holeMap[digit];
			num = num / 10;
		}
		return res;
	}
	
	public static void main (String[] args)  
	{ 
	    int num = 2537312; 
	    System.out.println(countHoles(num)); 
	} 
}
