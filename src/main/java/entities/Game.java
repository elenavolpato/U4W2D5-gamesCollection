package entities;

public abstract class  Game {
    private String gameId;
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
        System.out.println("Game ID: " + gameId);
        return gameId;
    }

    public String getTitle(){
        System.out.println("Game title: " + title);
        return title;
    }
    public int getYear(){
        System.out.println("Year : " + year);
        return year;
    }

    public double getTPrice(){
        System.out.println("Game Price: " + price);
        return price;
    }
}
