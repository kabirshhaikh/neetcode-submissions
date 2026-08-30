class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //so here i define a list of integer which will hold my output:
        List<List<Integer>> output = new ArrayList<>();

        //now here i define an index to start backtracking with meaning entry point:
        int index = 0;

        //need a list to track path:
        List<Integer> path = new ArrayList<>();

        //now i call the backtrack recursion method:
        backtrack(output, nums, target, index, path);

        //in the end i will return output list:
        return output;
    }

    public void backtrack (List<List<Integer>> output, int[] nums, int target, int index, List<Integer> path) {
        //first base case:
        if (target == 0) {
            //i create a temp list which will hold current paths copy and then i will add that to the output:
            List<Integer> tempList = new ArrayList<>();
            for (int i=0; i<path.size(); i++) {
                tempList.add(path.get(i));
            }

            output.add(tempList);

            return;
        }

        //second base case: if target is less than 0 or target is >= nums.length then return:
        if (target < 0 || index >= nums.length) {
            return;
        }

        //otherwise add current index number to path:
        path.add(nums[index]);
        
        //backtrack with same index:
        backtrack(output, nums, target - nums[index], index, path);

        //after backtracking from this level is done, remove current number from path:
        path.remove(path.size() - 1);

        //skip nums[index] and move to next one:
        backtrack(output, nums, target, index + 1, path);
    }
}

// so this problem required backtracking.
// here I am gonna vall backtrack recursion function of type void.
// in the first base case will be:
// if target == 0 then make a list of integer and add it to output list.

// second base case will be if target < 0 || target >= nums.lenght then return. target out of reach.

// other wise i add the current nums number to list for backtracking.
// then i call backtrack again with current number only i do not increment index here.
// then i remove currently added number.

// then i increment index this time for second backtracking call.

// so lets say the input was [2,5,9] and target was 9.

// so start of call stack 1:
// add 2 -> path = [2]
// call backtrack with same index
// remove 2 

// call backtrack with index + 1
// end of call stack 1.


// start of call stack 2:
// add 2 in path:
// path = [2, 2]
// backtrack with same index.
// remove choice.

// backtrack with index + 1.
// end of call stack 2.

