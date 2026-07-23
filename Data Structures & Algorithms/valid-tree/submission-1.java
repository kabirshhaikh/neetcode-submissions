class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //here i build the adjacency list:
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

        //the list looks like this:
        // [
        //     0 -> {1, 2, 3}
        //     1 -> {0, 4}
        //     2 -> {0}
        //     3 -> {0}
        //     4 -> {1}
        // ]

        //then here i build visited set to hold visited nodes:
        HashSet<Integer> visited = new HashSet<>();

        //i add 0 to visited:
        visited.add(0);

        //here i call dfs recursion method, where i pass current node, -1 as parent,
        //map and visited set:
        boolean ans = dfs(0, -1, map, visited);

        //if ans is false and set size equals n then return true else false:
        return !ans && visited.size() == n;
    }

    public boolean dfs(
        int node, int parent, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
        //here i grab the current nodes list from map:
        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        //i loop over it:
        for (int i = 0; i < neighbours.size(); i++) {
            //here i get the current neighbour/element from list:
            int currentNeighbour = neighbours.get(i);

            //here i check if current element == parent then skip
            //we just came from parent thats why:
            if (currentNeighbour == parent) {
                continue;
            }

            //if set contains current element then return true
            //cycle detected:
            if (visited.contains(currentNeighbour)) {
                return true;
            }

            //if not in set then add:
            visited.add(currentNeighbour);

            //then i recurse on current element, pass current node as parent
            //the map and visited set:
            //if the visited.contains condition is true it returns true
            //to its calling function in the stack:
            if (dfs(currentNeighbour, node, map, visited)) {
                return true;
            }
        }

        //if cycle not found then for loop exits and returns false:
        return false;
    }
}
