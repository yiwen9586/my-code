import java.util.*;

public class findAllSubsets {
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    public static void helper(int[] nums, int index, List<Integer> pre, List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<Integer>(pre));
            return;
        }
        
        // case 1 include current item
        pre.add(nums[index]);
        helper(nums, index + 1, pre, res);
       
        pre.remove(pre.size() - 1);
        
        // case 2 descard current iterm
        helper(nums, index + 1, pre, res);
        
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,3};
    	System.out.print(subsets(nums));
    }
    
}