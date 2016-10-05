package danielc.tec.TronAndroid.Android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import danielc.tec.helloworld.R;

import static java.util.logging.Logger.global;

public class Activity_Username extends AppCompatActivity {

    static String username;


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
                String client_nickname = getnickname.getText().toString().trim();
                username = client_nickname;

                if (client_nickname.length() >= 4) {

                    android.util.Log.d("Entered Nickname", client_nickname);



                    Intent next = new Intent(Activity_Username.this, Activity_ip_port.class);

                    startActivity(next);
                }
                else {
                    AlertDialog alertDialog = new AlertDialog.Builder(Activity_Username.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("Your username must have at least 4 characters.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK, Im an idiot",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    android.util.Log.d("Error","No se ha ingresado ningun nickname");
                }
            }

        });{

        }

    }
}