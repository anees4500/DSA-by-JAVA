class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack1 = new Stack<>();

        HashMap<Character,Character> map = new HashMap<>();

        HashSet<Character> set = new HashSet<>();

        set.add('{');
        set.add('[');
        set.add('(');
 

        map.put('(',')');
        map.put('{' , '}');
        map.put('[',']');

        for(int i = 0; i<s.length(); i++){
            
            if(set.contains(s.charAt(i))){
                stack1.push(s.charAt(i));
            }
            else if(!stack1.isEmpty()){
                char ch = stack1.pop();
                if(map.get(ch)!=(s.charAt(i))){
                    return false;
                }
            }else{
                return false;
            }
        }

        if(!stack1.isEmpty()){
            return false;
        }

        return true;

    }
}