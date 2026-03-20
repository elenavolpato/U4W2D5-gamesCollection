import entities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    //static Collection myCollection = new Collection();
    public static void main(String[] args) {
        addGamesToStock();
        //System.out.println(Collection.printStatistics());
        Scanner scanner = new Scanner(System.in);

        //The user must be able to access all operations via a Scanner. Use Java Streams and Lambda functions to implement the algorithms.
        System.out.println(Collection.printAllGames());

        System.out.println("What would you like to do?");

        System.out.println("1 - add a game");
        System.out.println("2 - delete a game");
        System.out.println("3 - find a game using id") ;

        int inputAction = scanner.nextInt();

        switch(inputAction){
            case 1: {
                System.out.println("Type of game? 1 for Board Game or 2 for Video Game");
                int typeOfGame = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Name of the game");
                String name = scanner.nextLine();

                System.out.println("Release Year");
                int year = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Price");
                double price = scanner.nextDouble();
                scanner.nextLine();

                String id = "";

                if (typeOfGame == 1) {
                    id = Collection.createId("BG");
                    System.out.println("Max players");
                    int maxPlayers = scanner.nextInt();

                    System.out.println("How long does a match last?");
                    int matchDuration = scanner.nextInt();

                    Collection.addGame(new BoardGame(id, name, year, price, maxPlayers, matchDuration));
                } else if (typeOfGame == 2) {
                    id = Collection.createId("VG");

                    System.out.println("Platform");
                    String platform = scanner.nextLine();

                    System.out.println("Game duration");
                    int gameDuration = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Genre of the game");
                    System.out.println("1 - ACTION");
                    System.out.println("2 - ADVENTURE");
                    System.out.println("3 - RPG");
                    System.out.println("4 - STRATEGY");
                    System.out.println("5 - SPORTS");
                    System.out.println("6 - SIMULATION");

                    String genreCode = scanner.nextLine();
                    Genre genre;

                    switch (genreCode) {
                        case "1" -> genre = Genre.ACTION;
                        case "2" -> genre = Genre.ADVENTURE;
                        case "3" -> genre = Genre.RPG;
                        case "4" -> genre = Genre.STRATEGY;
                        case "5" -> genre = Genre.SPORTS;
                        case "6" -> genre = Genre.SIMULATION;
                        default -> {
                            System.out.println("Invalid choice, defaulting to ACTION.");
                            genre = Genre.ACTION;
                        }
                    }
                    Collection.addGame(new VideoGame(id, name, year, price, platform, gameDuration, genre));


                } else System.out.println("Type of game not valid");
                break;
            }
            case 2: {
                System.out.println("Enter game ID");
                String id = scanner.nextLine();
                if(Collection.archive.values().contains(id))  Collection.removeGameById(id);
                 else System.out.println("Id invalid.");
                break;
            }
            case 3: {
                System.out.println("Enter game ID");
                String id = scanner.nextLine();
                Collection.findById(id);
            }
        }
        System.out.println(Collection.printAllGames());

    }

    public static void addGamesToStock() {
        // board games
        Collection.addGame(new BoardGame(Collection.createId("BG"), "Settlers of Catan", 1985, 45.5, 4, 45));
        Collection.addGame(new BoardGame(Collection.createId("BG"), "Dominion", 1999, 38.9, 4, 60));
        Collection.addGame(new BoardGame(Collection.createId("BG"), "Clue", 1975, 22.0, 8, 35));
        Collection.addGame(new BoardGame(Collection.createId("BG"), "Carcassone", 1988, 36.8, 4, 45));
        // video games
        Collection.addGame(new VideoGame(Collection.createId("VG"), "Age of Empires IV", 2022, 45.8, "PC", 60, Genre.STRATEGY));
        Collection.addGame(new VideoGame(Collection.createId("VG"), "The Legend of Zelda: Ocarina of Time", 1998, 129, "Nintendo 64", 300, Genre.ADVENTURE));
        Collection.addGame(new VideoGame(Collection.createId("VG"), "Legend of Zelda: Tears of the Kingdom", 2022, 69.9, "Nintendo Switch", 250, Genre.ADVENTURE));
        Collection.addGame(new VideoGame(Collection.createId("VG"), "The Witcher 3", 2014, 39.9, "PC", 300, Genre.RPG));
    }

}
;