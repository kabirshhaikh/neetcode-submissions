class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //edge case:
        if (n == 1) return Collections.singletonList(0);

        //so here i first make the adjacency lit of edges:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //here i define a variable called remaining which will help us break out of while loop. Initally i set this variable to n and inside while loop each time we capture size i subtract that size from the remaining variable:
        int remaining = n;

        for (int i=0; i<edges.length; i++) {
            int[] curr = edges[i];
            int node1 = curr[0];
            int node2= curr[1];

            List<Integer> node1List = map.getOrDefault(node1, new ArrayList<>());
            List<Integer> node2List = map.getOrDefault(node2, new ArrayList<>());

            node1List.add(node2);
            node2List.add(node1);

            map.put(node1, node1List);
            map.put(node2, node2List);
        }

        //now i create an array called degrees of size n and for each element/node at that place i store the neighbour count:
        int[] degrees = new int[n];

        for (int i=0; i<degrees.length; i++) {
            List<Integer> list = map.getOrDefault(i, new ArrayList<>());
            degrees[i] = list.size();
        }

        //now a define a queue for bfs which will hold initial seed meaning all the nodes which has degree 1:
        Queue<Integer> q = new ArrayDeque<>();

        for (int i=0; i<degrees.length; i++) {
            if (degrees[i] == 1) {
                q.offer(i);
            }
        }

        //now i run a while loop until remaining has more than 2 nodes:
        while (remaining > 2) {
            int size = q.size();

            remaining = remaining - size;

            for (int i=0; i<size; i++) {
                int poppedNode = q.poll();

                //here i get neighbour list of poppedNode:
                List<Integer> neighbours = map.getOrDefault(poppedNode, new ArrayList<>());

                for (int j=0; j<neighbours.size(); j++) {
                    degrees[neighbours.get(j)] = degrees[neighbours.get(j)] - 1;
                    if (degrees[neighbours.get(j)] == 1) {
                        q.offer(neighbours.get(j));
                    } 
                }
            }
        }

        List<Integer> output = new ArrayList<>();
        while (!q.isEmpty()) {
            output.add(q.poll());
        }

        return output;
    }
}

// n = 5;

// [
//     0 -> {1},
//     1 -> {0,3,4},
//     2 -> {3},
//     3 -> {1, 2},
//     4 -> {1}
// ]

// so i maintain a variable called remaining = n initally.

// i create and array of size n, in which for the ith element meaning ith node i at that position i store the degree of it.

// then i add all the nodes from hashmap who have 1 neighbour only to the queue.

// then in the while loop i capture size of the q.

// then i subtrqact that size from remaining, if remaining <= 2 then i break out of it.

// otherwise i run a loop on size, pop the element get its current degree from array for that node, -1 to it, if the degree becomes 1 then i add that node into q.


// in the end after while loop ends i run a loop on q and add the remaining elements into an output list