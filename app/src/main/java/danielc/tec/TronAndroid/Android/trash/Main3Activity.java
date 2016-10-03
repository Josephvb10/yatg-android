package danielc.tec.TronAndroid.Android.trash;

import android.os.Bundle;
import android.app.Activity;


public class Main3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomView view = new CustomView(this);
        setContentView(view);





    }
}
