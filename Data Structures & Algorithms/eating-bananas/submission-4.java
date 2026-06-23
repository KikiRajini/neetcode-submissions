class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);//3,6,7,11
        int kmin = 1;//1
        int kmax = piles[piles.length -1];//11
        int result =-1;
        while(kmax>=kmin){
            int mid = (kmax+kmin)/2; //6
            int time =0;
            
            for(int i: piles){
                time += (i+mid-1)/mid; //ceil
            }
            if(time<=h){
                result = mid;
                kmax = mid-1;}
            else if(time<h){result = mid;kmax = mid-1;}
            else{
                kmin = mid+1;
            }
            
        }
        return result;
    }
}
