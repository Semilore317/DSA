class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // sliding window approach?
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        
        char[] c2 = s2.toCharArray();

        // sliding window through s2
        for (int i = 0; i < c2.length - c1.length + 1; i++) {
            char[] window = new char[c1.length];
            System.arraycopy(
                c2, // src
                i,  // srcPos
                window, // destination
                0, // destPos
                c1.length // length
            );

            Arrays.sort(window);

            if(Arrays.equals(c1, window))
                return true;
        }
        return false;
    }
}
