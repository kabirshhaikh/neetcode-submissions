class Solution {
    public boolean isBipartite(int[][] graph) {
        //first i am gonna create a undirected graph using hashmap.
        //i will loop over graph index is key and value is graph[i]
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i=0; i<graph.length; i++) {
            int[] currList = graph[i];
            List<Integer> list = map.getOrDefault(i, new ArrayList<>());
            for (int j=0; j<currList.length; j++) {
                int currElement = currList[j];
                list.add(currElement);
            }

            map.put(i, list);
        }

        //after creating adjacency list:
        //i will loop over each index of graph and perform dfs from there:
        //i need a data type to track seen nodes and there colours.
        //so i can use int[] colours of length graph.length and fill it with -1.
        //-1 meaning NOT VISITED, 1 meaning RED and 2 MEANING GREEN:
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        for (int i=0; i<graph.length; i++) {
            //perform dfs only if current node is not visited:
            if (colors[i] == -1) {
                boolean dfsResult = dfs(i, map, colors, 1);
                if (!dfsResult) {
                    return false;
                }
            }
        }

        return true;
    }

    //here i write my dfs recursion helper function:
    public boolean dfs (int node, HashMap<Integer, List<Integer>> map, int[] colors, int parentNodeColor) {
        //base case 1:if parentNode color and current nodes color is same return false:
        if (colors[node] != -1 && colors[node] == parentNodeColor) {
            return false;
        }

        //base case 2: if current node is visited and its color is different from parent then return true:
        if (colors[node] != -1 && colors[node] != parentNodeColor) {
            return true;
        }

        //otherwise mark current node visited by assigning opposite color
        int currentNodeColor = -1;

        if (parentNodeColor == 1) {
            currentNodeColor = 2;
        }
        else {
            currentNodeColor = 1;
        }

        colors[node] = currentNodeColor;

        //get list of neighbours:
        List<Integer> neighbours = map.getOrDefault(node, new ArrayList<>());

        //loop over neighbour
        //-> if neighbour returns false return immediately
        for (int i=0; i<neighbours.size(); i++) {
            int currentNeighbour = neighbours.get(i);
            boolean result = dfs(currentNeighbour, map, colors, currentNodeColor);
            if (!result) {
                return false;
            }
        }

        //otherwise return true:
        return true;
    }
}


// {
//     0 -> {1},
//     1 -> {0,2}
//     2 -> {1}
// }

// 0 gets red goes to 1
// 1 gets red goes to 0 just came from there so skip, goes to 2.
// 2 gets red goes to 1