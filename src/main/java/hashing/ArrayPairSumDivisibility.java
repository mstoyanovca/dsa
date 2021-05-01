package hashing;

import java.util.HashMap;
import java.util.Map;

public class ArrayPairSumDivisibility {
    public boolean canPair(int[] nums, int k) {
        if (nums.length % 2 != 0) return false;

        Map<Integer, Integer> hash = new HashMap<>();

        for (int i : nums) {
            int remainder = i % k;
            if (!hash.containsKey(remainder)) {
                hash.put(remainder, 1);
            } else {
                hash.put(remainder, hash.get(remainder) + 1);
            }
        }

        for (int i : nums) {
            int remainder = i % k;
            int frequency = hash.get(remainder);

            if (remainder == 0) {
                if (frequency % 2 != 0) return false;
            } else if (2 * remainder == k) {
                if (2 * remainder == k && frequency % 2 != 0) return false;
            } else {
                if (hash.get(remainder) != hash.get(k - remainder)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] nums = {6, 14, 12, 14};

        System.out.println(new ArrayPairSumDivisibility().canPair(nums, k));  // true
    }
}
