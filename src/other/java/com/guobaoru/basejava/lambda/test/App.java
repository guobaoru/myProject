package basejava.lambda.test;

import java.util.ArrayList;
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

        Map<String, List<Transaction>> map = getTest(transactions);
        System.out.println(map);
    }

    /**
     * 查找价格大于1000 的币种，且分类
     * @param transactions
     * @return
     */
    private static Map<String, List<Transaction>> getTest(List<Transaction> transactions) {
        return transactions.stream().filter((Transaction transaction) ->
                transaction.getPrice() > 1000).collect(Collectors.groupingBy(Transaction::getCurrency));
    }
}
