package danielc.tec.TronAndroid.Android.trash;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import danielc.tec.TronAndroid.Comunication.ItemReceiver;

/**
 * Created by DanielC on 3/10/16.
 */

public class ReadThread extends Thread {
    Canvas canvas;

    public ReadThread(Canvas canvas) {
        this.canvas = canvas;
    }
    boolean flag = true;

    ItemReceiver itemReceiver = new ItemReceiver(canvas);
    public void run() {

        while (flag){
            //Random rn = new Random();
            //int num=rn.nextInt(34 - 1 + 1) + 1;
            Rect cuadro = new Rect();
            Paint black = new Paint();
            cuadro.set(0, 0, 500, 500);
            black.setColor(Color.BLACK);
            black.setStyle(Paint.Style.FILL);

            canvas.drawRect(cuadro, black);

            Paint red = new Paint();
            red.setColor(Color.BLUE);
            red.setStyle(Paint.Style.FILL_AND_STROKE);

            for (int i = 1; i <= 34; i++) {
                for (int j = 1; j <= 34; j++) {

                    int size = 29;
                    cuadro.set(40 + size * j, i * size, 40 + size * j + size, i * size + size);

                    black.setColor(Color.CYAN);
                    black.setStyle(Paint.Style.STROKE);
                    canvas.drawRect(cuadro, black);
                }
            }
            //  Item item = new Item(ItemType.bomb,4,4);
            //  itemReceiver.drawOnGame(item);

        }

    }
}
