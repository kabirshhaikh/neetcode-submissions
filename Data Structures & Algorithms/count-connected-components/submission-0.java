class Solution {
    public int countComponents(int n, int[][] edges) {
        //adjacency List:
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] curr = edges[i];
            int node1 = curr[0];
            int node2 = curr[1];

            List<Integer> nodeList1 = map.getOrDefault(node1, new ArrayList<>());
            List<Integer> nodeList2 = map.getOrDefault(node2, new ArrayList<>());

            nodeList1.add(node2);
            nodeList2.add(node1);

            map.put(node1, nodeList1);
            map.put(node2, nodeList2);
        }

        //set of visited nodes:
        HashSet<Integer> visited = new HashSet<>();
        int output = 0;

        //now i loop over n, for each n i check if its not visited,
        //if not then mark it visited and dfs on it:
        //in dfs i get its neighbour list, do the same check again,
        //if not visited mark visited and go all the way in
        //once done, the dfs function just returns back to its calling function
        //and then for each not visited node after dfs i increment output:
        for (int i = 0; i < n; i++) {
            int currentNode = i;
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                dfs(currentNode, map, visited);
                output++;
            }
        }

        return output;
    }

    public void dfs(int node, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        for (int i = 0; i < neighbours.size(); i++) {
            int currentNeighbour = neighbours.get(i);
            if (!visited.contains(currentNeighbour)) {
                visited.add(currentNeighbour);
                dfs(currentNeighbour, map, visited);
            }
        }
    }
}
