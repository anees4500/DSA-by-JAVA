 import java.util.*;

class Solution {
    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // Combine results
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') res.add(a + b);
                        else if (c == '-') res.add(a - b);
                        else if (c == '*') res.add(a * b);
                    }
                }
            }
        }

        // Base case: expression is a single number
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }

        // Store in memo before returning
        memo.put(expression, res);
        return res;
    }
}
