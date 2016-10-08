package danielc.tec.TronAndroid.Android;

import android.content.Context;
import android.media.MediaPlayer;
import danielc.tec.helloworld.R;

/**
 * Created by DanielC on 5/10/16.
 */
public class Game_Sounds {
    private static Game_Sounds ourInstance = new Game_Sounds();

    /**
     * Return the instance of the singleton
     * @return
     */
    public static Game_Sounds getInstance() {
        return ourInstance;
    }

    boolean music_flag = true;
    boolean music_flag2 = true;

    private Game_Sounds() {
    }

    /**
     * Return the flag true or false depending if the music is playing
     * @return boolean
     */
    public boolean started(){
        return music_flag;

    }
}
