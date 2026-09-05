class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //so first i will define output list:
        List<List<Integer>> output = new ArrayList<>();

        //then i will define a path list:
        List<Integer> path = new ArrayList<>();

        //now i will call backtrack method of type void:
        //it accepts start number which is 1, n, k, output list and fresh list for backtracking which will be added to output list:
        backtrack(1, n, k, output, path);

        //then in the end i return the output list:
        return output;
    }

    //now here i define the backtracking method of return type void:
    public void backtrack (int start, int n, int k, List<List<Integer>> output, List<Integer> path) {
        //first base check, if size of path list == k then copy that and add it to output and return:
        if (path.size() == k) {
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<path.size(); i++) {
                temp.add(path.get(i));
            }

            output.add(temp);

            return;
        } 

        //now i run a loop from start number till n for all possbile combinations:
        for (int i=start; i<=n; i++) {
            int currentNumber = i;
            //now i add the ith elemenbt to path for backtracking from here for all combinations:
            path.add(i);

            //now i do backtracking for all possible combinations from i + 1:
            backtrack(i+1, n, k, output, path);

            //after doing backtracking and exploring all possible comibinations i remove my current choice from path list:
            path.remove(path.size() - 1);
        }
    }
}

// given two numbers n = 3 and k = 2.
// return combinations of k numbers from 1 to n.

// so two combinations of numbers starting from 1 to n.

// 1, 2, 3

// [1,2]
// [1,3]
// [2,3]

// so i will need two lists, one for output.


// then the outer loop will run from 1 to n:
// i will extract current number:
// lets say 1.
// then i will call the backtrack recursion method, which will accpet the current number, output list, a fresh path list everytime from outer loop and k.


// the backtracking fucntion (startNumber, output list, fresh list, k)
// i first check if size of list == k then copy it into new list, and add that list into output and return.

// otherwise i add current startNumber into list.

// then i run a for loop starting from startNumber + 1 till n:
// i extract current startNumber + 1:
// call backtrack(pass startNumber + 1, output, path, and k)
// remove current number from fresh list and loop continues. not sure should i add number in fresh list inside for loop or outside for loop after having base case check.

// then i exit out of for loop and remove current choice from fresh list 

