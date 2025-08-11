import java.math.BigDecimal;
import java.util.ArrayList;

public class Portfolio {
    public ArrayList<Stock> list = new ArrayList<>();

    public void addStock(Stock stock2) {
        this.list.add(stock2);

    }

    public static BigDecimal calculateValue (Stock stock) {
        return stock.getQuantity().multiply(stock.getPricePerShare());
    }

    public void showPortfolio () {
        BigDecimal totalValue = new BigDecimal(0);
        for (Stock stock : this.list) {
            System.out.println(stock.getSymbol() + " " + stock.getQuantity() + " " + stock.getPricePerShare());
            totalValue = totalValue.add(Portfolio.calculateValue(stock));
        }
        System.out.println("Total value: " + totalValue);
    }




    // if -1, leave as it is previously in terms of quantity and price
    public void updateStock (Stock stock) {
        String name = stock.getSymbol();
        BigDecimal newPrice = stock.getPricePerShare();
        BigDecimal newQuantity = stock.getQuantity();

        for (Stock temp : list) {
            if (temp.getSymbol().equals(name)) {
                if(!(newQuantity.equals(new BigDecimal(-1)))) {
                    temp.setQuantity(newQuantity);
                }
                if (!(newPrice.equals(new BigDecimal(-1)))) {
                    temp.setPricePerShare(stock.getPricePerShare());
                }
            }
        }
    }

    public void removeStock(String symbol) {
        list.removeIf(temp -> temp.getSymbol().equals(symbol));
    }

    public boolean ifExists(String symbol){
        for (Stock stock:list){
            if (stock.getSymbol().equals(symbol)){
                return true;
            }
        }
        return false;

    }
}