class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){return findMedianSortedArrays(nums2,nums1);}
    //short followed by long
    int m = nums1.length; int n = nums2.length;
    int halfLen = (m+n+1)/2; //mid of full array; +1 to make sure if elements are odd, mid is always in left space
    int left =0; int right = m; //the size of the shorter array
    //left (Minimum Count): The minimum number of elements from nums1 that could possibly belong to the Left Partition (starts at 0). right (Maximum Count): The maximum number of elements from nums1 that could possibly belong to the Left Partition (starts at m, which is nums1.length).

    //we need to find the left half which is partly in nums1 and nums 2 with i and j
    //i and j are count of elements from num1 and num2 to go to combined left paritition

    while(left<=right){
        int i = left + (right-left)/2; //binary search starts by testing a cut right in the middle of nums1.
        int j = halfLen - i;//Takes whatever remaining elements are needed from nums2 to ensure the left partition holds exactly halfLen elements.

        //l1, l2, r1, and r2 represent the four elements directly surrounding the cuts made in the two arrays.

        int l1 = i==0 ? Integer.MIN_VALUE : nums1[i-1];//The largest element on the left side of nums1.
        int l2 =  j==0 ? Integer.MIN_VALUE : nums2[j-1];//The largest element on the left side of nums2.
        int r1 =  i==m ? Integer.MAX_VALUE  : nums1[i];//The smallest element on the right side of nums1.
        int r2 =  j==n ? Integer.MAX_VALUE  : nums2[j];//The smallest element on the right side of nums2.


//We already know l1≤r1 and l2≤r2.
//So you only need to check the cross-conditions:
//l1≤r2: The biggest value from nums1's left part is ≤ the smallest value in nums2's right part.
//l2≤r1: The biggest value from nums2's left part is ≤ the smallest value in nums1's right part.
//If both conditions hold true, the partition is valid, and:
//The maximum of left elements is max(l1,l2).
//The minimum of right elements is min(r1,r2).

        if(l1<=r2 && l2<=r1){
            if((m+n)%2==0){//if length is even, add largest left and smallest right and divide by 2
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }else{ //if length is odd, we know we moved 1 element to left, so the largest value in left side is the median
                return Math.max(l1,l2);
            }
        }
        else if(l1>r2){ //The largest value on the left side of nums1 (l1) is bigger than the smallest value on the right side of nums2 (r2). l1 is too big! We must take fewer elements from nums1.
//right = mid-1
            right = i-1;//Setting right = i - 1 doesn't just step back by 1 element—it halves the remaining search space.

        }else{ //The largest value on the left side of nums2 (l2) is bigger than the smallest value on the right side of nums1 (r1). r1 is too small (or l2 is too big). We need to take more elements from nums1 so that r1 shifts right and gets larger while j shrinks and l2 gets smaller.
        //left = mid+1
            left = i+1;
        }

    }
    return 0.0;
    }
}