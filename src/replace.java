import java.util.ArrayList;

public class replace {
	
	  public static void main(String[]args){

		  System.out.println(replaceStr("appledogapple", "apple", "cat"));
	  }
	  
	  
		  public static String replaceStr(String input, String source, String target){
		    if(source.length() >= target.length())
		      return replaceShorter(input, source, target);
		    else
		      return replaceLonger(input, source, target);
		  }
		  
		  public static String replaceLonger(String input, String source, String target) {
		    int k = input.length();
		    int m = source.length();
		    int n = target.length();
		    char[] org = input.toCharArray();
		    ArrayList<Integer> matches = new ArrayList<Integer>();
		    // count matches and record each end index of the match pattern
		    for(int i = 0; i <= k - m; ){
		      if(org[i] == source.charAt(0) && match(org, source, i)){
		        matches.add(i + m - 1);
		        i += m;
		      }
		    }
		    // extend the array size based on the size of matches
		    char[] res = new char[k + matches.size()*(n-m)];
		    int slow = res.length - 1;      
		    // scan from right to left and replace
		    for(int fast = k-1; fast >= 0; ){
		      if(matches.contains(fast)){
		        copytarget(res, target, slow - n + 1);
		        slow -= n;      
		        fast -= m;
		      }else{
		        res[slow--] = org[fast--];     
		      }      
		    }
		    return new String(res);
		  }
		  
		  
		  public static String replaceShorter(String input, String source, String target) {
		    // Write your solution here
		    int k = input.length();
		    int m = source.length();
		    int n = target.length();
		    char[] org = input.toCharArray();
		    int slow = 0;
		    for(int fast = 0; fast < k; ){
		       if(org[fast] == source.charAt(0) && fast <= k - m && match(org, source, fast)){
		         //find a source, copy target
		           copytarget(org, target, slow);
		           slow += n;
		           fast += m;
		        }
		      else{
		        org[slow++] = org[fast++];
		      }
		    }    
		    return new String(org, 0, slow);   
		  }
		  
		  private static void copytarget(char[] org, String target, int start){
		       for(int i = 0; i < target.length(); i++){
		             org[start + i] = target.charAt(i);
		       } 
		  }
		  
		  private static boolean match(char[] org, String source, int start) {
		    for(int i = 0; i < source.length(); i++){
		      if(org[start+i] != source.charAt(i))
		        return false;
		    }
		    return true;   
		  }
	
}
