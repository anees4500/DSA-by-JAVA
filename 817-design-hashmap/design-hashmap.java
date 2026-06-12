class MyHashMap {

    int size = 0;
    int arr[] = new int[1000005];

    public MyHashMap() {
        size = 0;
        
        Arrays.fill(arr,-1);


        

    }
    
    public void put(int key, int value) {

        arr[key] = value;
        size++;
    }
    
    public int get(int key) {

         

        return arr[key];
        
    }
    
    public void remove(int key) {

        if(arr[key]==-1){
            return;
        }

        arr[key] = -1;
        size--;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */