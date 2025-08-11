package src;

import java.util.Comparator;

public class SortBySymbol implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Stock stock1 = (Stock) o1;
        Stock stock2 = (Stock) o2;
        return stock1.getSymbol().compareTo(stock2.getSymbol());
    }
}
