class Solution {
    public String[] sortPeople(String[] names, int[] arr) {
        HashMap<Integer, String> map = new HashMap<>();

        for(int i = 0; i<names.length; i++){
            map.put(arr[i] , names[i]);
        }


        Arrays.sort(arr); // ascending

        // reverse
        for(int i = 0; i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        int j = 0;

        for(int i : arr){
            names[j++] = map.get(i);
        }

        return names;
    }
}