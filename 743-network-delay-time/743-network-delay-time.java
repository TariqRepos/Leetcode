// Dijkstra's Algorithm
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Adjacency list
        Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
        // Build the adjacency list
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(travelTime, dest));
        }
        
         // Visited list
        Set<Integer> visited = new HashSet<>();
        
        Queue<Pair<Integer, Integer>> minheap = new PriorityQueue<Pair<Integer,Integer>>
            ((a, b) -> a.getKey() - b.getKey());
        minheap.add(new Pair(0, k));
        
        int max_time = 0;
        while(!minheap.isEmpty()){
            Pair<Integer, Integer> node = minheap.remove();
            int time1 = node.getKey();
            int node1 = node.getValue();
            if(visited.contains(node1))
                continue;
            visited.add(node1);
            max_time = Math.max(max_time, time1);
            
            // BFS
            List<Pair<Integer, Integer>> neighbors = adj.get(node1);
            if(neighbors != null) {
                for(Pair<Integer, Integer> neighbor : neighbors){
                    int time2 = neighbor.getKey();
                    int node2 = neighbor.getValue();

                    if(!visited.contains(node2)){
                        minheap.add(new Pair(time1+time2, node2));
                    }
                }
            }
        }

        if(visited.size() == n)
            return max_time;
        return -1;
    }
}