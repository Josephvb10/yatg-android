package danielc.tec.TronAndroid.Android;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import danielc.tec.helloworld.R;

public class Activity_Username extends AppCompatActivity {


    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        next = (Button)findViewById(R.id.Button_Play);

        MediaPlayer main_theme = MediaPlayer.create(this, R.raw.theme1);

        if (!main_theme.isPlaying()) {
            main_theme.start();
            main_theme.setLooping(true);



        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText getnickname = (EditText) findViewById(R.id.entry_nickname);
                String client_nickname = getnickname.getText().toString();

                if (client_nickname.length() >= 4) {

                    android.util.Log.d("Entered Nickname", client_nickname);

                    Intent next = new Intent(Activity_Username.this, Activity_ip_port.class);

                    startActivity(next);
                }
                else {
                    android.util.Log.d("Error","No se ha ingresado ningun nickname");
                }
            }

        });{

        }

    }
}
