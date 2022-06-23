class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    HashMap<Integer, Boolean> visited = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1)
            return true;
        
        for(int i=0; i<prerequisites.length; i++){
            graph.putIfAbsent(prerequisites[i][1], new ArrayList<Integer>());
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for (int i = 0; i < numCourses; i++)
            if (dfs(i))
                return false;
        
        return visited.size() == numCourses;
    }
    
    public boolean dfs(int num){
        if(visited.containsKey(num))
            return visited.get(num);
        
        visited.put(num, true);
        
        List<Integer> neighbors = graph.get(num);
        if(neighbors != null){
            for(Integer neighbor : neighbors){
                if(dfs(neighbor))
                    return true;
            }
        }
        visited.put(num, false);
        
        return false;
    }
}