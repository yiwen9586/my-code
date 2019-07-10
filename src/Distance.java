
public class Distance {
	 public static double solution(double[][] readings, long endTime){	 
		 if(endTime < 0) return 0;
		 double dist = 0;
		 int i = 0;
		 for(i = 1; i < readings.length; i++) {
			 if(readings[i][0] < endTime) {
				 dist += (readings[i][0] - readings[i - 1][0]) / 3600 * readings[i - 1][1];				 
			 }else {
				 break;
			 }
		 }
		 dist += (endTime - readings[i - 1][0]) / 3600 *  readings[i - 1][1];	
		 return dist;
	 }
	 
	 public static void main(String[] args) {

		 double[][] readings = new double[][]{ {0, 90},{60, 98},{155, 85.5}};
		 long endTime = 120;
		 System.out.println(solution(readings, endTime));
	 }
}
