class Solution {
    public int findJudge(int n, int[][] trust) {
        //so here i define the hasmap to hold directed adjacency list:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        //here i create directed adjacency list:
        for (int i = 0; i < trust.length; i++) {
            int[] curr = trust[i];
            List<Integer> trustList = map.getOrDefault(curr[0], new ArrayList<>());
            trustList.add(curr[1]);
            map.put(curr[0], trustList);
        }

        //here i define the variable to hold judge candidate:
        int candidateJudge = -1;

        //if the map does not contain the ith element then thats 
        //out judge candidate:
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                candidateJudge = i;
                break;
            }
        }

        //if still -1 then we didnt find, early exit return -1:
        if (candidateJudge == -1) {
            return -1;
        }

        //here i define count to 0:
        int count = 0;

        //i loop over 1 to check if each ith element's list contains 
        //out judge candidate:
        //if yes then increment count:
        for (int i = 1; i <= n; i++) {
            if (i == candidateJudge) {
                continue;
            }

            List<Integer> list = map.getOrDefault(i, new ArrayList<>());

            if (list.contains(candidateJudge)) {
                count++;
            }
        }

        //if count equals to n-1 people then thats our judge candidate:
        if (count == n-1) {
            return candidateJudge;
        } else 
        //else return -1:
        {
            return -1;
        }
    }
}

