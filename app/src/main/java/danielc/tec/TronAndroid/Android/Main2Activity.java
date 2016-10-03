package danielc.tec.TronAndroid.Android;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import danielc.tec.helloworld.R;

public class Main2Activity extends AppCompatActivity {

    Button Get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        android.util.Log.d("MyApp","I am here");

        Get = (Button) findViewById(R.id.Button_Get);

        EditText getip = (EditText) findViewById(R.id.entry_ip);
        String client_ip = getip.getText().toString();

        EditText getport = (EditText) findViewById(R.id.entry_port);
        String client_port = getport.getText().toString();

        Get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**Intent next = new Intent(Main2Activity.this, Main3Activity.class);

                startActivity(next);*/

                Intent next = new Intent(Main2Activity.this, putamadre.class);

                startActivity(next);

            }
        });
    }
}
