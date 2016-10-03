package danielc.tec.TronAndroid.Android;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import danielc.tec.TronAndroid.GameStructures.Item;

/**
 * Created by DanielC on 3/10/16.
 */

public class ItemReceiver {
    Rect cuadro = new Rect();
    Canvas canvas;

    public ItemReceiver(Canvas canvas) {
        this.canvas = canvas;
        Log.w("puta1", "LLegué a ItemReceiver");
    }

    public void drawer(Item item, Paint paint) {
        Rect drawItem = new Rect();


        int i = item.getIndexI();
        int j = item.getIndexJ();
        Log.e("puta1", "i: " + i + "j: " + j);
        drawItem.set(40 + 29 * j, i * 29, 40 + 29 * j + 29, i * 29 + 29);
        canvas.drawRect(drawItem, paint);
        Log.w("puta1", "LLegué a Drawer");
    }

    public void eraseall() {
        Rect cuadro = new Rect();
        Paint black = new Paint();
        cuadro.set(0, 0, canvas.getWidth(), canvas.getHeight());
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
    }

    public void drawOnGame(Item item) {
        Log.w("puta1", "LLegué a drawOnGame");
        switch (item.getType()) {
            case bomb:
                Paint red = new Paint();
                red.setColor(Color.RED);
                red.setStyle(Paint.Style.FILL);
                drawer(item, red);
                break;
            case fuel:
                Paint white = new Paint();
                white.setColor(Color.WHITE);
                white.setStyle(Paint.Style.FILL);
                drawer(item, white);
                break;
            case increaseTail:
                Paint green = new Paint();
                green.setColor(Color.GREEN);
                green.setStyle(Paint.Style.FILL);
                drawer(item, green);
                break;
            case shield:
                Paint blue = new Paint();
                blue.setColor(Color.BLUE);
                blue.setStyle(Paint.Style.FILL);
                drawer(item, blue);
                break;
            case turbo:
                Paint black = new Paint();
                black.setColor(Color.BLACK);
                black.setStyle(Paint.Style.FILL);
                drawer(item, black);
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
                } else {
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