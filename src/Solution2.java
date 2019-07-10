import java.util.*;

public class Solution2 {
  public boolean exist(TreeNode root, int target) {
    // Write your solution here
    if(root == null) return false;
    List<Integer> preSums = new ArrayList<Integer>();
    return helper(root, target, preSums);
  }
  
  private boolean helper(TreeNode root, int target, List<Integer> preSums){
	    if(root == null) return false;
	    int siz = preSums.size();
	    int curSum = 0;
	    if(siz == 0) curSum = root.key;
	    else curSum = preSums.get(preSums.size()-1) + root.key;    
	    if((preSums.contains(target - curSum) && (root.key != (target - root.key))) || root.key == target || curSum == target)
	      return true;
	    preSums.add(curSum);
	    if(helper(root.left, target, preSums))
	    		return true;    
	    if(helper(root.right, target, preSums))
		    	return true;
	    preSums.remove(siz);
	    return false;
  }
}
