class Solution {
    public boolean validTree(int n, int[][] edges) {
 HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] curr = edges[i];
            int node1 = curr[0];
            int node2 = curr[1];

            List<Integer> node1List = map.getOrDefault(node1, new ArrayList<>());
            List<Integer> node2List = map.getOrDefault(node2, new ArrayList<>());

            node1List.add(node2);
            node2List.add(node1);

            map.put(node1, node1List);
            map.put(node2, node2List);
        }

        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        boolean ans = dfs(0, -1, map, visited);

        return !ans && visited.size() == n;
    }

     public boolean dfs(int node, int parent, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        for (int i = 0; i < neighbours.size(); i++) {
            int currentNeighbour = neighbours.get(i);

            if (currentNeighbour == parent) {
                continue;
            }

            if (visited.contains(currentNeighbour)) {
                return true;
            }

            visited.add(currentNeighbour);

            if (dfs(currentNeighbour, node, map, visited)) {
                return true;
            }
        }

        return false;
    }
}
