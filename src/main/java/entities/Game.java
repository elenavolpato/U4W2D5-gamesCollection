package entities;

public abstract class  Game {
    private final String gameId;
    private String title;
    private int year;
    private double price;

    Game(String gameId, String title, int year, double price){
        this.gameId = gameId;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getGameId(){
        return gameId;
    }

    public String getTitle(){
        return title;
    }
    public int getYear(){
        return year;
    }

    public double getPrice(){
        return price;
    }
}
