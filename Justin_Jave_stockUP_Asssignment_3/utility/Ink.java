package utility;
import java.util.ArrayList;
import java.util.Scanner;

import objects.*;

public class Ink {
  
   // ANSI escape codes for color formatting
   public static final String ANSI_RESET = "\u001B[0m";
   public static final String ANSI_YELLOW = "\u001B[33m";
   public static final String ANSI_GREEN = "\u001B[32m";
   public static final String ANSI_CYAN = "\u001B[36m";
   public static final String ANSI_RED = "\u001B[31m";
   public static final String ANSI_BLUE = "\u001B[34m";
   public static final String ANSI_BLACK = "\u001B[30m";
   public static final String ANSI_WHITE = "\u001B[37m";
   public static final String ANSI_PURPLE = "\u001B[35m";
       
   public Ink() {
    // do nothing
  }

  public void printWelcome() {
    System.out.println(ANSI_YELLOW + "🌎$$$ Welcome to StockUP beta $$$🌎\n" + ANSI_RESET);
    
  }
  
  public void printStock(Stock stock) {
    System.out.println(ANSI_RED + 
    "-------------------------------------------------------------------------" + ANSI_RESET);
    System.out.printf(ANSI_BLUE + "Name: %-10s\nSymbol: %-10s\nPrice: $%.2f",
      stock.getName(), stock.getSymbol(), stock.getPrice());

    System.err.println();  
    System.out.println(ANSI_YELLOW + "\nHow many units of this stock would you like?? " + ANSI_RESET);
  } // printStock()

  public void printPortfolio(ArrayList<Stock> stocks, double networth, double balance) {
    double totalPortfolioValue = 0.0;
    System.out.println(ANSI_RED + "-------------------------------------------------------------------------" + ANSI_RESET);
    System.out.println(ANSI_YELLOW + "⚡️PORTFOLIO " + ANSI_RESET);
    System.out.println(ANSI_RED + "-------------------------------------------------------------------------" + ANSI_RESET);
    System.out.printf(ANSI_YELLOW + "%-7s %-10s %-10s %-12s %-8s %-10s\n" + ANSI_RESET, "Index", "Name", "Symbol", "Price ($)", "Qty", "Value ($)");
    System.out.println(ANSI_RED + "-------------------------------------------------------------------------" + ANSI_RESET);
    
    for(int i = 0; i < stocks.size(); i++) {
      Stock stock = stocks.get(i);
      double totalStockValue = stock.getPrice() * stock.getQty();
      totalPortfolioValue += totalStockValue;
      
      System.out.print(ANSI_YELLOW);
      System.out.printf("%-7d", i + 1);
      System.out.print(ANSI_RESET);
      System.out.printf(" %-15s %-10s %-12.2f %-8d %-10.2f\n",
      stock.getName(), stock.getSymbol(), stock.getPrice(), stock.getQty(), totalStockValue);
    }
    networth = balance + totalPortfolioValue;
    System.out.println(ANSI_RED + "-------------------------------------------------------------------------" + ANSI_RESET);
    System.out.println();
    System.out.printf(ANSI_YELLOW + "Balance: $" + "%.2f\n" + ANSI_RESET, balance);
    System.out.printf(ANSI_YELLOW + "Networth: $" + "%.2f\n" + ANSI_RESET, networth);
    
    System.out.println();

  } // printPortfolio()

  public void printMarket(ArrayList<Stock> stocks, Scanner input) {
    System.out.println(ANSI_RED + "-------------------------------------------------------------------------" + ANSI_RESET);
    System.out.println(ANSI_YELLOW + "⚡️MARKET " + ANSI_RESET);
    System.out.println(ANSI_RED + "-------------------------------------------------------------------------" + ANSI_RESET);
    System.out.printf(ANSI_YELLOW + "%-7s %-10s %-10s %-25s\n" + ANSI_RESET, "Index", "Name", "Symbol", "Price ($)");
    System.out.println(ANSI_RED + "-------------------------------------------------------------------------" + ANSI_RESET);
    for(int i = 0; i < stocks.size(); i++) {
        Stock stock = stocks.get(i);
        System.out.printf(ANSI_YELLOW + "%-7d %-15s %-10s %-12.2f\n",
            i + 1, stock.getName(), stock.getSymbol(), stock.getPrice());
    }
    System.out.println(ANSI_RED + "-------------------------------------------------------------------------" + ANSI_RESET);
    System.out.print(ANSI_YELLOW + "Which stock would you like to buy?: " + ANSI_RESET);
      
  }
  
  public void printMenu() {
    System.out.println(ANSI_RED + "--------------------------------------------------------------" + ANSI_RESET);
    System.out.print(ANSI_YELLOW + "⚡️MENU " + ANSI_RESET);
    System.out.printf("%s(1) Portfolio  (2) Stocks  (3) Add Funds  (4) Exit%s\n", ANSI_YELLOW, ANSI_RESET);
    System.out.println(ANSI_RED + "--------------------------------------------------------------" + ANSI_RESET);
} // printMenu()



  public void printStockDetail(Stock stock) {
    System.out.printf(ANSI_YELLOW + "Name: %s Symbol: %s Price: %d Qty: %d",
      stock.getName(), stock.getSymbol(), 
      stock.getPrice(), stock.getQty());
  }

  public void printAddFunds(double balance) {
    System.out.print(ANSI_GREEN + "PLEASE ENTER YOUR DEPOSIT AMOUNT: $" + ANSI_RESET);   
}

public void printGoodday() {
  System.out.println(ANSI_YELLOW + "$$$ Richer Every Day with stockUP $$$\n");
}

} // class