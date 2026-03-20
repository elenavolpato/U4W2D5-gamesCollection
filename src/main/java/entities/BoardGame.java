package entities;

//Board games instead have:
//    Number of players (range from 2 to 10)
//    Average match duration (in minutes)

public class BoardGame extends Game{
    private int maxPlayers;
    private int matchDuration;

    public BoardGame(String gameId, String title, int year, double price, int maxPlayers, int matchDuration){
        super(gameId,  title, year,price);
        this.matchDuration = matchDuration;

        if(maxPlayers < 2 || maxPlayers >10){
            throw new IllegalArgumentException("Players must be between 2 and 10");
        }
        this.maxPlayers = maxPlayers;
    }

    public int getMaxPlayers(){
        System.out.println("maxPlayers: " + maxPlayers);
        return maxPlayers;
    }
    public int getMatchDuration(){
        System.out.println("matchDuration: " + matchDuration);
        return matchDuration;
    }
}
