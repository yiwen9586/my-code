import java.util.*;

public class NQueens {
	 public static List<List<Integer>> nqueens(int n) {
		    // Write your solution here
		    List<List<Integer>> ans = new ArrayList<List<Integer>>();
		    List<Integer> cur = new ArrayList<Integer>();
		    boolean[] usedColumns = new boolean[n];
		    boolean[] usedDiags = new boolean[2 * n - 1];
		    boolean[] usedRevDiags = new boolean[2 * n - 1];
		    helper(ans, cur, n, 0, usedColumns, usedDiags, usedRevDiags); // index -> row
		    return ans;
		  }

		  public static void helper(List<List<Integer>> ans, List<Integer> cur, int n, int row, boolean[] usedColumns, boolean[] usedDiags, boolean[] usedRevDiags){
		    if(cur.size() == n){
		      ans.add(new ArrayList(cur));
		      return;
		    }

		    for(int col = 0; col < n; col++){
		      if(valid(n, row, col, usedColumns, usedDiags, usedRevDiags)){
		        cur.add(col);
		        mark(n, row, col, usedColumns, usedDiags, usedRevDiags);
		        helper(ans, cur, n, row + 1, usedColumns, usedDiags, usedRevDiags);
		        cur.remove(cur.size() - 1);
		        unmark(n, row, col, usedColumns, usedDiags, usedRevDiags);
		      }
		    }
		  }

		  public static boolean valid(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiags, boolean[] usedRevDiags){
		    return !usedColumns[col] && !usedDiags[row + col] && !usedRevDiags[col - row + n - 1];
		  }

		  public static void mark(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiags, boolean[] usedRevDiags){
		    usedColumns[col] = true;
		    usedDiags[row + col] = true;
		    usedRevDiags[col - row + n - 1] = true;
		  }

		  public static void unmark(int n, int row, int col, boolean[] usedColumns, boolean[] usedDiags, boolean[] usedRevDiags){
		    usedColumns[col] = false;
		    usedDiags[row + col] = false;
		    usedRevDiags[col - row + n - 1] = false;
		  }
		  
		  public static void main(String[] args) {
			    System.out.print(nqueens(4));
			}
}

