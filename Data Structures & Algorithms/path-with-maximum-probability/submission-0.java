class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        //so first i create adjacency list using a hashmap:
        //in here the key is the node and value is list of int[], where 0th element is the succProb for the ith succProb and 1st element is the node:
        HashMap<Integer, List<double[]>> map = new HashMap<>();

        //now i loop over edges and create the adjacency list:
        for (int i=0; i<edges.length; i++) {
            int[] curr = edges[i];
            int node1 = curr[0];
            int node2 = curr[1];

            double currSuccesProb = succProb[i];

            //now i grab the list for each node, if its not available then i get empty default list:
            List<double[]> node1List = map.getOrDefault(node1, new ArrayList<>());
            List<double[]> node2List = map.getOrDefault(node2, new ArrayList<>());

            //now i put the data in both the list:
            node1List.add(new double[] {currSuccesProb, node2});
            node2List.add(new double[] {currSuccesProb, node1});

            //now i update the map:
            map.put(node1, node1List);
            map.put(node2, node2List);
        }

        //now i create a double[] prob array to of size n to hold best succesProb for each node:
        double[] prob = new double[n];
        
        //now i set the startingNode as 1.0 to begin:
        prob[start_node] = 1.0;

        //then i push 1.o and startNode into priority queue, also now i will define pq:
        //also i will sort it to keep decending order successProb for each node:
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        pq.offer(new double[] {1.0, start_node});

        //now i loop until pq is not empty:
        while (!pq.isEmpty()) {
            //i pop top most element:
            double[] popped = pq.poll();

            //now i extract details from popped array:
            double poppedSuccesProb = popped[0];
            int poppedNode = (int) popped[1];

            //now i check staleness, if current poppedSuccessProb is less than set probability for this node in prob array then i skip it:
            if (poppedSuccesProb < prob[poppedNode]) {
                continue;
            }

            //otherwise i get the list of neighbours:
            List<double[]> neighbours = map.getOrDefault(poppedNode, new ArrayList<>());

            //now i loop over neighbours:
            for (int i=0; i<neighbours.size(); i++) {
                double[] currentNeighbour = neighbours.get(i);

                double currentNeighbourSuccessProb = currentNeighbour[0];
                int currentNeighbourNode = (int) currentNeighbour[1];

                //now i calculate new probability:
                double newProb = currentNeighbourSuccessProb * poppedSuccesProb;

                //now i perform a check to make sure if newProb is greater than older one then i update it for this neighbour node:
                if (newProb > prob[currentNeighbourNode]) {
                    prob[currentNeighbourNode] = newProb;

                    //after that i create a double array object and push that to pq:
                    pq.offer(new double[] {newProb, currentNeighbourNode});
                }
            }
        }

        //in the end i return the last nodes probability:
        return prob[end_node];
    }
}

// adjacency list will look like this for the following edges:
//edges =    [[0,1],[1,2],[0,2]]
//succProb = [0.5,0.5,0.2]
//start = 0, and end = 2

//so the hashmap will have key as node and value as list of int[] where 0th element is edge and 1st element is the ith succesProb
//adjacency list:
// [
//     0 -> {[1, 0.5], [2, 0.2]},
//     1 -> {[0, 0.5], [2, 0.5]},
//     2 -> {[1, 0.5], [0, 0.2]},
// ]

//so what i do is i define a priority queue of type double[] which will hold successProb and node sorted as: [a,b] -> b[0] - a[0]: meaning keep max succesProb on top and do sorting based on successProb not node.

// then i push (1.0, startNode) in it. why 1.0 because in probability 1 means 100% and 0.5 means 50%.

//then i define max = 0;

//i then define an array called prob of size n.
//and then i set prob[startNode] = 1.0.

//i then start while loop until pq is not empty:
//i pop the double[]
//i grab currentSuccessProb and currentNode.
//then i perform stale check, if currentSucessProb < prob[currentPopped node then skip]
//otherwise i grab the list of neighbours.
//then i loop over the list:
//what i do is i multiple currentSuccessProb * with currentNeighboursSuccessprob 
//then i check if newProb is greater than prob[currentNeighbour]
//if yes then i set prob[currentNeighbour] = newProb
//and then i create double[] object add newProb and neighbour node number in it and push that into queue.

//after while loop finishes, i return prob[endNode value] because we want sucessProb of the target node which is end node in our case.
