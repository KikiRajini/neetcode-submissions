class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> count = new HashMap<>();
        for(int num: nums){
            // System.out.println(num);
            if (count.get(num)!=null){
                count.put(num,count.get(num)+1);
            } else{
                count.put(num,1);
            }
        }
         
        for(int i=0;i<k;i++){
            int maxValueInMap = (Collections.max(count.values()));
            System.out.println(maxValueInMap);
            for(int num: count.keySet()){
                if (count.get(num)==maxValueInMap){
                    result[i]=num;
                    count.put(num,0);
                    System.out.println(count);
                    break;
                }
            }

        }

        return result;
    }
}
