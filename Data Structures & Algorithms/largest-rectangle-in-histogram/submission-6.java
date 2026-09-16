class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0; 
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<=n; i++){
            while(!stack.isEmpty()&& (i==n || heights[i]< heights[stack.peek()])){
                int h = heights[stack.pop()];
                int w = stack.isEmpty()? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h*w);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
