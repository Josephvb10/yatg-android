package danielc.tec.TronAndroid.Android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

import danielc.tec.TronAndroid.GameStructures.Item;
import danielc.tec.TronAndroid.GameStructures.ItemType;

/**
 * Created by DanielC on 2/10/16.
 */

public class Gameview_Logic extends SurfaceView implements Runnable {
    Thread t = null;
    boolean itItOK = false;
    SurfaceHolder holder;

    public Gameview_Logic(Context context, AttributeSet attrs) {
        super(context, attrs);
        holder = getHolder();
    }
    public void run() {
        while (itItOK==true) {
            if (!getHolder().getSurface().isValid()){
                continue;
            }
            Canvas c = holder.lockCanvas();
            draw(c);
            holder.unlockCanvasAndPost(c);
        }
    }
    public void pause() {
        itItOK=false;
        while (true){
            try{
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }break;
        }t = null;
    }
    public void resume() {
        itItOK=true;
        t = new Thread(this);
        t.start();
    }






    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ItemReceiver itemReceiver = new ItemReceiver(canvas);
        itemReceiver.eraseall();
        Item item = new Item(ItemType.bomb,4,4);
        itemReceiver.drawOnGame(item);

    }

}
