

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean exit=false;
        Scanner input=new Scanner(System.in);
        Portfolio portfolio = new Portfolio();
        Comparator comparatorPrice=new SortByPrice();
        Comparator comparatorQuantity=new SortByQuantity();
        Comparator comparatorSymbol=new SortBySymbol();
        while (!exit){

            printMenu();
            String inputNumber= input.nextLine();
            switch (inputNumber){
                case "1":
                    System.out.println("Enter stock symbol");
                    String stockSymbol = input.nextLine();
                    System.out.println("Enter stock price");
                    String stockPrice = input.nextLine();
                    if (new BigDecimal(stockPrice).compareTo(new BigDecimal("0"))<0){
                        System.out.println("Stock price is less than 0");
                        sleep(1000);
                        continue;
                    }
                    System.out.println("Enter stock quantity");
                    String stockQuantity = input.nextLine();
                    if (new BigDecimal(stockQuantity).compareTo(new BigDecimal("0"))<0){
                        System.out.println("Stock quantity is less than 0");
                        sleep(1000);
                        continue;
                    }
                    Stock stock = new Stock(stockSymbol,new BigDecimal(stockPrice),new BigDecimal(stockQuantity));

                    portfolio.addStock(stock);
                    break;
                case "2":
                    System.out.println("Select options to sort(1-Price,2-Quantity,3-Symbol,4-default)");
                    inputNumber=input.nextLine();
                    switch (inputNumber){
                        case "1":
                            Collections.sort(portfolio.list,comparatorPrice);
                            portfolio.showPortfolio();
                            break;
                        case "2":
                            Collections.sort(portfolio.list,comparatorQuantity);
                            portfolio.showPortfolio();
                            break;
                        case "3":
                            Collections.sort(portfolio.list,comparatorSymbol);
                            portfolio.showPortfolio();
                            break;
                        case "4":
                            portfolio.showPortfolio();
                            break;
                        default:
                            System.out.println("Incorrect option");
                    }

                    System.out.println("Press enter to proceed");
                    input.nextLine();
                    break;
                case "3":
                    System.out.println("Enter stock symbol to update");
                    String stockSymbolUpdate = input.nextLine();
                    if(portfolio.ifExists(stockSymbolUpdate)){
                        portfolio.removeStock(stockSymbolUpdate);
                    }else{
                        System.out.println("Stock doesn't exist, dummy");
                        sleep(1000);
                        continue;
                    }
                    System.out.println("Enter stock price to update(or -1 to leave it as it is)");
                    String stockPriceUpdate = input.nextLine();
                    if (new BigDecimal(stockPriceUpdate).compareTo(new BigDecimal("0"))<0
                    && new BigDecimal(stockPriceUpdate).compareTo(new BigDecimal("-1"))!=0
                    ){
                        System.out.println("Stock price is less than 0");
                        sleep(1000);
                        continue;
                    }
                    System.out.println("Enter stock quantity to update(or -1 to leave it as it is)");
                    String stockQuantityUpdate = input.nextLine();
                    if (new BigDecimal(stockQuantityUpdate).compareTo(new BigDecimal("0"))<0
                            && new BigDecimal(stockQuantityUpdate).compareTo(new BigDecimal("-1"))!=0
                    ){
                        System.out.println("Stock price is less than 0");
                        sleep(1000);
                        continue;
                    }
                    Stock stockUpdate = new Stock(stockSymbolUpdate,new BigDecimal(stockPriceUpdate),new BigDecimal(stockQuantityUpdate));
                    portfolio.updateStock(stockUpdate);
                    break;
                case "4":
                    System.out.println("Enter stock symbol to delete");
                    String stockSymbolDelete = input.nextLine();
                    if(portfolio.ifExists(stockSymbolDelete)){
                        portfolio.removeStock(stockSymbolDelete);
                    }else{
                        System.out.println("Stock doesn't exist, dummy");
                        sleep(1000);

                    }

                    break;
                case "5":
                    exit=true;
                    break;
                default:
                    System.out.println("Incorrect option, try again");
            }
        }
    }
    public static void printMenu(){
        System.out.println("===Portfolio Manager");
        System.out.println("1. Add stock");
        System.out.println("2. View portfolio");
        System.out.println("3. Update Stock");
        System.out.println("4. Remove stock");
        System.out.println("5. Exit");
        System.out.println("Enter your choice:");
    }
}