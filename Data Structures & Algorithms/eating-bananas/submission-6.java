class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles); //[1,2,3,4]
        int k =piles[piles.length -1]; 
        // max:4 -> piles.length; min:1 -> 0
int hours=0;
        int start = 1; int end = piles[piles.length -1];
        int mid =-1;
        
        while(start<=end){
            mid = (start+end)/2;
            hours=0;
            for(int p :piles){
                hours = hours + (int)Math.ceil((double) p/mid);
            }
            if(hours<=h){
                k = Math.min(k, mid);//2
                end = mid-1;
            }else{
                start=mid+1;
            }

        }
        return k;

    }
}
