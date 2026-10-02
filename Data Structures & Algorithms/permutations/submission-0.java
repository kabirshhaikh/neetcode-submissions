class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //initially visited all cells are false:
        boolean[] visited = new boolean[nums.length];

        //now define empty list and list of list:
        List<Integer> backtrack = new ArrayList<>();

        //output list:
        List<List<Integer>> output = new ArrayList<>();

        //index:
        int index = 0;

        //recursion method:
        dfs(index, nums, visited, backtrack, output);

        //return output:
        return output;
    }

    //now here i write the helper recursion method of return type void:
    public void dfs (int index, int[] nums, boolean[] visited, List<Integer> backtrack, List<List<Integer>> output) {
        //base case: 
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<backtrack.size(); i++) {
                temp.add(backtrack.get(i));
            }

            output.add(temp);

            return;
        }

        for (int i=0; i<nums.length; i++) {
            //if current number index is visited then continue:
            if (visited[i] == true) {
                continue;
            }

            //mark current position as marked:
            visited[i] = true;

            //add current number into backtrack:
            backtrack.add(nums[i]);

            //then explore:
            dfs(index + 1, nums, visited, backtrack, output);

            //after exploring, unmark the visited node:
            visited[i] = false;

            //remove current number from backtrack:
            backtrack.remove(backtrack.size() - 1);
        }
    }
}

//so here i will need a boolean[] array to mark used positions:
//i will need an index variable to track index:
//then i will need a empty list and list of list:
//then i will write my dfs recursion function of type void:
//base case is when index == nums.length then capture list and add it to output list and then return.

