class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses, int[][] prerequisites, int[][] queries) {
        //so first i create an adjacency list of hashmap where key is integer and list of integer
        //is value for that key:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //now i create the adjacency list by looping over prerequisites:
        for (int i = 0; i < prerequisites.length; i++) {
            int[] curr = prerequisites[i];
            int keyNode = curr[0];
            int valueNode = curr[1];

            List<Integer> keyNodeList = map.getOrDefault(keyNode, new ArrayList<>());
            keyNodeList.add(valueNode);

            map.put(keyNode, keyNodeList);
        }

        //now i define a boolean List to store the final answer:
        List<Boolean> answer = new ArrayList<>();

        //now i loop over queries:
        for (int i = 0; i < queries.length; i++) {
            int[] curr = queries[i];
            int startNode = curr[0];
            int targetNode = curr[1];

            //now i define a fresh hashset to track all visited nodes:
            HashSet<Integer> visited = new HashSet<>();

            //now i perform dfs from the startNode:
            boolean ans = dfs(startNode, visited, map, targetNode);

            //if ans is true and for ith position in answer i set true else false:
            if (ans) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }

        //after looping and dfs is done i return answer array:
        return answer;
    }

    //now here i am going to write the dfs helper function of return type boolean:
    public boolean dfs(int currentNode, HashSet<Integer> visited,
        HashMap<Integer, List<Integer>> map, int targetNode) {
        //first base case:
        if (currentNode == targetNode) {
            return true; //we found the preReq through neighbours
        }

        //second base case:
        if (visited.contains(currentNode)) {
            return false; //meaning we have already visited this node and it didnt lead us to targetNode
        }

        //otherwise i mark the current node as visited:
        visited.add(currentNode);

        //then i grab the list of neighbours for this currentNode:
        List<Integer> neighbours = map.getOrDefault(currentNode, new ArrayList<>());

        //now i loop over each neighbour to check if it leads to the targetNode:
        for (int i = 0; i < neighbours.size(); i++) {
            int currNeighbour = neighbours.get(i);

            //return true immediately if dfs returns true:
            if (dfs(currNeighbour, visited, map, targetNode)) {
                return true;
            }
        }

        //otherwise return false if any of the neighbour didnt lead to any target from this currentNode:
        return false;
    }
}

// there are n courses.
// labelled from 0 to n-1.

// you are given preReq 2d array where [a, b] meaning you must take a first if you want to take
// course b.

// preReq can also be indirect.

// if A is preReq of B and B is preReq of C then A is indirectly preReq of C.

// you are given 2d array query: [U,V].

// so for the ith query i have to answer is my course U a preReq of course V or NOT.

// I have to return boolean answer array, where answer of ith position is the answer of ith query.

// n = 4.

// preReq = [[1,0],[2,1],[3,2]];
// queries = [[0,1],[3,1]];

// adjacency list:
// 1 -> {0},
// 2 -> {1},
// 3 -> {2}

// i will make boolean[] array called answer of size queries.length

// so regarding queries, lets say we start with 0th position query.
// [0,1] since 0 is not even a key in the adjacency list
// so ith position in answer is false.

// then i get to 1st index [3,1]
// here when i start my dfs from 3 i get 2 and from 2 i get 1. so yes 3 is a preReq of 1.
// so boolean of answer array at this 1st index will be true.

// so the problem requires dfs algo:
// here i first define a hashmap where integer is key and list of integer is value.

// then i define a boolean[] array called answer of length quries.length.

// then i loop over queries:
// so for ith query [u,v] i extract them and store in two variables lets say:
// int startNode = u and int resultingNode = v;

// then i define a visited hashset of type integer to track all explored nodes.

// then i perform dfs starting from startNode which will accpet hashmap, visited set, and targtNode.

// dfs will be of type boolean, if dfs returns true, then for that ith position answer array will be
// true else false.

// in the end i return the answer array.

// now the dfs recursion helper function:
// dfs(currentNode, hashmap, visitedSet and targetNode)
// first base case:
// if current node == targetNode then return true.

// second base case:
// if already visited then return false becuase we have already visited this node and we didnt find
// the target.

// now i mark current node as visited

// get the list of neighbours

// loop on the neighbour and perform dfs for each neighbour.

// after loop return false meaning no neighbour led to a target.