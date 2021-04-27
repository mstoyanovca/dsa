package hashing;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithSum0 {
    public int maxLen(int[] arr, int n) {
        Map<Integer, Integer> hash = new HashMap<>();
        int maxLength = 0;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (!hash.containsKey(sum)) {
                hash.put(sum, i);
            } else {
                maxLength = Math.max(maxLength, i - hash.get(sum));
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int n = 79;
        int[] arr = {-341, 778, -826, -153, -574, -289, -993, -622, -989, -695, 150, -692, 755, -150, -586, -123, 960, -182, -605, 168, -635, 47, -108, 126, 158, 71, -584, -482, 565, -51, 369, -431, 431, 467, 305, 572, -793, 276, 639, -706, 574, 158, 894, -849, 979, -959, 432, -25, 712, -897, -476, 661, 791, 880, -686, -278, 364, -123, 429, -65, 230, 459, -770, -872, 330, -202, -944, 783, -502, 869, -246, -154, -935, 572, 959, -475, 18, -198, -769};

        System.out.println(new LargestSubArrayWithSum0().maxLen(arr, n));  // 10
    }
}
