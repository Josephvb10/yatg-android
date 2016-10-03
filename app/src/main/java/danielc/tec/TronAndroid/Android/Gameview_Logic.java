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

public class Gameview_Logic extends SurfaceView  {

    public Gameview_Logic(Context context, AttributeSet attrs) {
        super(context, attrs);

        SurfaceHolder holder = this.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
                               @SuppressLint("WrongCall")
                               @Override
                               public void surfaceCreated(SurfaceHolder holder) {
                                   Canvas c = holder.lockCanvas();
                                   onDraw(c);
                                   holder.unlockCanvasAndPost(c);
                               }

                               @Override
                               public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

                               }

                               @Override
                               public void surfaceDestroyed(SurfaceHolder holder) {

                               }

                           }

        );

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        new ReadThread(canvas).start();

       /** ArrayList<Item> lista = new ArrayList<>();
        lista.add(new Item(ItemType.bomb, 1, 1));
        lista.add(new Item(ItemType.fuel, 2, 1));
        lista.add(new Item(ItemType.increaseTail, 6, 8));
        lista.add(new Item(ItemType.shield, 24, 4));
        lista.add(new Item(ItemType.turbo, 34, 25));
        lista.add(new Item(ItemType.bomb, 14, 19));



        ItemReceiver itemReceiver = new ItemReceiver(canvas);
        itemReceiver.eraseall();
        for (Item temp : lista) {
            itemReceiver.drawOnGame(temp);
        }**/


    }



}
