import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BST_Playground {

  public static void main(String[]args){

	  TreeNode root = new TreeNode(3);
	  root.left = new TreeNode(-8);
	  root.right = new TreeNode(-9);
	  root.left.left = new TreeNode(4);
	  root.left.right = new TreeNode(7);
	  root.right.left = new TreeNode(2);
	  root.right.right = new TreeNode(-5);	  
	  root.left.left.left = new TreeNode(1);
	  root.left.left.right = new TreeNode(-2);
	  
	  //List<Integer> result = postOrder(root);
	  //System.out.println(result);
	  System.out.println(maxPathSum(root));
	  System.out.println('c'-'a');
  }
  
  public static List<Integer> postOrder(TreeNode root) {
	    // Write your solution here
	    List<Integer> result = new ArrayList<Integer>();
	    if(root == null)  return result;
	    Deque<TreeNode> stack = new LinkedList<TreeNode>();
	    stack.offerFirst(root);
	    TreeNode prev = null;
	    while(!stack.isEmpty()){
	      TreeNode cur = stack.peekFirst();
	      if(prev == null || cur == prev.left || cur == prev.right){
	        if(cur.left != null) stack.offerFirst(cur.left);
	        else if(cur.right != null) stack.offerFirst(cur.right);
	        else{
	          stack.pollFirst();
	          result.add(cur.key);
	        }
	      }
	      else if(prev == cur.right || prev == cur.left && cur.right == null){
	        stack.pollFirst();
	        result.add(cur.key);
	      }  else stack.offerFirst(cur.right);
	      prev = cur;
	      }
	      return result;
	    }
  
  //Binary Tree Path Sum To Target III
  public static boolean exist(TreeNode root, int target) {
	    // Write your solution here
	    if(root == null) return false;
	    List<Integer> preSums = new ArrayList<Integer>();
	    return helper(root, target, preSums);
	  }
	  
  private static boolean helper(TreeNode root, int target, List<Integer> preSums){
        if(root == null) return false;
	    int siz = preSums.size();
	    int curSum = 0;
	    if(siz == 0) curSum = root.key;
	    else curSum = preSums.get(siz-1) + root.key;    
	    if(preSums.contains(curSum - target) || root.key == target || curSum == target)
	      return true;
	    preSums.add(curSum);
	    if(helper(root.left, target, preSums) || helper(root.right, target, preSums))
	    		return true;    
     
        if(siz!=0)
          preSums.remove(siz);
        return false;
	   
  }
  
  //Maximum Path Sum Binary Tree III
  public static int maxPathSum(TreeNode root) {
	    // Write your solution here
	    int[] globalmax = new int[1];
	    globalmax[0] = root.key;
	    helper(root, globalmax);
	    return globalmax[0];
	    
	  }
  private static int helper(TreeNode root, int[] globalmax){
	    if(root == null) return 0;
	    int maxL = helper(root.left, globalmax);
	    int maxR = helper(root.right, globalmax);
	    int curmax = root.key + Math.max(Math.max(maxL, maxR), 0);
	    if(globalmax[0] < curmax)
	      globalmax[0] = curmax;
	    return curmax;
	  }


}
