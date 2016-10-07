package danielc.tec.TronAndroid.Android;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.io.IOException;

import danielc.tec.TronAndroid.Comunication.TronClient;
import danielc.tec.helloworld.R;

public class Activity_ip_port extends AppCompatActivity {
    String playerUsername;
    String playerIp;
    int playerPort;
    Button Get;

    public ProgressDialog progress;

    private static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }



    private void startGame() throws IOException {

        new Thread() {
            public void run() {
                Utils.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showProgress();
                    }
                });

                if (!TronClient.getInstance().connect(playerIp, playerPort)) {
                    error("Error", "Can't connect to server. Please verify the IP and port.");
                    return;
                }

                String joinMsg = TronClient.getInstance().joinIfCan(playerUsername);
                if (!joinMsg.equals("OK")) {
                    error("Error", joinMsg);
                    return;
                }

                success();
            }
        }.start();

    }

    private void showProgress() {
                progress = new ProgressDialog(this);
                progress.setTitle("Please wait");
                progress.setMessage("Connecting to server...");
                progress.show();
    }

    private void error(String title, String msg) {
        final String ftitle = title;
        final String fmsg = msg;

        Utils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progress.dismiss();
                AlertDialog alertDialog = new AlertDialog.Builder(Activity_ip_port.this).create();
                alertDialog.setTitle(ftitle);
                alertDialog.setMessage(fmsg);
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK, Im an idiot",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

    }

    private void success() {
        Utils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progress.dismiss();
                Intent next = new Intent(Activity_ip_port.this, Activity_Game.class);
                startActivity(next);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        android.util.Log.d("MyApp","I am here");




        Get = (Button) findViewById(R.id.Button_Get);
        Get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {

                EditText getip = (EditText) findViewById(R.id.entry_ip);
                playerIp = getip.getText().toString().trim();
                playerUsername = Activity_Username.username;
                EditText getport = (EditText) findViewById(R.id.entry_port);
                String checkPort = getport.getText().toString().trim();

                if (playerIp.length() != 0 && checkPort.length() != 0 && playerUsername.length() != 0 && isNumeric(checkPort) && playerIp != null) {
                    try {
                        playerPort = Integer.parseInt(checkPort);
                    } catch (Exception e) {

                    }
                    if (0 <= playerPort & playerPort <= 9999) {
                        startGame();
                    } else {
                        AlertDialog alertDialog = new AlertDialog.Builder(Activity_ip_port.this).create();
                        alertDialog.setTitle("ERROR:");
                        alertDialog.setMessage("Please checkout the port: Insert a port between 0 and 9999");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK, Im an idiot",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(Activity_ip_port.this).create();
                    alertDialog.setTitle("ERROR: Please fill the required data");
                    alertDialog.setMessage("Example: \n" +
                            "\tUsername: HailHarambe69 \n" +
                            "\tIP: 292.168.1.2 \n" +
                            "\tPort: 9697 ");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK, Im an idiot",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            } catch (Exception e){
                e.printStackTrace();
            }

            }
        });
    }
}
