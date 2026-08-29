class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //so here i first define a hashmap to hold adjacency list for my undirected graph where key is integer and value is list of integers meaning its neighbours:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //the idea is now i will loop over edges, create adjacency list for each ith element and then run fresh dfs from there on the graph to see if any cycle is detected.
        //if my dfs returns true then i return that ith element of edges:
        for (int i=0; i<edges.length; i++) {
            int[] curr = edges[i];
            int a = curr[0];
            int b = curr[1];

            List<Integer> aList = map.getOrDefault(a, new ArrayList<>());
            aList.add(b);
            map.put(a, aList);

            List<Integer> bList = map.getOrDefault(b, new ArrayList<>());
            bList.add(a);
            map.put(b, bList);

            //now after adding the above edges into the hashmap i then run a fresh dfs on graph starting from a:
            //if the dfs function returns true then i return int[] curr array:
            //here i pass -1 as the parent in the begining for node a:
            //i also need a fresh hashset to detect cycle:
            HashSet<Integer> visited = new HashSet<>();
            boolean cycleDetected = dfs(-1, a, visited, map);

            if (cycleDetected) {
                return curr;
            }
        }

        //in the end if no cycle dected reutrn -1,-1:
        return new int[] {-1, -1};
    }

    //now here i write my recursion dfs function of return type boolean:
    public boolean dfs (int parent, int node, HashSet<Integer> visited, HashMap<Integer, List<Integer>> map) {
        //first i mark the node as visited:
        visited.add(node);

        //then i get list of neighbours:
        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        //now i loop over neighbours:
        for (int i=0; i<neighbours.size(); i++) {
            int currentNeighbour = neighbours.get(i);

            //now first base check: if currentNeighbour == parent then skip:
            if (currentNeighbour == parent) {
                continue;
            }

            //if currentNeighbour is already visited then return true:
            if (visited.contains(currentNeighbour)) {
                return true;
            }

            //otherwise perform recursion:
            if (dfs(node, currentNeighbour, visited, map)) {
                return true;
            }
        }

        //otherwise return false:
        return false;
    }
}

// the problem requires dfs.

// i define hashmap to hold adjacency list
// where key is node and value is list of integers meaning its neighbours.

// then i build adjacency list step by step by looping over edges array.
// lets say i grab 0th element [1,2]
// i create adjacency list record in hashmap:
// [
//     1 -> {2}
//     2 -> {1}
// ]

// then i run a dfs to detect cycle from node 1.
// dfs will recieve -1 as parent, the node, and a hashset of integers to track visited nodes.

// so lets say dfs at that point will look like this:
// base case check if this my node already visited? then return true meaning cycle detected.
// second base case if this my parent then return false meaning no cycle detected.
// otherwise get list of neighbours for this node and then loop on it.
// after the loop ends i return false meaning no loop found at this current node.


// lets say when we enter dfs and it becomes true then i immediately return true go back to for loop of edges and then i simply return that ith element of edge because dfs returned true saying hey a cycle just got detected.
