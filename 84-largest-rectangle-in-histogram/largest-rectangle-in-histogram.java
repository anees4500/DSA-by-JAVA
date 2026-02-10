class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

                int height = heights[stack.pop()];
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int width = i - pse - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {

            int idx = stack.pop();
            int height = heights[idx];
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int width = n - pse - 1;   // 🔥 FIX HERE

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
