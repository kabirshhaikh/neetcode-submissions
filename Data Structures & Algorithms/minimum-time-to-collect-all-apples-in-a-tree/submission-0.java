class Solution {
    int secondsCounter = 0;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //first i will create an adjacency list:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i=0; i<edges.length; i++) {
            int[] curr = edges[i];
            int first = curr[0];
            int second = curr[1];
            List<Integer> firstList = map.getOrDefault(first, new ArrayList<>());
            List<Integer> secondList = map.getOrDefault(second, new ArrayList<>());
            firstList.add(second);
            secondList.add(first);
            map.put(first, firstList);
            map.put(second, secondList);
        }

        dfs(0, map, hasApple, -1); //-1 is the parent for 0th node:

        return secondsCounter;
    }

    //here i will write my dfs recursion function of type boolean:
    public boolean dfs (int node, HashMap<Integer, List<Integer>> map, List<Boolean> hasApple, int parent) {
        //boolean variale to track if any neighbour returned true where they found apples:
        boolean appleFound = false;

        //get list of neighbours:
        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        //now loop over neighbours:
        for (int i=0; i<neighbours.size(); i++) {
            int currNeighbour = neighbours.get(i);

            //if currNeighbour == parent then skip, dont revisit:
            if (currNeighbour == parent) {
                continue;
            }

            boolean dfsResult = dfs(currNeighbour, map, hasApple, node); //pass the current node as parent
            //if a neigbours returns true meaning somewhere in subtree of it an apple was found:
            //so increment the variable by 2:
            if (dfsResult) {
                appleFound = true;
                secondsCounter += 2;
            }
        }

        //if no apples found by any neighbours AND if hasApple.get(node), the return true:
        if (hasApple.get(node) == true) {
            return true;
        }

        //return true if hasApple is false but appleFound during dfs traversal by a neighbour is true:
        if (appleFound && !hasApple.get(node)) {
            return true;
        }

        //else return false:
        return false;

        //i could have just written: return hasApple.get(node) || appleFound
        //meaning if either is true then return true else false.
    }
}

//Adjacency list:
// [
//     0 -> {1,2},
//     1 -> {0, 4, 5},
//     2 -> {0, 3, 6},
//     3 -> {2}
//     4 -> {1},
//     5 -> {1},
//     6 -> {2}
// ]