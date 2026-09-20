class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //i will first sort the array:
        Arrays.sort(nums);

        //following list will hold final output:
        List<List<Integer>> output = new ArrayList<>();

        //here i am initializing an empty list which will hold backtracking output:
        List<Integer> backtrack = new ArrayList<>();

        //here i define an index to track current index of the nums array:
        int index = 0;

        //now here i call the recursion dfs method:
        dfs(nums, index, backtrack, output);

        //in the end when the recursion and backtracking is done i return the final output list:
        return output;
    }

    //here i define the recursion dfs method of return type void:
    public void dfs (int[] nums, int index, List<Integer> backtrack, List<List<Integer>> output) {
        //first base case: if index == nums.length meaning out of bounds, so in that case capture current state of backtrack list and add that to output:
        if (index == nums.length) {
            List<Integer> copy = new ArrayList<>();
            for (int i=0; i<backtrack.size(); i++) {
                copy.add(backtrack.get(i));
            }

            output.add(copy);

            return;
        }

        //if index is valid and we have room for processing then capture current state, and add that to the output list:
        List<Integer> copy = new ArrayList<>();
        for (int i=0; i<backtrack.size(); i++) {
            copy.add(backtrack.get(i));
        }

        //add the copy to output: 
        output.add(copy);

        //now loop over nums starting from current index and perform backtracking:
        for (int i=index; i<nums.length; i++) {
            //to avoid duplicate i will add a check here:
            //if current element is same as previous element then skip that:
            if (i > index && nums[i] == nums[i-1]) continue;

            //add current element to backtrack:
            backtrack.add(nums[i]);

            //perform backtracking by calling dfs recursion method:
            dfs(nums, i+1, backtrack, output);

            //remove the current choice/element after backtracking is done:
            backtrack.remove(backtrack.size() -1);
        }
    }
}

//if the index == nums.length then return thats the dfs break case:
//so to avoid duplicates i will have to sort the array first:
//so i need an object of list which will hold list of integers, this objects reference will be used in recursion to which all the list of integers are going to be added.
//then i need an index variable starting at index 0 to track where currently I am in the index.
//then i will define an empty list initially before passing it to dfs recursion method.
//now i call dfs and i pass output list, initial list, nums and index variable.

//dfs recursion method is of type void:
//first break case: if index == nums.length then capture current list and add it output:
//second: i caputre current list and add it to output:
//then i run a for loop starting from current index and which goes all the way till < nums.length:
//inside for loop i first add current element to temp list then i  call dfs and pass i + 1 state to dfs, along with the temp list
//after backtracking is done i remove current element from list and the loop continues until its true.

//original input:
// [1,2,1]

//output at each stack trace: test not fully complete:
// [[], [1], [1,2], [1,2,1] ]

