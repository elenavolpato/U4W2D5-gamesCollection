////Video games also have:
////    Platform (e.g., PC, PS5, Xbox)
////    Game length (in hours)
////    Genre (an enum with a list of genres of your choice)

package entities;

public class VideoGame extends Game{
    private String platform;
    private double gameDuration;
    private Genre genre;

    public VideoGame(String gameId, String title, int year, double price, String platform, double gameDuration, Genre genre){
        super(gameId,  title, year,price);
        this.platform = platform;
        this.gameDuration = gameDuration;
        this.genre = genre;
    }

    public String getPlatform(){
        System.out.println("Platform: " + platform);
        return platform;
    }
    public double getGameDuration(){
        System.out.println("gameDuration: " + gameDuration);
        return gameDuration;
    }
    public Genre getGenre(){
        System.out.println("Genre: " + genre);
        return genre;
    }

}
