import java.util.*;

public class minUniqueSum {
	 // Counts the no of manipulations required 
    static int getMinUniqueSum(int[] arr) 
    { 
    	 // Complete the anagram function below.
            int n = arr.length;
            HashSet<Integer> set = new HashSet<Integer>(); 
            set.add(arr[0]);
            int sum = arr[0];
            
            for(int i = 1; i < n; i++) {
            	int curVal = arr[i];
            	while(set.contains(curVal)) {
            		curVal++;           		
            	}
            	
            	sum += curVal;
            	
            	set.add(curVal);           	
            }
            
            return sum;
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int[] arr = {1,2,4,4,7,7,8}; 
        System.out.println(getMinUniqueSum(arr)); 
    } 
}
