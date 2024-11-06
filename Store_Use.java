import java.util.InputMismatchException;
import java.util.Scanner;       // importing scanner class from java.util package

public class Store_Use{
    public static void main(String[] args) {
        // add games (create objects) manually
        Store game1 = new Store("Elden Ring", 2022, "FromSoftware Inc.", 10f, 5000, 40, 500, 15);
        Store game2 = new Store("God of War", 2018, "Sony Interactive Entertainment", 9.5f, 5000, 30, 400, 40);
        Store game3 = new Store("GTA V", 2013, "Rockstar Games", 9.1f, 4500, 100, 800, 30);
        Store game4 = new Store("Legend of Zelda", 2017, "Nintendo", 9.8f, 5000, 20, 200, 5);
        Store game5 = new Store("Ghost of Tsushima", 2020, "Sony Interactive Entertainment", 9.8f, 5000, 40, 300, 25);
        Store game6 = new Store("Forza Horizon 5", 2021, "Xbox Game Studios", 8.4f, 4800, 50, 150, 35);
        Store game7 = new Store("Mario Kart 8", 2014, "Nintendo", 8.6f, 5000, 20, 100, 10);
        Store game8 = new Store("Red Dead Redemption 2", 2018, "Rockstar Games", 9.3f, 4700, 40, 350, 20);
        Store game9 = new Store("It Takes Two", 2021, "Electronic Arts", 9.2f, 4000, 15, 150, 50);
        Store game10 = new Store("EA Sports FC 24", 2023, "Electronic Arts", 7.9f, 4800, 70, 120, 5);

        Store[] games = {game1, game2, game3, game4, game5, game6, game7, game8, game9, game10};      // store in array of objects

        // create scanner objects
        Scanner sc = new Scanner(System.in);
        Scanner scChoice = new Scanner(System.in);
        int choice = 0;
        String inputGameID;

        try {
            do {
                System.out.println("======================================");
                System.out.println("\nWelcome to the Video Games Store!!");
                System.out.println("1. Display all games");
                System.out.println("2. Search for a game (by Game ID)");
                System.out.println("3. Sell a game copy");
                System.out.println("4. Add stock of a game");
                System.out.println("5. Change discount of a game");
                System.out.println("6. Display the top game");
                System.out.println("7. Display average game rating");
                System.out.println("8. Display games in your budget");
                System.out.println("9. Exit\n");

                System.out.println("======================================");
                System.out.print("Enter your choice: ");

                choice = scChoice.nextInt();
                System.out.println("======================================\n");

                switch (choice) {
                    case 1:
                        for (Store game : games) {   // for each loop to traverse array of objects
                            game.display();     // call display method for every object
                        }
                        break;

                    case 2:
                        System.out.print("Enter the game ID: ");
                        inputGameID = sc.nextLine();
                        boolean gameFound = false;      // use flag to determine if game ID is present (default: not there)

                        for (Store game : games) {
                            if (game.gameID.equals(inputGameID)) {      // .equals is used to compare strings
                                game.display();
                                gameFound = true;       // game ID is present
                                break;
                            }
                        }
                        if (!gameFound) {
                            System.out.println("Game ID not found");
                        }
                        break;

                    case 3:
                        System.out.print("Enter the game ID: ");
                        inputGameID = sc.nextLine();
                        gameFound = false;

                        for (Store game : games) {
                            if (game.gameID.equals(inputGameID)) {
                                game.sell();
                                gameFound = true;
                                break;
                            }
                        }
                        if (!gameFound) {
                            System.out.println("Game ID not found");
                        }
                        break;

                    case 4:
                        System.out.print("Enter the game ID: ");
                        inputGameID = sc.nextLine();
                        gameFound = false;

                        for (Store game : games) {
                            if (game.gameID.equals(inputGameID)) {
                                game.addStock();
                                gameFound = true;
                                break;
                            }
                        }
                        if (!gameFound) {
                            System.out.println("Game ID not found");
                        }
                        break;

                    case 5:
                        System.out.print("Enter the game ID: ");
                        inputGameID = sc.nextLine();
                        gameFound = false;

                        for (Store game : games) {
                            if (game.gameID.equals(inputGameID)) {
                                game.changeDiscount();
                                gameFound = true;
                                break;
                            }
                        }
                        if (!gameFound) {
                            System.out.println("Game ID not found");
                        }
                        break;

                    case 6:
                        Store.topGame(games);
                        break;

                    case 7:
                        Store.avgRating(games);
                        break;

                    case 8:
                        System.out.print("Enter your budget: Rs");
                        float budget = sc.nextFloat();

                        Store.displayGamesInBudget(games, budget);
                        break;

                    default:    // whenever input is not from 1-9
                        System.out.println("Invalid! Enter a valid choice (1-9)!!");
                        break;
                }

            } while (choice != 9);
            System.out.println("Thank you for visiting our store!!");   // display after exiting do-while loop

        }catch (InputMismatchException e){
            System.out.println("Enter the appropriate input!");
        }
    }

}