public class ValidTriangles {
	
	 static boolean[] triangles(int[] as, int[] bs, int[] cs) 
	    { 
	    	 // Complete the anagram function below.
	            int n = as.length;
	            boolean[] res = new boolean[n];
	            
	            for(int i = 0; i < n; i++) {
	            	if((as[i]+bs[i])<cs[i] || (as[i]+cs[i])<bs[i] || (bs[i]+cs[i])<as[i])      
	            		res[i] = false;
	            	else
	            		res[i] = true;
	            }
	            
	            return res;
	    } 
	  
	    // Driver code 
	    public static void main(String[] args) 
	    { 
	        int[] as = {3,1}; 
	        int[] bs = {4,2};
	        int[] cs = {5,6};
            boolean[] res = triangles(as, bs, cs);
	        for(int i = 0; i < as.length; i++)
	        	System.out.println(res[i]); 
	    } 
}
