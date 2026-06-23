class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task: tasks){
            count[task-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int c: count){
            if(c>0){
                pq.offer(c);
            }
        }

        int time =0;
        Queue<int[]> q = new ArrayDeque<>();
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;


 if (pq.isEmpty()) {
                time = q.peek()[1];}
                else{
            int c = pq.poll()-1;
            if(c>0){q.add(new int[]{c,time+n});}}

            if(!q.isEmpty() && q.peek()[1]==time){pq.add(q.poll()[0]);}
        }

        return time;
    }
}
