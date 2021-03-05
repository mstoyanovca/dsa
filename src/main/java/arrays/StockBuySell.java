package arrays;

import java.util.ArrayList;

public class StockBuySell {
    private ArrayList<ArrayList<Integer>> stockBuySell(int[] a, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int minI = 0;
        int maxI = 0;

        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                if (maxI > minI) addResult(result, minI, maxI);
                minI = i;
                maxI = i;
            }
            if (a[i] > a[i - 1]) maxI = i;
            if (a[i] == a[i - 1]) {
                if (maxI <= minI) minI = i;
                maxI = i;
            }
            if (i == n - 1 && maxI > minI) addResult(result, minI, maxI);
        }

        return result;
    }

    private void addResult(ArrayList<ArrayList<Integer>> result, int minI, int maxI) {
        ArrayList<Integer> deal = new ArrayList<>();
        deal.add(minI);
        deal.add(maxI);
        result.add(deal);
    }

    public static void main(String[] args) {
        StockBuySell stockBuySell = new StockBuySell();

        int n = 6;
        int[] a1 = {82, 15, 91, 91, 58, 27};
        System.out.println(stockBuySell.stockBuySell(a1, n));  // [1, 3]

        n = 18;
        int[] a2 = {11, 42, 49, 96, 23, 20, 49, 26, 26, 18, 73, 2, 53, 59, 34, 99, 25, 2};
        System.out.println(stockBuySell.stockBuySell(a2, n));  // (0 3) (5 6) (9 10) (11 13) (14 15)

        n = 7;
        int[] a3 = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(stockBuySell.stockBuySell(a3, n));  // [[0, 3], [4, 6]]
    }
}
