import entities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static Collection myCollection = new Collection();


    //static List<Game> stock = new ArrayList<>();
    public static void main(String[] args) {
       initializeGames();
        System.out.println(Collection.printStatistics());
    }

    public static void initializeGames() {
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
