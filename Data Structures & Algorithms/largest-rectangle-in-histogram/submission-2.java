class Solution {
       public int largestRectangleArea(int[] heights){
        int area = 0;
        int index = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i =0; i< heights.length; i++){
            index = i;
           while(!stack.isEmpty() && heights[i]< stack.peek()[1]){
                int[] top = stack.pop();
                area = Math.max(area,top[1]*(i-top[0]));
                index = top[0];
            }
            stack.push(new int[]{index, heights[i]});
        }
        for( int[] s : stack){
            area = Math.max(area, s[1] *(heights.length-s[0]));
        }
        return area;
}
}
