class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> warm = new Stack<>();
        int[] result = new int[temperatures.length];
        // warm.push(0);
        int i =0;
        int j =i+1;
        while(j>i && i< temperatures.length && j< temperatures.length){
            if(temperatures[j]>temperatures[i] && i<temperatures.length){
                result[i]= j-i;
                i++;
                j=i+1;
            }else if(temperatures[j]<=temperatures[i] && j<temperatures.length-1){
                j++;
            }else{
                result[i]=0;
                i++;
                j = i+1;
            }

        }
        return result;

}}
