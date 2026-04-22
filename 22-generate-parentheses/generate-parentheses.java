class Solution {

    public void helper(List<String> list,
                       StringBuilder sb,
                       int open,
                       int close,
                       int n){

        if(sb.length() == 2 * n){
            list.add(sb.toString());
            return;
        }

        // add '('
        if(open < n){
            sb.append('(');

            helper(list, sb, open + 1, close, n);

            sb.deleteCharAt(sb.length() - 1);
        }

        // add ')'
        if(close < open){
            sb.append(')');

            helper(list, sb, open, close + 1, n);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        helper(list, new StringBuilder(), 0, 0, n);

        return list;
    }
}