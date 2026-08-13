class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int components = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i< n ; i++){
            if(!visited[i]){
                components++;
                bfs(i, visited,adj);
            }
        }

        return components;

    }


    private void bfs(int startingPoint, boolean[] visited, List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(startingPoint);
        while(!q.isEmpty()){
            int curr = q.poll();

            for(int connected : adj.get(curr)){
                if(!visited[connected]){
                visited[connected]=true;
                q.add(connected);
                }
            }
        }
    }
}
