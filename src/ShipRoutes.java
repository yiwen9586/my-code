import java.util.*;

public class ShipRoutes {
	public static List<List<Integer>> findRoutes(int maxTravelDist, 
			                             List<List<Integer>> forwardRouteList,
			                             List<List<Integer>> returnRouteList){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		int left = 0;
//		int right = returnRouteList.size() - 1;
		int minDiff = Integer.MAX_VALUE;
		
//		for(int i = 0; i < forwardRouteList.size(); i++) {
//			int forward = forwardRouteList.get(i).get(1);
//			for(int j = 0; j < returnRouteList.size(); j++) {
//				int sum = forward + returnRouteList.get(j).get(1);
//				if(sum <= maxTravelDist && maxTravelDist - sum <= minDiff) {
//					if(maxTravelDist - sum < minDiff) {
//						minDiff = maxTravelDist - sum;
//						res = new ArrayList<List<Integer>>();
//					}
//				res.add(Arrays.asList(forwardRouteList.get(i).get(0), returnRouteList.get(j).get(0)));
//				}
//			}
//		}
		
		Map<Integer,List<Integer>> treeMap1 = new TreeMap<Integer,List<Integer>>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}
					});
		Map<Integer,List<Integer>> treeMap2 = new TreeMap<Integer,List<Integer>>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}
					});
		for(List<Integer> forward : forwardRouteList) {
			List<Integer> ids = treeMap1.getOrDefault(forward.get(1), new ArrayList<Integer>());
			ids.add(forward.get(0));
			treeMap1.put(forward.get(1), ids);
		}
		
		for(List<Integer> returnR : returnRouteList) {
			List<Integer> ids = treeMap2.getOrDefault(returnR.get(1), new ArrayList<Integer>());
			ids.add(returnR.get(0));
			treeMap2.put(returnR.get(1), ids);
		}

		int m = treeMap1.size();
		int n = treeMap2.size();
		int left = 0;
		int right = n - 1;
//		Collections.sort(forwardRouteList, (a, b) ->{
//			return a.get(1) - b.get(1);
//		});
//		Collections.sort(returnRouteList, (a, b) ->{
//			return a.get(1) - b.get(1);
//		});
				
		while(left < n && right >= 0) {
			int sum = (int)treeMap1.keySet().toArray()[left] + (int)treeMap2.keySet().toArray()[right] ;
			if(sum <= maxTravelDist && maxTravelDist - sum <= minDiff) {
				if(maxTravelDist - sum < minDiff) {
					minDiff = maxTravelDist - sum;
					res = new ArrayList<List<Integer>>();
				}
				res.add(Arrays.asList((int)treeMap1.keySet().toArray()[left], (int)treeMap2.keySet().toArray()[right]));
			}
			if(sum <= maxTravelDist)
				left++;
			else
				right--;
		}

		List<List<Integer>> ansList = new ArrayList<List<Integer>>();
		for(List<Integer> ans : res) {
			List<Integer> ids1 = treeMap1.get(ans.get(0));
			List<Integer> ids2 = treeMap2.get(ans.get(1));
			generateRes(ansList, ids1, ids2);
		}
	
		return ansList;
	}
	
	private static void generateRes(List<List<Integer>> ansList, List<Integer> ids1, List<Integer> ids2) {
		for(int id1: ids1) {
			for(int id2: ids2) {
				ansList.add(Arrays.asList(id1, id2));
			}
		}
	}
	
	public static void main(String[] args) {
	    List<List<Integer>> forward = new ArrayList<>();
	    List<List<Integer>> returnL = new ArrayList<>();

	    forward.add(Arrays.asList(1, 5000));
	    forward.add(Arrays.asList(3, 4000));
	    forward.add(Arrays.asList(2, 3000));
	    forward.add(Arrays.asList(4, 1000));
	    forward.add(Arrays.asList(5, 4000));

	    returnL.add(Arrays.asList(1, 2000));
	    returnL.add(Arrays.asList(3, 5000));
	    returnL.add(Arrays.asList(2, 5000));
	    returnL.add(Arrays.asList(4, 6000));


	    List<List<Integer>> res = ShipRoutes.findRoutes(9000, forward, returnL);
	    System.out.println(res);
	    /*Output
	    [[4, 1000], [2, 3000], [3, 4000], [5, 4000], [1, 5000]]
	    [[1, 2000], [3, 5000], [2, 5000], [4, 6000]]
	    [[2, 4], [3, 2], [3, 3]] -> wrong! should be [[2, 4], [3, 2], [3, 3], [5, 3], [5, 2]]
	    */
	}

}
