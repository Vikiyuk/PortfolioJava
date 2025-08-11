package PortfolioBackend.src;


import java.util.ArrayList;

public class Portfolio {
    public ArrayList<Stock> list = new ArrayList<>();

    public void addStock(Stock stock) {
        list.add(stock);
    }

    public void showPortfolio () {
        for (Stock stock : list) {
            System.out.println(stock.getSymbol() + " " + stock.getQuantity() + " " + stock.getPricePerShare());
        }
    }

    public void updateStock (Stock stock) {
        String name = stock.getSymbol();
        for (Stock temp : list) {
            if (temp.getSymbol().equals(name)) {
                temp.setQuantity(stock.getQuantity());
                temp.setPricePerShare(stock.getPricePerShare());
            }
        }
    }

    public void removeStock(Stock stock) {
        list.remove(stock);
    }
}
