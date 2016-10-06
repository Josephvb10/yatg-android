package danielc.tec.TronAndroid.Android;

import android.content.Context;
import android.media.MediaPlayer;
import danielc.tec.helloworld.R;

/**
 * Created by DanielC on 5/10/16.
 */
public class Game_Sounds {
    private static Game_Sounds ourInstance = new Game_Sounds();

    public static Game_Sounds getInstance() {
        return ourInstance;
    }

    boolean music_flag = true;


    private Game_Sounds() {
    }

    public boolean started(){
        return music_flag;

    }

    public void already_started (){
        music_flag = false;
    }

}
