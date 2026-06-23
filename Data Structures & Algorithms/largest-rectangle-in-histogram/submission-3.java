class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxAr = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i =0; i<=n; i++){//
            while(!stack.isEmpty() && (i==n || heights[i]<= heights[stack.peek()])){//
                int h = heights[stack.pop()];
                int w = stack.isEmpty()? i : i - stack.peek() -1;
                //current index - last index in stack - 1 (extra one removal)
                maxAr = Math.max(maxAr, h * w);
            }
            stack.push(i);
        }   
        return maxAr;     
    }
}
