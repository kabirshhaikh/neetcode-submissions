class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // here i create adjacency list:
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int[] curr = prerequisites[i];
            List<Integer> list = map.getOrDefault(curr[1], new ArrayList<>());
            list.add(curr[0]);
            map.put(curr[1], list);
        }

        // Here i define two sets, one globally visited and one for backtracking:
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> path = new HashSet<>();

        // here i define a list to hold for output after successfully completing the
        // backtracking without finding a cycle detection:
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (dfs(i, map, visited, path, output)) {
                    return new int[0];
                }
            }
        }

        Collections.reverse(output);
        int[] result = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    public boolean dfs(int node, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited,
        HashSet<Integer> path, List<Integer> output) {
        List<Integer> list = map.getOrDefault(node, new ArrayList<>());

        if (path.contains(node)) {
            return true; // cycle was detected so return empty list:
        }

        if (visited.contains(node)) {
            return false; // already visited node no need to traverse
        }

        path.add(node);
        visited.add(node);

        for (int i = 0; i < list.size(); i++) {
            int neighbour = list.get(i);
            if (dfs(neighbour, map, visited, path, output)) {
                return true;
            }
        }

        path.remove(node);
        output.add(node);

        return false;
    }
}
