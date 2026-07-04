class Solution {
    public int countSeniors(String[] details) {
        int count = 0;

        for (int i=0; i<details.length; i++) {
            String curr = details[i];
            int age = Integer.parseInt(curr.substring(11, 13));
            if (age > 60) {
                count++;
            }
        }

        return count;
    }
}