class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }
        
        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        // Queue<Integer> heap = new PriorityQueue<>();
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
          heap.add(n);
          if (heap.size() > k) heap.remove();    
        }
        System.out.println(heap);

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        int i = 0;
        while(!heap.isEmpty()){
            top[i++] = heap.remove();
        }
        return top;
    }
}