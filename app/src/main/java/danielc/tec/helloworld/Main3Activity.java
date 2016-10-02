package danielc.tec.helloworld;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Activity;


public class Main3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        CustomView view = new CustomView(this);
        setContentView(view);


    }
}
