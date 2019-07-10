public class anagramDiff { 
  
    // Counts the no of manipulations required 
    static int countManipulations(String s) 
    { 
    	 // Complete the anagram function below.
            int n = s.length();
            if(n % 2 == 1) return -1;
            int i = 0;
            int[] countMap = new int[26];
            int res = 0;
            while(i < n / 2){
                countMap[s.charAt(i)-'a']++;
                i++;
            }
            while(i < n){
            	countMap[s.charAt(i)-'a']--;
                if(countMap[s.charAt(i)-'a'] < 0)
                    res++;   
                i++;
            }
            return res;
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        String s = "xaxbbbxx"; 
//        aaabbb
//        ab
//        abc
//        mnop
//        xyyx
//        xaxbbbxx
        System.out.println(countManipulations(s)); 
    } 
} 
