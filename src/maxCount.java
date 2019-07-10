public class maxCount {
    public static int count(int[][] ops) {
    	int m = Integer.MAX_VALUE;
    	int n = Integer.MAX_VALUE;
        for(int[] op: ops){
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
    
	public static void main (String[] args)  
	{ 
	    int[][] steps= {{2,2},{3,3}}; 
	    System.out.println(count(steps)); 
	} 
}