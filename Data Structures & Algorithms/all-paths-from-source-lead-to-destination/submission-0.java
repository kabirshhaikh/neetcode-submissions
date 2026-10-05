class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // create adjacency list:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // loop over edges to create al:
        for (int i = 0; i < edges.length; i++) {
            int sourceNode = edges[i][0];
            int destinationNode = edges[i][1];

            // get list of neighbours for sourceNode, if empty get empty array List:
            List<Integer> neighbours = map.getOrDefault(sourceNode, new ArrayList<>());

            // add destinationNode to neighbours:
            neighbours.add(destinationNode);

            // update map:
            map.put(sourceNode, neighbours);
        }

        // now i need two hashsets to track globally visited and path visited nodes:
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> pathVisited = new HashSet<>();

        // now i call my dfs helper recursion function:
        boolean output = dfs(source, destination, map, visited, pathVisited);

        // return output:
        return output;
    }

    // here i write my helper recursion function:
    public boolean dfs(int source, int destination, HashMap<Integer, List<Integer>> map,
        HashSet<Integer> visited, HashSet<Integer> pathVisited) {
        // first base case:
        // if a nodes is detected in pathVisited then that means a cycle has been found so return
        // false:
        if (pathVisited.contains(source)) {
            return false;
        }

        // second base case:
        // if a node is seen in globally visited then return true, meaning it has proven its source
        // of truth:
        if (visited.contains(source)) {
            return true; // no need to explore further
        }

        // now grab the list of neighbours:
        List<Integer> neighbours = map.getOrDefault(source, new ArrayList<>());

        // third base case:
        // if neighbours is empty and source == destination return true else false:
        if (neighbours.isEmpty()) {
            if (source == destination) {
                return true;
            } else {
                return false;
            }
        }

        // now mark current node as visited:
        visited.add(source);

        // now mark current visited in this path for backtracking:
        pathVisited.add(source);

        // loop over neighbours:
        for (int i = 0; i < neighbours.size(); i++) {
            int currentNeighbour = neighbours.get(i);
            boolean dfsResult = dfs(currentNeighbour, destination, map, visited, pathVisited);
            if (!dfsResult) {
                return false; // early exit
            }
        }

        // now unmark current node:
        pathVisited.remove(source);

        // now return true to calling recursion functions in stack:
        return true;
    }
}

// so first create adjacency list:
// for that i need hashmap of Integer and list of integer as value.
// loop over edges to create al.
// then perform dfs starting at source node.
// so i need two hashsets one globally visited set and one path visited set.
// pass that to dfs

// dfs helper recursion function of return type boolean.
// get the neighbour list for current node
// first base case:
// if current node already present in pathVisited set then return false.
// second base case:
// if current node does not have any neighbours and current node != destination, return false.
// base case three:
// if current node == destination and does not have any neighbours then we found path and return
// true. mark current node as globally visited add current node in pathVisited. run for loop on
// neighours: for each neighbour run dfs after for loop is over remove current node from pathVisited
// return true to calling functions.

// [
//     0 -> {1, 3}
//     1 -> {2}
//     2 -> {1}
// ]

// 0 -> 1 -> 2 -> 1 already visited return false
// 0 -> 3 -> return true.
