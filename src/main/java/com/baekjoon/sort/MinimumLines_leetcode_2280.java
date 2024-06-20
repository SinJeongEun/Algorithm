package com.example.baekjoon.baekjoon.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinimumLines_leetcode_2280 {
    public static void main(String[] args) {
//        int[][] stockPrices = {{1,7},{2,6},{3,5},{4,4},{5,4},{6,3},{7,2},{8,1}};
//        int[][] stockPrices = {{3,4},{1,2},{7,8},{2,3}};
//        int[][] stockPrices = {{36,9},{17,93},{34,4},{30,11},{11,41},{53,36},{5,92},{81,92},{28,36},{3,45},{72,33},{64,1},{4,70},{16,73},{99,20},{49,33},{47,74},{83,91}};
//        int[][] stockPrices = {{83,35},{79,51},{61,48},{54,87},{44,93},{22,5},{87,28},{64,8},{89,78},{62,83},{58,72},{48,7},{97,16},{27,100},{65,48},{11,31},{29,76},{93,29},{72,59},{73,74},{9,90},{66,81},{12,8},{86,80},{84,43},{36,63},{80,45},{81,88},{95,5},{40,59}};
//        int[][] stockPrices = {{52,62},{12,54},{84,51},{90,48},{88,82},{26,68},{98,24},{74,92},{44,65},{72,16},{21,21},{32,74},{94,28},{27,7},{76,94},{87,81},{51,45},{66,17},{86,99},{14,75},{68,6},{46,47},{89,14}};
        int[][] stockPrices = {{1, 1},{499999999, 2},{999999998, 3},{1000000000, 5}};

        int result = minimumLines(stockPrices);
        System.out.println(result);

    }

    public static int minimumLines(int[][] stockPrices) {
        int lines = 1;

        if(stockPrices.length == 1) return 0;
        if(stockPrices.length == 2) return 1;

        ArrayList<Stock> stockList = new ArrayList<>();
        for (int stocks[] : stockPrices) {
            stockList.add(new Stock(stocks[0], stocks[1]));
        }

        Collections.sort(stockList, Comparator.comparing(Stock::getDay));

        int diff_a = (stockList.get(1).price - stockList.get(0).price) / ((stockList.get(1).day - stockList.get(0).day));
        double diff_b = (stockList.get(1).price - stockList.get(0).price) % (stockList.get(1).day - stockList.get(0).day);

        for (int i = 2; i < stockList.size(); i++) {
            Stock prev = stockList.get(i - 1);
            Stock now = stockList.get(i);

            int tmp_a = (now.price - prev.price) / (now.day - prev.day);
            double tmp_b = (now.price - prev.price) % (now.day - prev.day);

            if(diff_a == tmp_a && diff_b == tmp_b) {
                continue;
            }
            lines++;

            diff_a = tmp_a;
            diff_b = tmp_b;

//            difference = nowDiff;
        }

        return lines;
    }

    static class Stock {
        int day;
        int price;

        public Stock(int d, int p) {
            this.day = d;
            this.price = p;
        }

        public int getDay() {
            return day;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Stock{" +
                    "day=" + day +
                    ", price=" + price +
                    '}';
        }
    }
}
