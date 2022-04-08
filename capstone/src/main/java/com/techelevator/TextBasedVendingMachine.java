package com.techelevator;

public class TextBasedVendingMachine implements VendingMachine{

    private int selectedProduct; //for the selectProduct() method
    private CoinBundle change; //from enterCoins() method

    @Override
    public void displayProducts() {
        //displays welcome message and choices
        System.out.println("Welcome to the vending machine");
        System.out.println("Products available");

        //gets values from the enum in the Product class (need to change)
        for(Product product: Product.values()){
            System.out.println("    " + product.getId()+ " " + product.name()+" - Price: " + product.getPrice());
        }

        //ask the user to select the product
        System.out.println("  ");
        System.out.println("  Please select your product: ");
    }

    @Override
    public void selectProduct(int product) {
        //saves the product selected by the user in a variable
        selectedProduct = product;

    }

    @Override
    public void displayEnterCoinsMessage() {
        //asks user to enter coins (need to change to bills)
        System.out.println("Please enter the coins as follows: ");
        System.out.println("Number of 5 cent coins, number of 10 cent coins, number of 25 cent coins");
        System.out.println("");
        System.out.println("Example: if you would like to enter 2 dimes, 0, 2, 0");
        System.out.println("Please enter coins");

    }

    @Override
    public void enterCoins(int... coins) {
        //receives the coins entered by the user, calculate total amount inserted and figure out change

        //create SimpleCalculator object which implements Calculator interface
        Calculator calculator = new SimpleCalculator();

        //gets this from Product class
        Product product = Product.valueOf(this.selectedProduct);

        //gets price
        int total = calculator.calculateTotal(new CoinBundle(coins));

        //total amount - price
        int changeAmount = total - product.getPrice();
        change = calculator.calculateChange(changeAmount);


    }

    @Override
    public void displayChangeMessage() {
        //displays a message letting the user know his change amount and coins.
        //.getTotal is from CoinBundle class
        System.out.println(" ");
        System.out.println("Your change is: "+ change.getTotal()+ "cents split as follows: ");
        System.out.println("   25 cent coins: "+ change.number25CentCoins);
        System.out.println("   10 cent coins: "+ change.number10CentCoins);
        System.out.println("   5  cent coins: "+ change.number5CentCoins);

    }
}
