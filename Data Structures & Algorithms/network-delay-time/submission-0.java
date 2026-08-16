class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //first i define a hashmap which will integer for node and value will be list of integer
        //where 0th index is cost and 1st index is node itself: this is how the structure for our
        //adjacency list is going to be:
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        //now i loop over times 2d array to create the adjacency list:
        for (int i = 0; i < times.length; i++) {
            int[] curr = times[i];
            int source = curr[0];
            int destination = curr[1];
            int cost = curr[2];

            List<int[]> sourceList = map.getOrDefault(source, new ArrayList<>());
            sourceList.add(new int[] {cost, destination});
            map.put(source, sourceList);
        }

        //now i define an array which will hold minimum distance cost for each node, initially i
        //set it to Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; //here i set dist[k] to 0 because starting node should have cost of 0.

        //now i define the priority queue which will hold int[] where 0th index is cost and 1st
        //index is node. i will sort it based on cost.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        //now i add the entry for the ktth entry in the pq:
        pq.offer(new int[] {0, k});

        //now i run a while loop until pq is not empty:
        while (!pq.isEmpty()) {
            // now here i pop the current entry:
            int[] popped = pq.poll();
            int cost = popped[0];
            int node = popped[1];

            //if the cost is greater than dist[node] then continue stale entry, we want to process
            //the onces which have low cost for a node when comparing in dist array:
            //if the cost if greater than dist[node] then continue no need to process else keep
            //processing:
            if (cost > dist[node]) {
                continue;
            }

            List<int[]> list = map.getOrDefault(node, new ArrayList<>());

            //now i loop over the neighbours of this popped nodes list:
            for (int i = 0; i < list.size(); i++) {
                //so in here i check if poppedNodes cost + neighbour nodes cost is less than
                //dist[neighbourNode] value then i update the cost for neighbour node with new cost
                //and push that entry in pq meaning new cost for that node.
                int[] currNeighbour = list.get(i);
                int costOfNeighbour = currNeighbour[0];
                int neighbourNode = currNeighbour[1];
                int newCost = cost + costOfNeighbour;

                if (newCost < dist[neighbourNode]) {
                    //then i update the cost of this neighour and add the entry in pq:
                    dist[neighbourNode] = newCost;
                    pq.offer(new int[] {newCost, neighbourNode});
                }
            }
        }

        //now i define a variable called output and set it to -1:
        //then i loop over dist and check if any of the node between 1 to n is Integer.MAX_VALUE
        //then return -1 immediately otherwise track the max value for a node:
        int max = -1;

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}

//so this problem demands Dijkstra’s algorightm:
//i first prepare a hashmap which will store adjacency list.
//structure of hashmap: Integer (node -> key), and list if int[] as value. where 0th index is cost
//and 1st index is node. then i define a priority queue, push node k meaning for our example node 1
//into it. then i define a priorirty queue of type int[] where 0th is cost and 1st is node itself.
//its sorted based on cost. then i define a dist[] array of size n + 1, where initially everything
//is set to infinity expect for kth node, []. then i push (cost and node) in out case (0, 1). since
//kth node when inserted has 0 weight(cost). then i run a while loop until q is not empty: i pop
//the entry (0, 1) i check if for dist[1] current distance is it greater than 0? no its equal to 0
//right now. so we process nodes only when they have cost less than dist[node]. so we get all
//neighbours of 1: in this case its: (1 cost, 2 node number) and (4 cost, 4 node number) i run a
//for loop and check if dist[for current processing node] is it less than current processing node
//in this case yes because dist[for node 2] is infinity and current cost is 1 so we set dist[2] = 1
//and we do the same for node 4 as well, it becomes dist[4] = 4 from infinity then after setting
//the dist for node 2 and 4 i push them to the queue.

//[
//1 -> 2 (1)
//2 -> 3 (1)
//1 -> 4 (4)
//3 -> 4 (1)
//]