class Solution {
    public boolean checkBipartite(int startNode , int[][] graph , int[] color)
    {
        color[startNode] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        while(!queue.isEmpty())
        {
            Integer currNode = queue.remove();
            // Traverse adj-nodes & color the nodes
            for(Integer adjNode : graph[currNode])
            {
                if(color[adjNode] == 0)
                {
                    color[adjNode] = color[currNode] == 1 ? 2 : 1;
                    queue.add(adjNode);
                }
                else if(color[adjNode] == color[currNode])
                return false;
            }

        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
        // Disconnected-graph [Multiple-components]
        for(int i = 0 ; i < V ; i++) 
        {
            if(color[i] == 0)
            {
                if(!checkBipartite(i , graph , color))
                return false;
            }
        }
        return true;
    }
}
// TC : V + (V + 2E) => O(V + 2E)
// SC : V[color-array] + V [Queue] => O(2V)

