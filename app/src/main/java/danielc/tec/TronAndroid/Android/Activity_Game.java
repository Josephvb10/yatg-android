package danielc.tec.TronAndroid.Android;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import danielc.tec.TronAndroid.Comunication.JsonParser;
import danielc.tec.TronAndroid.Comunication.TronClient;
import danielc.tec.helloworld.R;

import static danielc.tec.TronAndroid.Android.Activity_Username.username;

public class Activity_Game extends Activity {
    Button Up;
    Button Down;
    Button Left;
    Button Right;
    private ProgressBar mProgress;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.game_screen);
        Up = (Button) findViewById(R.id.btnUp);
        Down = (Button) findViewById(R.id.btnDown);
        Left = (Button) findViewById(R.id.btnLeft);
        Right = (Button) findViewById(R.id.btnRight);
        mProgress = (ProgressBar) findViewById(R.id.progress_Bar);

        Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TronClient.getInstance().send("%DL");
            }
        });
        Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TronClient.getInstance().send("%DR");
            }
        });
        Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TronClient.getInstance().send("%DU");
            }
        });
        Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TronClient.getInstance().send("%DD");
            }
        });



/**
        new Thread() {
            public void run() {
                while (true) {
                    Utils.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                mProgress.setProgress((int) JsonParser.getInstance().getPlayerData().getFuel());
                            } catch (Exception ignored) {

                            }
                        }
                    });
                }
            }
        }.start();**/

    }
}