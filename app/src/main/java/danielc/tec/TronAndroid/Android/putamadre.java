package danielc.tec.TronAndroid.Android;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import danielc.tec.helloworld.R;

public class putamadre extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        /**setContentView(new puta1 (getBaseContext()));**/
        setContentView(R.layout.activity_putamadre);
    }
}
