class Solution {
    // Hashmap
    // Maxheap
    // queue
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<Pair<Integer, Integer>> deque = new ArrayDeque();
        
        for(int i=0; i<tasks.length; i++){
            map.putIfAbsent(tasks[i], 0);
            map.put(tasks[i], map.get(tasks[i]) + 1);
        }
        
        maxheap.addAll(map.values());
        int time = 0;
        while(!maxheap.isEmpty() || !deque.isEmpty()){
            time++;
            if(!maxheap.isEmpty()){
                int task = maxheap.remove() - 1;
                if(task > 0)
                    deque.add(new Pair(task, time+n));
            }
            
            if(!deque.isEmpty() && deque.peekFirst().getValue() <= time){
                int task = deque.pollFirst().getKey();
                maxheap.add(task);
            }
        }
            
        return time;
    }
}