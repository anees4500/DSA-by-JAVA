class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // empty prefix

        int sum = 0;
        int count = 0;

        for (int x : nums) {
            sum += x;

            int mod = sum % k;
            if (mod < 0) mod += k; // handle negative mods

            if (map.containsKey(mod)) {
                count += map.get(mod);
            }

            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}
