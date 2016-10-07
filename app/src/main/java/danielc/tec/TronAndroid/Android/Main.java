package danielc.tec.TronAndroid.Android;

import android.app.Application;
import android.content.Context;

/**
 * Created by DanielC on 6/10/16.
 */
public class Main extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        Main.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return Main.context;
    }
}
