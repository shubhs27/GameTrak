import java.util.Scanner;       // importing scanner class from java.util package

public class Store extends Games{       // Store is child class of Games
    int stock, copiesSold, discount;
    protected double discountPrice;
    protected final static String couponCode="SHUBH10";     // coupon code cannot be changed and same for all objects
    Scanner sc= new Scanner(System.in);     // create scanner object

    Store(){
        super();        // used to call parent class default constructor
        stock= 0;
        copiesSold= 0;
        discount= 5;
        discountPrice= basePrice-discount/100.0* basePrice;
    }

    Store(String title, int releaseYear, String publisher, float rating, float basePrice, int stock, int copiesSold, int discount){
        super (title, releaseYear, publisher, rating, basePrice);      // used to call parent class parameterised constructor
        this.stock=stock;
        this.copiesSold=copiesSold;
        this.discount=discount;
        discountPrice= basePrice-discount/100.0* basePrice;
    }


    // abstract methods
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Game ID: " + gameID);
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Publisher: " + publisher);
        System.out.println("Rating: " + rating + "/10");
        System.out.println("\nStock: " + stock);
        System.out.println("Copies Sold: " + copiesSold);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Price: Rs" + discountPrice);
        System.out.println("--------------------------------");
    }


    void sell(){
        System.out.println("Price: Rs"+ discountPrice);

        if (stock>0){
            couponCode();   // if game is in stock first ask for coupon code

            stock--;        // decrement stock of game by 1
            copiesSold++;   // increment stock of game by 1
            System.out.println("Item sold successfully");
        }
        else {
            System.out.println("Out of Stock!!");
        }
    }

    void couponCode(){
        System.out.print("Do you have a coupon code (Y/N): ");
        String choice= sc.nextLine();

        if (choice.equals("Y")) {
            System.out.print("Enter the coupon code: ");
            String coupon = sc.nextLine();

            if (coupon.equals(couponCode)){     // if code entered is SHUBH10
                System.out.println("Coupon code applied\nExtra 10% discount!!\n");

                double couponDiscountPrice= discountPrice;
                couponDiscountPrice-= basePrice* 10/100.0;    // increase discount on game by 10
                System.out.println("Discounted Price: Rs"+ couponDiscountPrice);
            }
            else{
                System.out.println("Invalid coupon code!");
            }
        }
    }

    void addStock(){
        System.out.print("Enter the amount of games to be added (Stock): ");
        int inputStock= sc.nextInt();

        stock+= inputStock;
        System.out.println("Updated Stock: "+stock);
    }


    void changeDiscount(){
        System.out.println("Price: Rs"+ discountPrice);
        System.out.println("Discount: "+ discount+"%");

        System.out.print("Enter the change in discount %: ");
        int inputDiscount= sc.nextInt();

        discount+= inputDiscount;
        discountPrice= basePrice-discount/100.0* basePrice;

        System.out.println("Updated price: Rs"+ discountPrice);
    }

    // New Methods
    static void topGame(Store[] games){     // static method so object doesn't need to be created to call method
        float maxRating=0.0f;
        int maxCopiesSold=0;
        String titleRated="", idRated="", titleSelling="", idSelling="";

        for (Store game: games){
            if (game.rating>=maxRating){        // rating of game is greater than rating of previous games
                maxRating= game.rating;         // store details of the game (object)
                titleRated= game.title;
                idRated= game.gameID;
            }
            if (game.copiesSold>=maxCopiesSold){
                maxCopiesSold= game.copiesSold;
                titleSelling= game.title;
                idSelling= game.gameID;
            }
        }
        System.out.println("Top Rated Game: "+ titleRated+ " ("+ idRated + ")");
        System.out.println("Top Selling Game: "+ titleSelling+ " ("+ idSelling + ")");
    }

    static void avgRating(Store[] games){
        float avgRating, avgCopiesSold, sumRating=0.0f, sumCopiesSold=0.0f;

        for (Store game: games){
            sumRating+= game.rating;
            sumCopiesSold+= game.copiesSold;
        }
        try{
            avgRating=sumRating/count;      // code will not show error message if count is 0 (division by 0 error)
            avgCopiesSold= sumCopiesSold/count;
        }
        catch(ArithmeticException e){       // when count is 0 it will throw exception
            throw new ArithmeticException("No Games Available");
        }

        System.out.println("Average Game Rating: "+ avgRating);
        System.out.println("Average Game copies sold: "+ avgCopiesSold);
    }

    static void displayGamesInBudget(Store[] games, float budget) {
        int count = 0;

        for (Store game : games) {
            if (budget >= game.discountPrice) {
                System.out.println(game.title + " (" + game.gameID + ")");
                count++;
            }
        }

        System.out.println("Number of games in your budget: " + count);
    }
}