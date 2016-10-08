package danielc.tec.TronAndroid.Android;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import danielc.tec.TronAndroid.Comunication.JsonParser;
import danielc.tec.TronAndroid.Comunication.TronClient;
import danielc.tec.helloworld.R;

public class Activity_Game extends Activity {
    Button Up;
    Button Down;
    Button Left;
    Button Right;
    Button Turbo;
    Button Shield;
    TextView Power;
    private ProgressBar mProgress;

    /**
     * This Method creates the activity and his components
     * @param savedInstanceState
     */
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
        Turbo = (Button) findViewById(R.id.btnTurbo);
        Shield = (Button) findViewById(R.id.btnShield);
        Power = (TextView) findViewById(R.id.CurrentPower);

        Up.setOnClickListener(new View.OnClickListener() {
            /**
             * Send direction up to the server
             * @param v is a view
             */
            @Override
            public void onClick(View v) {
                TronClient.getInstance().send("%DL");
            }
        });
        Down.setOnClickListener(new View.OnClickListener() {
            /**
             * Send direction down to the server
             * @param v is a view
             */
            @Override
            public void onClick(View v) {
                TronClient.getInstance().send("%DR");
            }
        });
        Left.setOnClickListener(new View.OnClickListener() {
            /**
             * Send direction Left to the server
             * @param v is a view
             */
            @Override
            public void onClick(View v) {
                TronClient.getInstance().send("%DU");
            }
        });
        Right.setOnClickListener(new View.OnClickListener() {
            /**
             * Send direction Right to the server
             * @param v is a view
             */
            @Override
            public void onClick(View v) {
                TronClient.getInstance().send("%DD");
            }
        });


        Turbo.setOnClickListener(new View.OnClickListener() {
            /**
             * Send a signal to the server for use the power-up
             * @param v is a view
             */
            @Override
            public void onClick(View v) {
                TronClient.getInstance().send("%IT");
            }
        });
        Shield.setOnClickListener(new View.OnClickListener() {
            /**
             * Send a change of position of the power-up
             * @param v is a view
             */
            @Override
            public void onClick(View v) {
                TronClient.getInstance().send("%ID");
            }
        });

        new Thread() {
            /**
             * This thread shows the remaining fuel in the progress bar
             */
            public void run() {
                while (true) {
                    Utils.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {

                                mProgress.setProgress((int) JsonParser.getInstance().getPlayerData().getFuel());
                                if (JsonParser.getInstance().getPowerUps().size() == 0){
                                    Power.setText("-");
                                }else {
                                    Power.setText(JsonParser.getInstance().getPowerUps().get(0).getType().toString());
                                }
                            } catch (Exception ignored) {

                            }
                        }
                    });
                }
            }
        }.start();

    }
}