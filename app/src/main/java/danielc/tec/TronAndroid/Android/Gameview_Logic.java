package danielc.tec.TronAndroid.Android;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import danielc.tec.TronAndroid.Comunication.JsonParser;
import danielc.tec.TronAndroid.GameStructures.Item;
import danielc.tec.helloworld.R;

/**
 * Created by DanielC on 2/10/16.
 */

public class Gameview_Logic extends SurfaceView implements Runnable {
    Thread t = null;
    boolean itItOK = false;
    SurfaceHolder holder;
    Bitmap btmBomb = BitmapFactory.decodeResource(getResources(), R.drawable.bomb);
    Bitmap btmShield = BitmapFactory.decodeResource(getResources(), R.drawable.bomb);
    Bitmap btmSpeed = BitmapFactory.decodeResource(getResources(), R.drawable.bomb);
    Bitmap btmTail = BitmapFactory.decodeResource(getResources(), R.drawable.bomb);
    Bitmap btmGas = BitmapFactory.decodeResource(getResources(), R.drawable.bomb);
    public Gameview_Logic(Context context, AttributeSet attrs) {
        super(context, attrs);
        holder = getHolder();
    }

    public void run() {
        while (itItOK == true) {
            if (!getHolder().getSurface().isValid()) {
                continue;
            }
            Canvas c = holder.lockCanvas();
            draw(c);
            ItemDrawer itemDrawer = new ItemDrawer(c,btmBomb);
            itemDrawer.eraseall();
            ArrayList<Item> items = JsonParser.getInstance().getPlayerItems();
            if (items != null) {
                for (Item data : items) {
                    final ItemDrawer itemDrawerFinal = itemDrawer;
                    final Item dataFinal = data;

                    itemDrawerFinal.drawOnGame(dataFinal);


                }

            }

            holder.unlockCanvasAndPost(c);
        }
    }


    public void pause() {
        itItOK = false;
        while (true) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
        t = null;
    }

    public void resume() {
        itItOK = true;
        t = new Thread(this);
        t.start();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            pause();
        }
        else if(keyCode == KeyEvent.KEYCODE_HOME)
        {
            pause();
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (itItOK == false) {
            resume();
        }

    }

}
