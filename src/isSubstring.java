import java.lang.*;

public class isSubstring {
	
  public static void main(String[]args){
	  System.out.println(strstr("aqrstuvwxyzzabcdefghijklmnopqrstu", "qrstuvwxyzzabcdefghijklmnopqrstu"));
	 //System.out.println(strstr("ababbacdefghijbbab","bbab"));
	 // System.out.println(hashofchar('a') * Math.pow(31, 32 - 1)%101);
  }
  
//  public static int strstr(String large, String small) {
//    // Write your solution here
//    int m = large.length();
//    int n = small.length();
//    char[] array = large.toCharArray();
//    if(n == 0) return 0;
//    else if(m == 0) return -1;
//    int s2_code = hashofstr(small);
//    int s1_code = hashofstr(large.substring(0, n));
//    
//    System.out.println("small hash code:" + s2_code);  
//    
//    for(int i = 0; i <= m - n; i++){
//      System.out.println("start index: "+ i + " hash code: " + s1_code);
//      if(s1_code == s2_code) {
//          if(compare(large.substring(i, i + n),small))
//              return i;
//      }
//      if(i == m-n) break;
//      else {
//	      s1_code -= (hashofchar(array[i]) * Math.pow(31, n - 1)) % 101;
//	      if (s1_code < 0)
//	    	  s1_code += 101;
//	      s1_code %= 101;
//	      System.out.println(s1_code);
//	      s1_code *= 31;
//	      s1_code %= 101;
//	      System.out.println(s1_code);
//	      s1_code += hashofchar(array[i + n]) % 101;
//	      s1_code %= 101;
//	      System.out.println(s1_code);
//      }
//    }
//    
//    return -1;
//  }
//  
//  
//  private static boolean compare(String str1, String str2){
//    char[] array1 = str1.toCharArray();
//    char[] array2 = str2.toCharArray();
//    for(int i = 0; i < str1.length(); i++){
//      if(array1[i] != array2[i])
//        return false;
//    }
//    return true;
//  }
//  
//  private static int hashofstr(String str){
//    char[] array = str.toCharArray();
//    int n = str.length();
//    int code = (int) (array[0] % 101);
//    for (int i = 1; i < n; i++) {
//	  code = moduleHash(code, array[i], 31, 101);	  
//    }
//    return code;
//  }
//  
//  private static int hashofchar(char ch){
//    return (int)ch;
//  }
//  
  public static int strstr(String large, String small) {
	  int largePrime = 101;
	  int prime = 31;
	  int seed = 1;
	  int targetHash = small.charAt(0) % largePrime;
	  for (int i = 1; i < small.length(); i++) {
		  seed = moduleHash(seed, 0, prime, largePrime);
		  targetHash = moduleHash(targetHash, small.charAt(i), prime, largePrime);	  
	  }
	  System.out.println("small hash: " + targetHash);
	  System.out.println("seed: " + seed);
	  int hash = 0;
	  for(int i = 0; i < small.length(); i++) {
		  hash = moduleHash(hash, large.charAt(i), prime, largePrime);
	  }
	  System.out.println("large hash: " + hash);
	  if(hash == targetHash && equals(large, 0, small))
		  return 0;
	  for(int i = 1; i <=large.length()-small.length(); i++) {
		  hash = nonNegative(hash-seed*large.charAt(i-1)%largePrime,largePrime);
		  hash = moduleHash(hash, large.charAt(i+small.length()-1), prime, largePrime);
		  if(hash == targetHash && equals(large, i, small)) return i;
	  
	  }
	  return -1;
  }
  
  private static boolean equals(String large, int start, String small) {
	  for(int i = 0; i < small.length(); i++) {
		  if(large.charAt(i + start) != small.charAt(i))
			  return false;
	  }
	  return true;
  }
//  
  private static int moduleHash(int hash, int addition, int prime, int largePrime) {
	  return (hash * prime % largePrime + addition) % largePrime;
  }
  
  private static int nonNegative(int hash, int largePrime) {
	  if(hash < 0) {
		  hash += largePrime;
	  }
	  return hash;
  }
  


}

