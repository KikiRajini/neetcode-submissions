class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxAr = 0 ;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        for(int i =0; i<=n; i++){
            while(!stack.isEmpty() && (i==n || heights[i]<heights[stack.peek()])){
                int h = heights[stack.pop()];
                int w = stack.isEmpty()? i : i - stack.peek() -1;
                maxAr = Math.max(maxAr,h*w);

            }
            stack.push(i);
        }

        return maxAr; 
    }
}
