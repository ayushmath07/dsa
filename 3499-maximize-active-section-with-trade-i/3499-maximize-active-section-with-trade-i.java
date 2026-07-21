class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";

        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Integer> lens = new ArrayList<>();

        for (char c : t.toCharArray()) {
            if (chars.isEmpty() || chars.get(chars.size() - 1) != c) {
                chars.add(c);
                lens.add(1);
            } else {
                lens.set(lens.size() - 1, lens.get(lens.size() - 1) + 1);
            }
        }

        int ans = ones;

        for (int i = 1; i < chars.size() - 1; i++) {
            if (chars.get(i) == '1') {
                int leftZeros = lens.get(i - 1);
                int rightZeros = lens.get(i + 1);
                ans = Math.max(ans, ones + leftZeros + rightZeros);
            }
        }

        return ans;
    }
}