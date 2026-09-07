
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // 2. Create a Min-Heap based on frequency
        // Elements with the lowest frequency will be at the top of the queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)
        );

        // 3. Keep only the top k elements in the heap
        for (int num : freq.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll(); // Remove the element with the lowest frequency
            }
        }

        // 4. Extract the results
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        
        return result;
    }
}