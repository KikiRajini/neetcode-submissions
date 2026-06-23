class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequency = new HashMap<>();
        for(int num : nums){
            frequency.putIfAbsent(num,0);
            frequency.put(num,frequency.get(num)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->frequency.get(a)-frequency.get(b));
        //Not using treemap as nums with same frequency will be overwitten
        //maintains order : small to big values 
        for(int key: frequency.keySet()){
            heap.add(key);
            if(heap.size()>k){
                heap.poll(); //ensure heap size is only k and not nums.size()
            }
        }
        
        int[] res = new int[k];
        for(int i=k-1; i>=0; i--){
            res[i] = heap.poll();
        }

        return res;

    }
}
