class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        //to track number of prerequisites for a course
        int preReq[] = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int preRequisite = prerequisite[1];
            adj.get(preRequisite).add(course);
            preReq[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
         for(int i = 0; i< numCourses; i++){
            //Doesn't have prereq, so can be taken first
            if(preReq[i]==0){
                q.add(i);
            }
        }

        int courseTaken =0;
        int[] coursesTaken = new int[numCourses];
        
        while(!q.isEmpty()){
            int currCourse = q.poll();
            coursesTaken[courseTaken]= currCourse;
            courseTaken++;
            

            for (int course : adj.get(currCourse)){
                preReq[course]--;
                if(preReq[course]==0){q.add(course);}
            }

        }

        return courseTaken == numCourses ? coursesTaken : new int[0];

    }
}
