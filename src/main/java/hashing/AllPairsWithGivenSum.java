package hashing;

import java.util.*;

public class AllPairsWithGivenSum {
    public Pair[] allPairs(long[] a, long[] b, long m, long n, long sum) {
        Map<Long, Integer> hash = new HashMap<>();
        for (long l : a) hash.put(l, 1);

        List<Pair> pairs = new ArrayList<>();
        for (long l : b) if (hash.containsKey(sum - l)) pairs.add(new Pair(sum - l, l));

        pairs.sort((Pair p1, Pair p2) -> (int) (p1.first - p2.first));
        return pairs.toArray(new Pair[0]);
    }

    private static class Pair {
        long first, second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ')';
        }
    }

    public static void main(String[] args) {
        long m = 5;
        long n = 5;
        long sum = 9;
        long[] a = {-1, 2, 4, 5, 7};
        long[] b = {5, 6, 3, 4, 8};

        System.out.println(Arrays.toString(new AllPairsWithGivenSum().allPairs(a, b, m, n, sum)));  // (1, 8), (4, 5), (5, 4)
    }
}
