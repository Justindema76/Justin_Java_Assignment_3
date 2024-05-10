import objects.*;
import utility.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StockUp {
  private static Scanner input = new Scanner(System.in);
  private static Ink ink = new Ink();
  private static Validator validator = new Validator();
  private static Market market = new Market();
  private static Portfolio portfolio;


  private static int min = 1; // used for menu selections
  private static int max = 4; // we need a way to set that based on menu items!!
  private static boolean isDone = false;
  private static boolean goBack = false;

  // ANSI escape codes for color formatting
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static void main(String[] args) {

    ink.printWelcome();

    double deposit = validator.depositValidation(ink, input, Double.MIN_VALUE);
   
    portfolio = new Portfolio(deposit);

    seedStocks(); // seed out stocks with some pretend stocks
    seedMarket(); // creates our test Market stocks

    while(!isDone) {
      int choice = validator.selValidation(ink, input, min, max);
    
      switch (choice) {
        case 1: // print portfolio
        System.out.println();   
        ink.printPortfolio(portfolio.getStocks(), portfolio.getNetworth(),
            portfolio.getBalance());
            System.out.println(); 
             
          break;
        case 2: // print market
          while(!goBack) {
            System.out.println(); 
            ink.printMarket(market.getStocks(), input);
            int idx = input.nextInt();
            Stock stock = market.getStock(idx - 1);
            ink.printStock(stock);
            int qty = input.nextInt();
            boolean isSuccess = market.buyStocks(stock, qty, portfolio.getBalance());
            if(isSuccess) {
              double purchaseAmount = stock.getPrice() * qty; 
              portfolio.buyStock(stock, qty, purchaseAmount);
              goBack = !goBack;
              System.err.println();
              System.out.println(ANSI_YELLOW + "Your purchash of " + qty + ANSI_YELLOW +
              " units of " + stock.getName() + ANSI_YELLOW +
              " for a total of $" + purchaseAmount + " is successful.");
              
            } // if
          } // while
          goBack = !goBack; // resets goBack to false
          break;
        case 3: // add funds
          double amount = validator.fundValidation(ink, input, portfolio.getBalance());
          portfolio.addFunds(amount);
          // print the new balance
          System.out.printf("New balance: $%.2f\n", portfolio.getBalance());
          break;
        case 4:
          isDone = !isDone;
          break;
      } // switch
    } // while
    ink.printGoodday();
  } // main()

  public static void seedStocks() {
    // the purpose is to create some TEST stocks!
    Stock stock = new Stock(ANSI_CYAN + "Microsoft", "MSFT", 420.00, 100 );
    portfolio.addStock(stock);
    stock = new Stock(ANSI_GREEN + "Uber", "UBR", 120.00, 50);
    portfolio.addStock(stock);
    stock = new Stock(ANSI_PURPLE + "Nvidia", "NVD", 250.00, 90);
    portfolio.addStock(stock);
    stock = new Stock(ANSI_BLUE + "Apple", "APL", 250.00, 0);
    portfolio.addStock(stock);
  } // seedStocks()

  public static void seedMarket() {
    ArrayList<Stock> stocks = new ArrayList<>();
    // the purpose is to create some TEST stocks for the Market
    Stock stock = new Stock(ANSI_CYAN + "Adobe", "ADB", 20.00, 0);
    stocks.add(stock);
    stock = new Stock(ANSI_GREEN + "Netflix", "NFX", 120.00, 0);
    stocks.add(stock);
    stock = new Stock(ANSI_BLUE + "Apple", "APL", 250.00, 0);
    stocks.add(stock);
    stock = new Stock(ANSI_RED + "Disney", "MOUSE", 1250.00, 0);
    stocks.add(stock);
    stock = new Stock(ANSI_CYAN + "Microsoft", "MSFT", 420.00, 0);
    stocks.add(stock);
    stock = new Stock(ANSI_GREEN + "Uber", "UBR", 120.00, 0);
    stocks.add(stock);
    stock = new Stock(ANSI_PURPLE + "Nvidia", "NVD", 900.00, 0);
    stocks.add(stock);
    market.setStocks(stocks);
}

} // class