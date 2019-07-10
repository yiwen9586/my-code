import java.util.*;

class connection{
	int city1;
	int city2;
	int cost;
	public connection(int city1, int city2, int cost) {
		this.city1 = city1;
		this.city2 = city2;
		this.cost  = cost;
	}
}


public class cityConnect {
	private static int unionNum;
	
	public static int getLowestCost(int numTotalAvailableCities,
			                        int numTotalAvailableRoads,
			                        List<List<Integer>> roadsAvailable,
			                        int numNewRoadsConstruct,
			                        List<List<Integer>> costNewRoadsConstruct) {
		//no need to build new roads
		if(numTotalAvailableCities < 2 || numTotalAvailableRoads >= numTotalAvailableCities - 1)
			return 0;
		
		unionNum = 0;
		int existRoadNum = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> roadSelected = new ArrayList<Integer>();
		int totalMinCost = 0;
		
		//put exist roads into union and count exist road number
		for(List<Integer> existRoad : roadsAvailable) {
			if(!isUnion(map, existRoad.get(0), existRoad.get(1)))
				existRoadNum++;
		}
		
		System.out.println(existRoadNum);
		
		//sort new road using priorityqueue using cost
//		PriorityQueue<connection> pq = new PriorityQueue<connection>(numNewRoadsConstruct, new Comparator<connection> () {
//            public int compare(connection a, connection b) {
//                return a.cost - b.cost;
//            }
//        });
		
		PriorityQueue<connection> pq = new PriorityQueue<connection>(numNewRoadsConstruct, (connection a, connection b) ->{
			 return a.cost - b.cost;
		});
		
		for(List<Integer> newRoad : costNewRoadsConstruct) {
			connection cn = new connection(newRoad.get(0), newRoad.get(1), newRoad.get(2));
			pq.offer(cn);
		}
		
		while(!pq.isEmpty() && roadSelected.size() + existRoadNum < numTotalAvailableCities - 1) {
			connection cn = pq.poll();
			if(!isUnion(map, cn.city1, cn.city2)) {
				roadSelected.add(cn.cost);
				System.out.println(cn.cost);
			}
		}
		
		if(roadSelected.size() + existRoadNum <  numTotalAvailableCities - 1) return -1;
		
		for(int cost: roadSelected) 
			totalMinCost += cost;
		
		return totalMinCost;
	}
	
	
	private static boolean isUnion(HashMap<Integer, Integer> map, int city1, int city2) {
		System.out.println(map);
		if(!map.containsKey(city1) && !map.containsKey(city2)) { //both city1 and city2 are out
			map.put(city1, unionNum);
			map.put(city2, unionNum);
			unionNum++;
			return false;
		}else if(!map.containsKey(city1)) { //city2 in, city1 out, put city1 in
			map.put(city1, map.get(city2));
			return false;
		}else if(!map.containsKey(city2)) { //city1 in, city2 out, put city2 in
			map.put(city2, map.get(city1));
			return false;			
		}else { //both city1 and city2 are in
			int union1 = map.get(city1);
			int union2 = map.get(city2);
			
			if(union1 == union2) return true; //same union
			else { //not in same union, connect
		        for(int city: map.keySet()) {
		        	if(map.get(city) == union1)
		        		map.put(city, union2);
		        }				
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		int numTotalAvailableCities = 6;
        int numTotalAvailableRoads = 3;
        List<List<Integer>> roadsAvailable = new ArrayList<List<Integer>>();
        int numNewRoadsConstruct = 4;
        List<List<Integer>> costNewRoadsConstruct = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<Integer>(2);
        l1.add(1);
        l1.add(4);
        roadsAvailable.add(l1);
        List<Integer> l2 = new ArrayList<Integer>(2);
        l2.add(4);
        l2.add(5);
        roadsAvailable.add(l2);
        List<Integer> l3 = new ArrayList<Integer>(2);
        l3.add(2);
        l3.add(3);
        roadsAvailable.add(l3);
        List<Integer> l4 = new ArrayList<Integer>(3);
        l4.add(1);
        l4.add(2);
        l4.add(5);
        costNewRoadsConstruct.add(l4);
        List<Integer> l5 = new ArrayList<Integer>(3);
        l5.add(1);
        l5.add(3);
        l5.add(10);
        costNewRoadsConstruct.add(l5);
        List<Integer> l6 = new ArrayList<Integer>(3);
        l6.add(1);
        l6.add(6);
        l6.add(2);
        costNewRoadsConstruct.add(l6);
        List<Integer> l7 = new ArrayList<Integer>(3);
        l7.add(5);
        l7.add(6);
        l7.add(5);
        costNewRoadsConstruct.add(l7);
        
        //cityConnect cc = new cityConnect();
        System.out.println(cityConnect.getLowestCost(numTotalAvailableCities, numTotalAvailableRoads, roadsAvailable, numNewRoadsConstruct, costNewRoadsConstruct));

	}
}
