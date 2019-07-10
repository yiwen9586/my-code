
public class ReducedFraction {
	
//	public static String addFraction(String s) {
//        String[] fractions = s.split("\\+");
//        String[] frac1 = fractions[0].split("/");
//        int a = Integer.parseInt(frac1[0]);
//        int b = Integer.parseInt(frac1[1]);
//        String[] frac2 = fractions[1].split("/");
//        int c = Integer.parseInt(frac2[0]);
//        int d = Integer.parseInt(frac2[1]);
//
//        int numerator = a * d + b * c;
//        int denominator = b * d;
//        int factor = gcd(numerator, denominator);
//        while (factor != 1) {
//            numerator /= factor;
//            denominator /= factor;
//            factor = gcd(numerator, denominator);
//        }
//        return String.valueOf(numerator) + "/" + String.valueOf(denominator);
//    }
//	
//    private static int gcd(int a, int b) {
//        if (a % b != 0) {
//            return gcd(b, a % b);
//        } else {
//            return b;
//        }
//    }
//    
//    public String[] getResult(String[] list) {
//        String[] result = new String[list.length];
//        for (int i = 0; i < list.length; i++) {
//            result[i] = addFraction(list[i]);
//        }
//        return result;
//    }
//    
//    public static void main(String[] args) {
//        System.out.println(addFraction("3/6+3/6"));
//    }
	
	static int gcd(int a, int b)  
	{  
	    if (a == 0)  
	        return b;  
	    return gcd(b%a, a);  
	}  
	  
	// Function to convert the obtained fraction  
	// into it's simplest form  
	static void lowest(int den3, int num3)  
	{  
	    // Finding gcd of both terms  
	    int common_factor = gcd(num3,den3);  
	  
	    // Converting both terms into simpler  
	    // terms by dividing them by common factor  
	    den3 = den3/common_factor;  
	    num3 = num3/common_factor; 
	    System.out.println(num3+"/"+den3); 
	}  
	  
	//Function to add two fractions  
	static void addFraction(int num1, int den1,  
	                        int num2, int den2)  
	{  
	    // Finding gcd of den1 and den2  
	    int den3 = gcd(den1,den2);  
	  
	    // Denominator of final fraction obtained  
	    // finding LCM of den1 and den2  
	    // LCM * GCD = a * b  
	    den3 = (den1*den2) / den3;  
	  
	    // Changing the fractions to have same denominator  
	    // Numerator of the final fraction obtained  
	    int num3 = (num1)*(den3/den1) + (num2)*(den3/den2);  
	  
	    // Calling function to convert final fraction  
	    // into it's simplest form  
	    lowest(den3,num3);  
	}  
	  
	// Driver program  
	public static void main(String[] args)  
	{  
	    int num1=3, den1=6, num2=3, den2=6;  
	    System.out.print(num1+"/"+den1+" + "+num2+"/"+den2+" is equal to "); 
	    addFraction(num1, den1, num2, den2); 
	}  

}
