class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Here i define the hashmap to store directed adjacency list:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //here i will loop over prerequisites to create list:
        for (int i=0; i<prerequisites.length; i++) {
            int[] curr = prerequisites[i];
            List<Integer> list = map.getOrDefault(curr[1], new ArrayList<>());
            list.add(curr[0]);
            map.put(curr[1], list);
        }

        //i will need two sets, one to record global visited nodes
        //second to backtrack a path:
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> path = new HashSet<>();

        //here i loop over the courses to perform dfs from every node
        //not just from 0, if the graph is disconnected then we wont be able to 
        //truly find the cycle:
        for (int i=0; i<numCourses; i++) {
            //if current course is not visited already:
            if (!visited.contains(i)) {
                if (dfs(i, map, visited, path)) {
                    return false;
                }
            }
        }

        return true;
    }

    // numCourses = 5
    // prerequisites = [[1,0],[2,0],[3,1],[3,2],[4,3]]

// [
//     0 -> {1, 2},
//     1 -> {3},
//     2 -> {3},
//     3 -> {4},
// ]

//dfs algo with backtracking:
// -> get the list
// -> is node part of path: if yes then return true.
// -> is node part of visited: if yes then return false;
// -> add node to path:
// -> add node to visited:
// loop on list:
// get current member:
// dfs on that number:
// loop gets over
// -> remove the node from path

    public boolean dfs(int node, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited, HashSet<Integer> path) {
        List<Integer> list = map.getOrDefault(node, new ArrayList<>());
        
        //first base case:
        if (path.contains(node)) {
            return true; //meaning cycle detected,
        }

        //second base case:
        //to avoid recursing on globally visited node:
        if (visited.contains(node)) {
            return false; //meaning we have already visited this node, no need to traverse again
        }

        //i add node to path and visited:
        visited.add(node);
        path.add(node);

        for (int i=0; i<list.size(); i++) {
            int neighbour = list.get(i);

            //if dfs returns true then early exit and break out of the for loop:
            if (dfs(neighbour, map, visited, path)) {
                return true;
            }
        }

        //now after for loop is over, i remove the node from path because backtracking for
        //this node is done:
        path.remove(node);

        return false;
    }
}
