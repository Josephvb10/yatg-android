package danielc.tec.TronAndroid.Android;

import android.os.Bundle;
import android.app.Activity;

import danielc.tec.TronAndroid.Android.CustomView;


public class Main3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomView view = new CustomView(this);
        setContentView(view);





    }
}
