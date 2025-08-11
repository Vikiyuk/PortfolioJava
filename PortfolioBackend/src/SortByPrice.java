package src;

import java.math.BigDecimal;
import java.util.Comparator;

public class SortByPrice implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Stock stock1 = (Stock) o1;
        Stock stock2 = (Stock) o2;
        int temp = stock1.getPricePerShare().compareTo(stock2.getPricePerShare());
        if (temp > 0) {
            return 1;
        } else if (temp < 0) {
            return -1;
        }
        return 0;
    }
}
