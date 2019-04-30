package com.guobaoru.basejava.lambda.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Created by guobaoru.
 * @create on 2019/2/11.
 */
public class App {
    public static void main(String[] args) {
        final List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1100, "CNY"));
        transactions.add(new Transaction(500, "CNY"));
        transactions.add(new Transaction(2100, "USD"));
        transactions.add(new Transaction(670, "USD"));
        transactions.add(new Transaction(270, "CNY"));
        transactions.add(new Transaction(2000, "CNY"));
        transactions.add(new Transaction(1800, "USD"));
        transactions.add(new Transaction(1400, "CNY"));
        transactions.add(new Transaction(1400, "123"));
        transactions.add(new Transaction(1400, "YES"));

        System.out.println(group(transactions));
        System.out.println(sorted(transactions));
        System.out.println(filter(transactions));
//        System.out.println(map(transactions));
        System.out.println(map2(transactions));
        System.out.println(transactions);
    }

    /**
     * 查找价格大于1000 的币种，且分类
     * @param transactions
     * @return
     */
    private static Map<String, List<Transaction>> group(List<Transaction> transactions) {
        return transactions.stream().filter((Transaction transaction) ->
                transaction.getPrice() > 1000).collect(Collectors.groupingBy(Transaction::getCurrency));
    }



    private static List<Transaction> sorted(List<Transaction> transactions) {
        return transactions.stream().sorted(Comparator.comparing(Transaction::getCurrency)).collect(Collectors.toList());
    }


    private static List<Transaction> filter(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getPrice() > 1000)
                .filter(transaction -> transaction.getCurrency().contains("U"))
                .collect(Collectors.toList());
    }

    private static List<Transaction> map(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> {
                    transaction.setPrice(10001);
                    transaction.setCurrency("synchronize");
                    return transaction;
                })
                .collect(Collectors.toList());
    }

    private static List<Transaction> map2(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> {
                    Transaction transaction1 = new Transaction(transaction.getPrice(), "synchronize");
                    return transaction1;
                })
                .collect(Collectors.toList());
    }



}
