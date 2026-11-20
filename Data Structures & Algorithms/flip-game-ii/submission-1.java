// class Solution {
//     //i am gonna define a class level hashmap for memoization so that all 
//     //recrusion functions can access it:
//     //where key is char[] array converted to string and value is true of false
//     //meaning if i have see this array before then return its old ans instead
//     //of revisiting it again:
//     HashMap<String, Boolean> memo = new HashMap<>();

//     public boolean canWin(String currentState) {
//         char[] arr = currentState.toCharArray();
//         boolean ans = dfs(arr);
//         return ans;
//     }

//     //here i write my dfs recursion function of return type boolean:
//     public boolean dfs (char[] arr) {
//         //first i convert current arr to string to check in memo for dp:
//         String key = new String(arr);

//         //if memo has this key then return its ans:
//         if (memo.containsKey(key)) {
//             return memo.get(key);
//         }

//         //no base case for out of bounds i guess:
//         for (int i=0; i<arr.length; i++) {
//             //if my next index is within bounds and next element is +
//             //then i change current element and next element to -- and pass the
//             //changed array again to dfs recursion function which will again run
//             //from index 0 checking all possibilities:
//             if (i + 1 < arr.length && arr[i] == '+' && arr[i+1] == '+') {
//                 //i change the state:
//                 arr[i] = '-';
//                 arr[i+1] = '-';

//                 //after changing both current and next to -- i call dfs
//                 //to explore:
//                 boolean dfsResult = dfs(arr);

//                 //after exploration i change the state back to original form:
//                 arr[i] = '+';
//                 arr[i+1] = '+';

//                 //if dfsResult if false meaning the opponent returned false for
//                 //any reason then i return true meaning no way opponent can win:
//                 if (!dfsResult) {
//                     //if i win i memoize the current state:
//                     memo.put(key, true);
//                     return true;
//                 }
//             }

//             //if current element is - and next element is either - or + then its 
//             //an invalid move and i continue with my loop.
//             //i will call dfs only if current and next element is + because thats
//             //when i am allowed to play
//         }

//         //i update the memo for this states key with false since if code reached
//         //till here then we loose:
//         memo.put(key, false);

//         //for loop is over and if an opponent didnt return false meaning it
//         //returned true which means i lost, so i return false:
//         return false;
//     }
// }

class Solution {
    public boolean canWin(String currentState) {
        int n = currentState.length();

        // grundy[len] represents the Grundy number
        // for a consecutive group of len '+' characters.
        int[] grundy = new int[n + 1];

        // Compute Grundy numbers for all group lengths.
        for (int len = 2; len <= n; len++) {
            Set<Integer> seen = new HashSet<>();

            // Try flipping every adjacent '++' pair.
            for (int i = 0; i < len - 1; i++) {
                int left = i;
                int right = len - i - 2;

                // Flipping splits the group into two games.
                int value = grundy[left] ^ grundy[right];
                seen.add(value);
            }

            // Find minimum excluded nonnegative integer (mex).
            int mex = 0;
            while (seen.contains(mex)) {
                mex++;
            }

            grundy[len] = mex;
        }

        // Combine all independent '+' groups using XOR.
        int xor = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (currentState.charAt(i) == '+') {
                count++;
            } else {
                xor ^= grundy[count];
                count = 0;
            }
        }

        // Include the final group.
        xor ^= grundy[count];

        // Nonzero XOR means the first player can force a win.
        return xor != 0;
    }
}
