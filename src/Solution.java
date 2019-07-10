import java.util.*;

public class Solution {
  public List<Integer> postOrder(TreeNode root) {
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
  }
