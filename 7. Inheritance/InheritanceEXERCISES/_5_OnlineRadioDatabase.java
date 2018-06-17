import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _5_OnlineRadioDatabase {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());
        List<Song> songs=new ArrayList<>();

        int totalMin=0;
        int totalSec=0;

        for(int i=0; i<n; i++){
            String input=reader.readLine();

            try{

                String[]tokens=input.split(";");
                String artist=tokens[0];
                String songName=tokens[1];
                String time=tokens[2];

                Song song=new Song(artist,songName,time);
                totalMin+=song.getMinutes();
                totalSec+=song.getSeconds();
                System.out.println("Song added.");
                songs.add(song);

            }catch (IllegalArgumentException error){
                System.out.println(error.getMessage());
            }
        }

        int totalLenghtInSeconds=totalMin*60+totalSec;

        int hours=totalLenghtInSeconds/3600;
        totalLenghtInSeconds=totalLenghtInSeconds%3600;
        int finMin=totalLenghtInSeconds/60;
        totalLenghtInSeconds=totalLenghtInSeconds%60;
        int finSec=totalLenghtInSeconds;

        System.out.printf("Songs added: %d%n",songs.size());

        System.out.printf("Playlist length: %dh %dm %ds%n",
                hours,finMin,finSec);

    }
}
class Song{
    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;

    public Song(String artistName, String songName, String time) {
        setArtistName(artistName);
        setSongName(songName);
        setTime(time);
    }

    private void setArtistName(String artistName) {
        if(artistName.trim().length()<3||artistName.trim().length()>20){
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if(songName==null||songName.trim().length()<3||songName.trim().length()>30){
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setTime(String time) {
        int minutes;
        int secondes;

        try{
            String[]timeTok=time.split(":");
            minutes=Integer.parseInt(timeTok[0]);
            secondes=Integer.parseInt(timeTok[1]);

        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid song length.");
        }

        if(minutes<0||minutes>14){
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }
        if(secondes<0||secondes>59){
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }
        this.minutes = minutes;
        this.seconds=secondes;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
