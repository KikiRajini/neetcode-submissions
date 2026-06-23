class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        //num, count
        Map<Integer,List<Integer>> reverseCount = new TreeMap<>(Comparator.reverseOrder());
       //count, list of nums having the same count
       int[] result = new int[k];
        for(int i: nums){
            count.putIfAbsent(i,0);
            count.put(i,count.get(i)+1);
        }
        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            if(reverseCount.containsKey(entry.getValue())){
                List<Integer> arr = reverseCount.get(entry.getValue());
                arr.add(entry.getKey());
            }else{
                reverseCount.put(entry.getValue(), new ArrayList<>(Arrays.asList(entry.getKey())));
            }
        }

        int c =k;
        int postn =k;
       
        for(int key: reverseCount.keySet()){
            if(c > 0){
                int l = (reverseCount.get(key).size() > c) ? c : reverseCount.get(key).size();
                    for(int j =0; j<l ; j++){
                        result[k-postn] = (reverseCount.get(key).get(j));
                        postn--;
                    }
                    c = c - reverseCount.get(key).size();
            
            }
        }
        return result;
        }
    
}
