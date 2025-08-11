

import java.math.BigDecimal;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        boolean exit=false;
        Scanner input=new Scanner(System.in);
        Portfolio portfolio = new Portfolio();
        while (!exit){

            printMenu();
            String inputNumber= input.nextLine();
            switch (inputNumber){
                case "1":
                    System.out.println("Enter stock symbol");
                    String stockSymbol = input.nextLine();
                    System.out.println("Enter stock price");
                    String stockPrice = input.nextLine();
                    System.out.println("Enter stock quantity");
                    String stockQuantity = input.nextLine();
                    Stock stock = new Stock(stockSymbol,new BigDecimal(stockPrice),new BigDecimal(stockQuantity));

                    portfolio.addStock(stock);
                    break;
                case "2":
                    portfolio.showPortfolio();
                    break;
                case "3":
                    System.out.println("Enter stock symbol to update");
                    String stockSymbolUpdate = input.nextLine();
                    System.out.println("Enter stock price to update(or -1 to leave it as it is)");
                    String stockPriceUpdate = input.nextLine();
                    System.out.println("Enter stock quantity to update(or -1 to leave it as it is)");
                    String stockQuantityUpdate = input.nextLine();
                    Stock stockUpdate = new Stock(stockSymbolUpdate,new BigDecimal(stockPriceUpdate),new BigDecimal(stockQuantityUpdate));
                    portfolio.updateStock(stockUpdate);
                    break;
                case "4":
                    System.out.println("Enter stock symbol to delete");
                    String stockSymbolDelete = input.nextLine();
                    portfolio.removeStock(stockSymbolDelete);
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