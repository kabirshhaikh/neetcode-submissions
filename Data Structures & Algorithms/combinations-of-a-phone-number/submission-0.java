class Solution {
    public List<String> letterCombinations(String digits) {
        //if digits is empty then return empty list of string:
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        //here i create a hashmap for character as key and string as value for its mapping:
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        //now i need an int varaible to track index:
        int index = 0;

        //now i need a string builder sb to which we can append and remove characters and when base case in dfs is hit we add that string to output list:
        StringBuilder sb = new StringBuilder();

        //now i need an output list of string:
        List<String> output = new ArrayList<>();

        //now i start my dfs by passing index 0:
        dfs(index, map, sb, digits, output);

        //after recursion i return output list:
        return output;
    }

    public void dfs (int index, HashMap<Character, String> map, StringBuilder sb, String digits, List<String> output) {
        //first the base case to exit out of recursion:
        if (index == digits.length()) {
            output.add(sb.toString());//add the current whatever the string is to output and return 
            return;
        }

        //otherwise i grab the current character from digits:
        char currentChar = digits.charAt(index);

        //then i get the mapping for that currentChar:
        String mappedString = map.get(currentChar);

        //then i loop over mappedString and for each character i continue dfs to get all possbile combinations:
        for (int i=0; i<mappedString.length(); i++) {
            char ch = mappedString.charAt(i);
            //i append the current ch to sb:
            sb.append(ch);
            //then i increment the index and pass the sb further deep in stack:
            dfs(index + 1, map, sb, digits, output);

            //after all the combinations are explored for this current character ch i remove it from sb meaning backtracking and explore other characters:
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

// lets say digits = "23" where 2 -> abc and 3 is def.
// so here i need a empty string sb lets say.
// i need a map of mapping character to string.
// then in need int index = 0.
// i need an empty list of string to hold ans.
// then i start my dfs and in that i pass index as 0 initially, the map, the digits string and curr sb string which is empty lets call it curr. and also an output list.

// so inside the first dfs call i get the string for map.get(digits.charAt(index));
// so this will bring mappedString = abc to me.
// then i run a for loop on it, in that for each character i need all possbile combinations.
// so what i do is first i do base check in for loop:
// if index == digits.length() then add curr string to list and return.
// if index is not digits.length() then i append current char to curr and perform dfs on it.
// so that will look something like dfs(index + 1 meaning index ==1, then map, digits string, the output list and curr string so that will be here curr="a")


// then it calls dfs(index = 1, map, digits, list and curr)
// then i get the mappedString for index 1 in digits that is def.
// then i run loop on def
// i check if index == digits.length() no, so add d to curr it becomes "ad"
// then i perform dfs from meaning dfs(index + 1 meaning index 2, map, digits, list and curr == "ad")
// then in here i check if.

// hold on i should not be checkng index == digits.length() in the for loop that should be outside for loop first thing in the dfs call.

// so dfs:
// base case:
// if index == digits.length() then add curr to list and return.

// other wise get mappedString:
// loop over it, add each character to curr, then perform dfs from there and do index +1 with updated curr.
// then when loop is over exit out of loop and remove curr character meaning the backtracking part and return
