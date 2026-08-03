class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                left.push(i);
                continue;
            }

            if (c == '*') {
                star.push(i);
                continue;
            }

            if (!left.isEmpty()) {
                left.pop();
            } else if (!star.isEmpty()) {
                star.pop();
            } else return false;
        }

        if (left.isEmpty()) return true;
        while (!left.isEmpty()) {
            if (star.isEmpty()) return false;
            int l_index = left.pop();
            int s_index = star.pop();
            if (s_index < l_index) return false;
        }
        return true;
    }
}
