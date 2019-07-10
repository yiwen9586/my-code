import java.util.*;

public class LibrariesToBuild {
	 public static int solution(String modulesToBuild, HashMap<String, List<String>> dependencies){
        HashSet<String> visited = new HashSet<String>();
        dfs(modulesToBuild, dependencies, visited);
        System.out.println(visited);
        return visited.size();
	 }
	 
	 public static void dfs(String module, HashMap<String, List<String>> dependencies, HashSet<String> visited) {
		 if(visited.contains(module)) return;
		 if(dependencies.containsKey(module)) {
			 for(String pre: dependencies.get(module))
				 dfs(pre, dependencies, visited);
			 visited.add(module);
		 }else {
			 visited.add(module);
			 return;
		 }
	 }
	 
	 public static void main(String[] args) {
		HashMap<String, List<String>> dependencies = new HashMap<String, List<String>>();
		List<String> s1 = new LinkedList<String>();
		s1.add("apache-commons");
		s1.add("guava");
		s1.add("thrift");
		dependencies.put("factual-commons", s1);
		s1 = new LinkedList<String>();
		s1.add("apache-commons");
		s1.add("hadoop");
		dependencies.put("map-reduce", s1);
		s1 = new LinkedList<String>();
		s1.add("factual-commons");
		s1.add("map-reduce");
		dependencies.put("place-attach", s1);
		s1 = new LinkedList<String>();
		s1.add("hadoop");
		s1.add("apache-commons");
		dependencies.put("hive", s1);
		s1 = new LinkedList<String>();
		s1.add("hive");
		s1.add("factual-commons");
		dependencies.put("hive-querier", s1);
		
		String modulesToBuild = "place-attach";
		System.out.println(solution(modulesToBuild, dependencies));
     }
}
