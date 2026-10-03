class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        //map for adjacency list:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //now i loop over ppid and pid:
        for (int i=0; i<ppid.size(); i++) {
            //grab the parent and child:
            int parent = ppid.get(i);
            int child = pid.get(i);

            //grab list for parent, if key does not exists then default to empty
            //arraylist
            List<Integer> childrens = map.getOrDefault(parent, new ArrayList<>());

            //now add child to list:
            childrens.add(child);

            //now update the map:
            map.put(parent, childrens);
        }

        //here i define output list:
        List<Integer> output = new ArrayList<>();

        //now perform dfs recursion starting from kill node itself:
        dfs(kill, map, output);

        //after performing the recursion we would have list of nodes killed:
        return output;
    }

    //here i write dfs recursion method:
    public void dfs (int node, HashMap<Integer, List<Integer>> map, List<Integer> output) {
        //first add the node to output:
        output.add(node);

        //now get list of neighbours:
        //writing getOrDefault is important, if a node does not have list things code will crash:
        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        //now loop over neighbours:
        for (int i=0; i<neighbours.size(); i++) {
            int currentNeighbour = neighbours.get(i);

            //perform dfs on currentNeighbour:
            dfs(currentNeighbour, map, output);
        }
    }
}

//so first i have to create an adjacency list for which i will need hashmap
//the hashmap will be of type Integer, and list of Integer
//to create adjacency list, i will loop over ppid and create the list:
//example: ppid -> list of children
// [
//     3 -> {1, 5},
//     0 -> {3},
//     5 -> {10},
// ]
//when i 0 points at something then that point is towards the root, so skip no need for adjacency list.
//after creating adjacency list i will define a list which will hold the integer values for output.
//then i will perfrom my dfs recursion starting from kill node itself.
//first add current node to output
//get list of neighbours
//loop over neighbours
//for each node perform dfs



