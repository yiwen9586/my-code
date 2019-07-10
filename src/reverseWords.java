public class reverseWords {
	
	  public static void main(String[]args){
		  System.out.println(revWords("I love Yahoo"));
		 //System.out.println(strstr("ababbacdefghijbbab","bbab"));
		 // System.out.println(hashofchar('a') * Math.pow(31, 32 - 1)%101);
	  }
	
  public static String revWords(String input) {
    // Write your solution here
    if(input == null) return null;
    char[] array = input.toCharArray();
    reverse(array, 0, input.length()-1);
    System.out.println(array);
    int start = 0;
    for(int i = 0; i < array.length; i++){
      //determine the start of a word
      if(array[i] != ' ' && (i == 0 || array[i-1] == ' '))
        start = i;
      //determine the end of a word
      if(array[i] != ' ' && (i == array.length-1 || array[i+1] == ' ')){
        if(start != i)
          reverse(array, start, i);       
      }
    }
    return new String(array);
  }
  
  private static void reverse(char[] array, int start, int end) {
	    while(start < end){
	        swap(array, start, end);
	        start++;
	        end--;
	      }
  }
  
  private static void swap(char[] array, int index1, int index2){
    char temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

}
