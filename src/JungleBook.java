import java.util.*;

public class JungleBook {

	static int countGroups(int[] predators) {
		HashMap<Integer, List<Integer>> foods = new HashMap<Integer, List<Integer>>();
		List<List<Integer>> groups = new ArrayList<List<Integer>>();
		List<Integer> curGroup = new ArrayList<Integer>();
		for(int i = 0; i < predators.length; i++) {
			if(predators[i] == -1) { //top 
				curGroup.add(i);
			}else {
				List<Integer> curFoods = foods.getOrDefault(predators[i], new ArrayList<Integer>());
				curFoods.add(i);		
				foods.put(predators[i], curFoods);
			}				
		}
		
		System.out.println(foods);
		groups.add(curGroup);
		
		while(curGroup.size() != 0) {
			List<Integer> temp = new ArrayList<Integer>();
			for(int cur : curGroup) {
				temp.addAll(foods.getOrDefault(cur, new ArrayList<Integer>()));
			}
			if(temp.size() == 0) break;
			curGroup = temp;	
			System.out.println(curGroup);
			groups.add(curGroup);
		}
		return groups.size();
	}
	
    public static void main(String[] args) 
    { 
        int[] predators = {1,-1,3,-1,1,3,2,0};
        System.out.println(countGroups(predators)); 
    } 
}
