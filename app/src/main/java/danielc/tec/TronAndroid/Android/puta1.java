package danielc.tec.TronAndroid.Android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import danielc.tec.TronAndroid.GameStructures.Item;
import danielc.tec.TronAndroid.GameStructures.ItemType;

/**
 * Created by DanielC on 2/10/16.
 */

public class puta1 extends SurfaceView {

    RectF cuadrito;
    public puta1(Context context, AttributeSet attrs) {
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
            Rect cuadro = new Rect();
            Paint black = new Paint();
            cuadro.set(0,0,canvas.getWidth(),canvas.getHeight());
            black.setColor(Color.BLACK);
            black.setStyle(Paint.Style.FILL);

            canvas.drawRect(cuadro, black);

            Paint red = new Paint();
            red.setColor(Color.BLUE);
            red.setStyle(Paint.Style.FILL_AND_STROKE);

            for (int i = 1; i <= 34; i++){
            for (int j = 1; j <= 34; j++) {
                //Rect cuadro = new Rect();
                int size = 29;
                cuadro.set(40 + size * j, i * size, 40 + size * j + size, i * size + size);

                //Paint black = new Paint();
                /**black.setColor(Color.BLACK);
                 black.setStyle(Paint.Style.FILL);
                 canvas.drawRect(cuadro, black);**/

                black.setColor(Color.CYAN);
                black.setStyle(Paint.Style.STROKE);
                canvas.drawRect(cuadro, black);
            }
            }

             ArrayList<Item> lista= new ArrayList<>();
             lista.add(new Item(ItemType.bomb,1,1) );
             lista.add(new Item(ItemType.fuel,2,1) );
             lista.add(new Item(ItemType.increaseTail,6,8) );
             lista.add(new Item(ItemType.shield,24,4) );
             lista.add(new Item(ItemType.turbo,34,25) );
             lista.add(new Item(ItemType.bomb,14,19) );


        class ItemReceiver {
            Rect cuadro = new Rect();
            Canvas canvas;

            public ItemReceiver(Canvas canvas){
                this.canvas = canvas;
                Log.w("puta1", "LLegué a ItemReceiver");
            }

             public void drawer(Item item, Paint paint){
                 Rect drawItem = new Rect();
                 int i = item.getIndexI();
                 int j = item.getIndexJ();
                 Log.e("puta1", "i: " + i + "j: " + j);
                 drawItem.set(40+29*j,i*29,40+29*j+29,i*29+29);
                 canvas.drawRect(drawItem, paint);
                 Log.w("puta1", "LLegué a Drawer");
             }
             public void drawOnGame (Item item) {
                 Log.w("puta1", "LLegué a drawOnGame");
                 switch (item.getType()) {
                     case bomb:
                         Paint red = new Paint();
                         red.setColor(Color.RED);
                         red.setStyle(Paint.Style.FILL);
                         drawer(item,red);
                         break;
                     case fuel:
                         Paint white = new Paint();
                         white.setColor(Color.WHITE);
                         white.setStyle(Paint.Style.FILL);
                         drawer(item,white);
                         break;
                     case increaseTail:
                         Paint green = new Paint();
                         green.setColor(Color.GREEN);
                         green.setStyle(Paint.Style.FILL);
                         drawer(item,green);
                         break;
                     case shield:
                         Paint blue = new Paint();
                         blue.setColor(Color.BLUE);
                         blue.setStyle(Paint.Style.FILL);
                         drawer(item,blue);
                         break;
                     case turbo:
                         Paint black = new Paint();
                         black.setColor(Color.BLACK);
                         black.setStyle(Paint.Style.FILL);
                         drawer(item,black);
                         break;
                     case tronTrail:
                         if (item.getFirst()) {

                             switch (item.getOwner()) {
                                 case player1:
                                     break;
                                 case player2:
                                     break;
                                 case player3:
                                     break;
                                 case player4:
                                     break;
                                 case bot:
                                     break;
                             }
                             break;
                         }
                         else{
                             switch (item.getOwner()) {
                                 case player1:
                                     break;
                                 case player2:
                                     break;
                                 case player3:
                                     break;
                                 case player4:
                                     break;
                                 case bot:
                                     break;
                             }
                             break;

                         }
                 }
             }




        }
        ItemReceiver itemReceiver = new ItemReceiver(canvas);

        for (Item temp: lista) {
            itemReceiver.drawOnGame(temp);
        }


    }}
    /**@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect cuadro = new Rect();
        Paint black = new Paint();
        /**cuadro.set(0,0,canvas.getWidth(),canvas.getHeight());
        cuadro.set(0,0,680,680);
        black.setColor(Color.BLACK);
        black.setStyle(Paint.Style.FILL);
        canvas.drawRect(cuadro, black);

        for (int i = 1; i <= 34; i++){
            for (int j = 1; j <= 34; j++) {
                //Rect cuadro = new Rect();
                int size = 30;
                cuadro.set(40+size * j, i * size, 40+size * j+size, i * size + size);

                //Paint black = new Paint();
                black.setColor(Color.BLACK);
                black.setStyle(Paint.Style.FILL);

                canvas.drawRect(cuadro, black);
                black.setColor(Color.CYAN);
                black.setStyle(Paint.Style.STROKE);
                canvas.drawRect(cuadro,black);



            }
    }
}}**/