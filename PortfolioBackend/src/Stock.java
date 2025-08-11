
import java.math.BigDecimal;

public class Stock {
    private String symbol;
    private BigDecimal quantity;
    private BigDecimal pricePerShare;


    public Stock(String symbol, BigDecimal quantity, BigDecimal pricePerShare) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.pricePerShare = pricePerShare;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(BigDecimal pricePerShare) {
        this.pricePerShare = pricePerShare;
    }
}
