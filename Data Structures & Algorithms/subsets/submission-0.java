class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //here i define variable to track index:
        int startIndex = 0;

        //now i define output list and path list:
        List<List<Integer>> output = new ArrayList<>();

        //path list:
        List<Integer> path = new ArrayList<>();

        //now i call backtrack method:
        backtrack(startIndex, output, path, nums);

        //after backtracking i return output list:
        return output;
    }

    //here i write my backtrack recursion method of type void:
    public void backtrack (int startIndex, List<List<Integer>> output, List<Integer> path, int[] nums) {
        //first copy the path and add to the output:
        List<Integer> copyPath = new ArrayList<>();
        for (int i=0; i<path.size(); i++) {
            copyPath.add(path.get(i));
        }
        output.add(copyPath);

        //now base check:
        if (startIndex >= nums.length) {
            return;
        }

        //otherwise i run for loop from startIndex till end:
        for (int i=startIndex; i<nums.length; i++) {
            //add current index to path:
            path.add(nums[i]);

            //backtrack:
            backtrack(i+1, output, path, nums);

            //undo current index from path:
            path.remove(path.size() - 1);
        }
    }
}

// so the problem requrires backtrack.
// i will need output list, and path list.
// then i call void backtrack recursion method:


// backtrack helper method:
// add current path to output.

// base case check if index <= nums.length then return.

// otherwise run for loop from startIndex till < nums.length
// add current index.
// backtrack index + 1
// remove current index from path and loop continues.

// [1,2,3]
// path = {}, output = {}

// stack 1 (startIndex = 0, output, path):
// add path: output = {[]}

// for startIndex = 0 till < length:
// path.add(nums[0]) -> path = {1}
// backtrack(startIndex + 1, output, path)


// stack 2 (startIndex = 1, output, path):
// add path [1]: output = {[], [1]}

// for startIndex = 1 till < length:
// path.add(nums[1]) -> path = {1,2}
// backtrack(startIndex + 1, output, path)

// stack 3 (startIndex = 2, output, path):
// add path [1,2]: output = {[], [1], [1,2]}

// for startIndex = 2 till < length:
// path.add(nums[2]) -> path = {1,2,3}
// backtrack(startIndex + 1, output, path)


// stack 4 (startIndex = 2, output, path):
// add path [1,2,3]: output = {[], [1], [1,2], [1,2,3]}
// index <= nums.length so return to call stack 3


// now we return back to stack 3:
// add path [1,2]: output = {[], [1], [1,2]}

// for startIndex = 2 till < length:
// path.add(nums[2]) -> path = {1,2,3}
// backtrack(startIndex + 1, output, path)
// we remove number 3 from path -> path = {1,2}
// and for loop exits from here and we return back to call stack 2



// stack 2 (startIndex = 1, output, path):
// add path [1]: output = {[], [1]}

// for startIndex = 1 till < length:
// path.add(nums[1]) -> path = {1,2}
// backtrack(startIndex + 1, output, path)
// now i remove number 2 from here in the path so path becomes = {1}
// now startIndex increment to 2
// then i add nums[startIndex 2 meaning number 3 to path] -> so path becomes = {1,3}
// and then i backtrack(startIndex + 1, output, path)


// stack 5:
// path = {1,3},  output = {[], [1], [1,2], [1,2,3], [1,3]}
// index <= nums.length so return to call stack 2.


// back at call stack 2:
// i remove number 3 from path so path becomes = {1}
// for loop ends and i return to call stack 1.


// stack 1 (startIndex = 0, output, path):
// add path: output = {[]}

// for now startIndex becomes 1 till < length:
// path.add(nums[1]) -> path = {1, 2}
// backtrack(startIndex + 1, output, path)


