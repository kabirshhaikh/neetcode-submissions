class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> seen = new HashSet<>();
        int x = 0;
        int y = 0;
        seen.add("0,0");

        for (int i=0; i<path.length(); i++) {
            char curr = path.charAt(i);
            if (curr == 'N') {
                x--;
            }
            else if (curr == 'S') {
                x++;
            }
            else if (curr == 'E') {
                y--;
            }
            else {
                y++;
            }

            String newPath = x + "," +y;
            if (seen.contains(newPath)) {
                return true;
            }
            else {
                seen.add(newPath);
            }
        }

        return false;
    }
}