class Solution {
    public int largestRectangleArea(int[] heights) {
    int maxArea =0;

    Stack<int[]> track = new Stack<>();//postion,value
    int index =0;
    for(int i =0; i<heights.length;i++){
        index = i;
        while(!track.isEmpty() && heights[i]<=track.peek()[1]) {
            int[] peek = track.pop();
            index = peek[0];
            int value = peek[1];
            if (value * (i - index) > maxArea) maxArea = value * (i - index);

        }

        track.push(new int[]{index, heights[i]});


    }

    for(int[] t : track){
        int area = t[1]*(heights.length-t[0]);
        if(area>maxArea) maxArea= area;
    }

    return maxArea;
    }
}
