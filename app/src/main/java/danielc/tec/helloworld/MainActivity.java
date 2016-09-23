package danielc.tec.helloworld;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = (Button)findViewById(R.id.Button_Play);

        final MediaPlayer main_theme = MediaPlayer.create(this, R.raw.theme1);
        main_theme.start();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText getnickname = (EditText) findViewById(R.id.entry_nickname);
                String client_nickname = getnickname.getText().toString();

                if (client_nickname != "") {

                    android.util.Log.d("Entered Nickname", client_nickname);

                    Intent next = new Intent(MainActivity.this, Main2Activity.class);

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
