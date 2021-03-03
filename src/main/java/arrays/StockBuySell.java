package arrays;

import java.util.ArrayList;

public class StockBuySell {
    private ArrayList<ArrayList<Integer>> stockBuySell(int[] a, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (a[i] < a[i - 1]) {
                if (minIndex < maxIndex) {
                    ArrayList<Integer> deals = new ArrayList<>();
                    deals.add(minIndex);
                    deals.add(maxIndex);
                    result.add(deals);
                }
                minIndex = i;
            }
            if (a[i] < a[i + 1]) {
                maxIndex = i + 1;
            }
        }

        if (minIndex < maxIndex) {
            ArrayList<Integer> deals = new ArrayList<>();
            deals.add(minIndex);
            deals.add(maxIndex);
            result.add(deals);
        }

        return result;
    }

    public static void main(String[] args) {
        StockBuySell stockBuySell = new StockBuySell();

        /*int n = 5;
        int[] a = {74, 92, 10, 11, 3};*/
        int n = 7;
        int[] a = {100, 180, 260, 310, 40, 535, 695};

        System.out.println(stockBuySell.stockBuySell(a, n));  // [[0, 3], [4, 6]]  (0 1), (2 3)
    }
}
