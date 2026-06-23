class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map to store the frequency of each number
        Map<Integer, Integer> count = new HashMap<>();
        
        // Calculate the frequency of each number
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Map to store lists of numbers by their frequencies
        NavigableMap<Integer, List<Integer>> freqMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            freqMap.computeIfAbsent(freq, x -> new ArrayList<>()).add(num);
        }

        // Prepare the result array
        int[] result = new int[k];
        int index = 0;

        // Collect the top k frequent elements
        for (Map.Entry<Integer, List<Integer>> entry : freqMap.entrySet()) {
            List<Integer> numsWithSameFreq = entry.getValue();
            for (int num : numsWithSameFreq) {
                if (index < k) {
                    result[index++] = num;
                }
                if (index == k) {
                    return result;
                }
            }
        }

        return result; // If fewer than k elements, return what we have
    }
}