class Solution {
    int[] manager;
    int[] teamSize;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        manager = new int[n+1];
        teamSize = new int[n+1];

        for(int i = 1; i<=n; i++){
            manager[i] = i;
            teamSize[i] = 1;
        }

        for(int[] edge : edges){
            if(!union(edge[0],edge[1])){
                return edge;
            }
        }

        return new int[0];
    }

    private int find(int a){
        if(manager[a]!=a){
            manager[a] = find(manager[a]);
        }
        return manager[a];
    }


    private boolean union(int a, int b){
        int bossA = find(a);
        int bossB = find(b);

        if(bossA==bossB){
            return false;
        }

        if(teamSize[a]>teamSize[b]){
            manager[bossB] = bossA;

        }else if (teamSize[b]>teamSize[a]){
            manager[bossA] = bossB;
   
        }else{
            manager[bossB] = bossA;
            teamSize[bossA]++;
        }

        return true;
    }
}
