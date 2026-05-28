class Solution {
    public int smallestCommonElement(int[][] mat) {
        HashSet<Integer> set = new HashSet<>();

        int[] firstRow = mat[0];

        for (int i=0; i<firstRow.length; i++) {
            set.add(firstRow[i]);
        }

        for (int i=1; i<mat.length; i++) {
            int[] current = mat[i];
            HashSet<Integer> temp = new HashSet<>();

            for (int j=0; j<current.length; j++) {
                temp.add(current[j]);
            }

            set.retainAll(temp);
        }

        return set.isEmpty() ? -1 : Collections.min(set);
    }
}
