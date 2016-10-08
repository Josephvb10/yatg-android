package danielc.tec.TronAndroid.Android;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

import danielc.tec.TronAndroid.Comunication.JsonParser;
import danielc.tec.TronAndroid.GameStructures.Item;

/**
 * Created by DanielC on 2/10/16.
 */

public class Gameview_Logic extends SurfaceView implements Runnable {
    Thread t = null;
    boolean itItOK = false;
    SurfaceHolder holder;

    /**
     * Method created for gameview
     * @param context
     * @param attrs
     */
    public Gameview_Logic(Context context, AttributeSet attrs) {
        super(context, attrs);
        holder = getHolder();
    }

    /**
     * Thread that draws all in the gamesurface
     */
    public void run() {
        while (itItOK == true) {
            JsonParser.getInstance().getPlayerData().setSpeed(10);
            if (JsonParser.getInstance().getPlayerData().isDead()) {
                pause();

            }
            if (!getHolder().getSurface().isValid()) {
                continue;
            }
            Canvas c = holder.lockCanvas();
            draw(c);
            ItemDrawer itemDrawer = new ItemDrawer(c);
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

    /**
     * This Method pauses the thread
     */
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

    /**
     * the method onDraw
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (itItOK == false) {
            resume();

        }

    }
}
