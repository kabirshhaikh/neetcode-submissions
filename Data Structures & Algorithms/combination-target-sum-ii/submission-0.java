class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //first i sort the candidates array which will take O(logn):
        Arrays.sort(candidates);

        //first i define an output list:
        List<List<Integer>> output = new ArrayList<>();

        //then i define path list:
        List<Integer> path = new ArrayList<>();

        //then i define a variable to track index:
        int startIndex = 0;

        //now i perform backtracking using recurison here:
        backtrack(startIndex, output, path, target, candidates);

        //then i return output:
        return output;
    }

    //here i write the helper recursion method of return type void:
    public void backtrack (int startIndex, List<List<Integer>> output, List<Integer> path, int target, int[] candidates) {
        //first base case: if target == 0, copy list and add to output and then return:
        if (target == 0) {
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<path.size(); i++) {
                temp.add(path.get(i));
            }

            output.add(temp);

            return;
        }

        //second base case: if index >= candidates.length then return:
        if (startIndex >= candidates.length) {
            return;
        }

        //third base case: if target < 0 then return:
        if (target < 0) {
            return;
        }

        //otherwise i run a for loop from startIndex till end of candidates array:
        //i then check all possible combination from this current element:
        //so i add current element to the path
        //backtrack
        //then i undo remove the current element from the path:
        for (int i=startIndex; i<candidates.length; i++) {
            //first base case to check if we are not processing a duplicate entry:
            if (i > startIndex && candidates[i] == candidates[i-1]) {
                continue; //skip this element because it will produce same answer anyways:
            }

            //otherwise add this choice to path:
            path.add(candidates[i]);

            //backtrack from index + 1:
            backtrack(i+1, output, path, target - candidates[i], candidates);

            //after exploring all possible paths from here, remove the current choice from path:
            path.remove(path.size() - 1);
        }
    }
}


// [1,2,2,4,5,6,9]
// so first sort the array which takes O(logn) time.
// then i define output list and path list and index = 0;
// then i start my backtrack recursion of type void which gets index, output, path and parentIndex.
// base case to check:
// index >= candidates.length then return.

// base case 2:
// if target == 0 then copy list, add in output and return

// base case 3:
// target < 0, return

// then i run a loop from index till end of array
// i check if i > start and current number == prev number then continue skip it.
// otherwise add current number to path
// backtrackfrom here index + 1 target - can[index]
// after exploring all possible paths frm here undo remove the current candidate.

