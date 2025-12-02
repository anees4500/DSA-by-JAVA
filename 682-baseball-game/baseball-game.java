class Solution {
    public int calPoints(String[] ope) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i<ope.length; i++){
            if("D".equals(ope[i])){
                list.add(list.get(list.size()-1)*2);
            }
            else if("C".equals(ope[i])){
                list.remove(list.size()-1);
            }
            else if("+".equals(ope[i])){
                list.add(list.get(list.size()-1)+ list.get(list.size()-2));
            }
            else{
                list.add(Integer.parseInt(ope[i]));
            }
        }

        int sum = 0;

        for(int k : list){
            sum+=k;
        }

        return sum;
    }
}