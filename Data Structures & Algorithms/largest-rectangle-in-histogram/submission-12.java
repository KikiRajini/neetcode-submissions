class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea =0;

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i =0; i<=heights.length;i++){
            int currHeight = i==heights.length? 0 : heights[i];
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int h = heights[stack.pop()];
                int leftBoundary = stack.isEmpty()? -1 : stack.peek();
                int rightBoundary = i;
                int w = rightBoundary - leftBoundary -1;
                int area = h*w;
                maxArea = Math.max(maxArea,area);
            }


            stack.push(i);
        }
       return maxArea;
    }
    
}
