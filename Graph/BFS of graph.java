class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty())
        {
            Integer currNode = queue.remove();
            bfs.add(currNode);
            // Traverse adj-nodes
            for(Integer adjNode : adj.get(currNode))
            {
                if(!visited[adjNode])
                {
                    queue.add(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
        return bfs;
    }
}
// TC : O(V + 2E)
// SC : V [Visited Array] + V [Queue] => O(2V)
