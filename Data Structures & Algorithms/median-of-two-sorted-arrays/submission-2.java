class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){return findMedianSortedArrays(nums2,nums1);}
    
    int m = nums1.length; int n = nums2.length;
    int halfLen = (m+n+1)/2;
    int left =0; int right = m;
    while(left<=right){
        int i = left + (right-left)/2;
        int j = halfLen - i;

        int l1 = i==0 ? Integer.MIN_VALUE : nums1[i-1];
        int l2 =  j==0 ? Integer.MIN_VALUE : nums2[j-1];
        int r1 =  i==m ? Integer.MAX_VALUE  : nums1[i];
        int r2 =  j==n ? Integer.MAX_VALUE  : nums2[j];

        if(l1<=r2 && l2<=r1){
            if((m+n)%2==0){
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }else{
            return Math.max(l1,l2);
            }
        }
        else if(l1>r2){
            right = i-1;
        }else{
            left = i+1;
        }

    }
    return 0.0;
    }
}