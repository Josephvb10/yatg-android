package danielc.tec.TronAndroid.Android;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by DanielC on 6/10/16.
 */

public class Utils {

    public static void runOnUiThread(Runnable runnable){
        final Handler UIHandler = new Handler(Looper.getMainLooper());
        UIHandler .post(runnable);
    }
}
