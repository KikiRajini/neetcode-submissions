class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length!= n-1){return false;}
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ; i< n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0]= true;
        int nodesVisited =0;

        while(!q.isEmpty()){
            int curr = q.poll();
            nodesVisited++;
            for(int node : adj.get(curr)){
                if(!visited[node]){
                q.add(node);
                visited[node]=true;
                }
            }
        }

        return n == nodesVisited;

    }
}
