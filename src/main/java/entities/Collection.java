package entities;
//Create a "Collection" class that implements the following methods:

//    Collection statistics: print the total number of video games and board games present, the game with the highest price, and the average price of all elements.

import java.util.*;
import java.util.stream.Collectors;

public class Collection {
    public static Map<String, Game> archive = new HashMap<>();
    private static int idCounter = 100;

    // add game
    public static void addGame(Game game) {
        if(archive.containsKey(game.getGameId())){
            throw new IllegalArgumentException("Error: A game with this ID already exists: " + game.getGameId() + ": " + game.getTitle());
        }
        archive.put(game.getGameId(), game);
    }
    // generate id - not allowing user to type id. not part of the exercises, but an architectural choice.
    public static String createId(String type) {
        if (type.equalsIgnoreCase("VG")) {
            return "VG-" + idCounter++;
        } else if (type.equalsIgnoreCase("BG")) {
            return "BG-" + idCounter++;
        }
        throw new IllegalArgumentException("Unknown game type");
    }

    // find game by id
    public static Optional<Game> findById(String id) {
        return archive.values().stream()
                .filter(g -> g.getGameId().equals(id))
                .findFirst();
    }

    // search by price
    public static List<Game> findCheaperThan(double maxPrice) {
        return archive.values().stream()
                .filter(g -> g.getPrice() < maxPrice)
                .collect(Collectors.toList());
    }

    // search by number of players - so only boardgames
    public static List<BoardGame> findByPlayersCount(int players) {
        return archive.values().stream()
                .filter(g -> g instanceof BoardGame)
                .map(g ->(BoardGame) g)
                .filter(bg -> bg.getMaxPlayers() == players)
                .collect(Collectors.toList());
    }

    // remove an element given an ID code
    public static void removeGameById(String id) {
       if(!archive.containsKey(id)){
           throw new NoSuchElementException("Cannot remove: ID " + id + " not found.");
       }
        archive.remove(id);
    }

    // Update an existing element given the ID
    public static void updateGame(String id, Game updatedGame) {
         if(!archive.containsKey(id)){
           throw new NoSuchElementException("Cannot update: ID " + id + " not found.");
       }
         archive.put(id, updatedGame);
    }
    // game with the highest price
    public static String getMostExpensiveGame(){
        return archive.values().stream()
                .max(Comparator.comparingDouble(Game::getPrice))
                .map(Game::getTitle)
                .orElse("no games found");
    }

public static boolean printAllGames() {
    if (archive.isEmpty()) {
        System.out.println("The archive is currently empty.");
        return false;
    } else {
        archive.values().forEach(System.out::println);
        return true;
    }

}



    // games statistics
    public static Object printStatistics() {
        // print the total number of video games and board games
        long totalVideoGames = archive.values().stream().filter(g -> g instanceof VideoGame).count();
        long totalBoardGames = archive.values().stream().filter(g -> g instanceof BoardGame).count();

        //Optional<Game> mostExpensive = archive.values().stream().max(Comparator.comparingDouble(Game::getPrice));

        // average price of all elements
        double avgPrice = archive.values().stream()
                .mapToDouble(Game::getPrice)
                .average().stream().average().orElse(0.0);

        // print everything
        System.out.println("---- ALL STATISTICS ----");
        System.out.println("Total Video Games: " + totalVideoGames);
        System.out.println("Total Board Games: " + totalBoardGames);
        System.out.println("Most expensive game:" + getMostExpensiveGame());
        System.out.println("Average price: " + String.format("%.2f", avgPrice));
        return null;
    }
}

