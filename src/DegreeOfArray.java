import java.util.*;

public class DegreeOfArray {
    static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> right = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            if(!left.containsKey(nums[i]))
                left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        
        int ans = n;
        int degree = Collections.max(count.values());
        
        for(int x : count.keySet()){
            if(count.get(x) == degree)
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
        }
        
        return ans;         
    }
    
    public static void main(String[] args) 
    { 
        int[] nums = {1,2,2,3,1};
        System.out.println(findShortestSubArray(nums)); 
    } 
}
