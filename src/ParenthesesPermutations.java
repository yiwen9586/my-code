import java.util.*;

public class ParenthesesPermutations {
	
	  public static List<String> validParentheses(int l, int m, int n) {
		    // Write your solution here
		    Deque<Character> stack = new LinkedList<>();
		    int[] pairs = new int[3];
		    pairs[0] = l;
		    pairs[1] = m;
		    pairs[2] = n;
		    char[] parents = {'(', ')', '<', '>', '{', '}'};
		    List<String> res = new LinkedList<String>();
		    int[] left = new int[3];
		    StringBuilder pre = new StringBuilder();
		    helper(pairs, left, parents, 0, stack, res, pre);
		    return res;
		  }

		  public static void helper(int[] pairs, int[] left, char[] parents, int index, Deque<Character> stack, List<String> res, StringBuilder pre){
			 //System.out.println(index);
			 //System.out.println(pre.toString());
			  if(index == (pairs[0] + pairs[1] + pairs[2]) * 2){
		      res.add(pre.toString());
		      return;
		    }
		    for(int i = 0; i < 6; i++){
		    	 
		      if(i % 2 == 0){ //"(", "<", "{"
		        if(left[i / 2] < pairs[i / 2]){
		          pre.append(parents[i]);
		          stack.add(parents[i]);
		          left[i / 2]++;
		          helper(pairs, left, parents, index + 1, stack, res, pre);
		          left[i / 2]--;
		          pre.deleteCharAt(pre.length() - 1);
		          stack.pollLast();
		      }
		      }
		      else{ //")", ">", "}"
		        if(!stack.isEmpty() && stack.peekLast() == parents[i - 1]){ // match
		          pre.append(parents[i]);
		          stack.pollLast();
		          helper(pairs, left, parents, index + 1, stack, res, pre);
		          pre.deleteCharAt(pre.length() - 1);
		          stack.add(parents[i - 1]);
		        }
		      } 

		    }
		    
		    
		  }
		  
		  public static void main(String[] args) {
			    System.out.print(validParentheses(1, 1, 0));
			}

}




