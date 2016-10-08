package danielc.tec.TronAndroid.Android;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import danielc.tec.TronAndroid.GameStructures.Item;
import danielc.tec.helloworld.R;

import static android.R.attr.bitmap;

/**
 * Created by DanielC on 3/10/16.
 */
public class ItemDrawer {
    Canvas canvas;
    public ItemDrawer(Canvas canvas) {
        this.canvas = canvas;
    }

    /**
     * draw the item
     * @param item is the object that contains the data of the items
     * @param paint the color to draw the squares
     */
    public void drawer(Item item, Paint paint) {
        Rect drawItem = new Rect();
        int j = item.getIndexI();
        int i = item.getIndexJ()+1;
        drawItem.set(40 + 29 * j, i * 29, 40 + 29 * j + 29, i * 29 + + 29);
        canvas.drawRect(drawItem, paint);
    }

    /**
     * Used to draw a matrix
     */
    public void eraseall(

    ) {

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
            for (int j = 0; j <= 33; j++) {

                int size = 29;
                cuadro.set(40 + size * j, i * size, 40 + size * j + size, i * size + size);
                black.setColor(Color.CYAN);
                black.setStyle(Paint.Style.STROKE);
                canvas.drawRect(cuadro, black);
            }
        }
    }


    /**
     * This function is used for draw the players, the tail and the items on the game
     * @param item is an object that contains all the data and position of the items
     */
    public void drawOnGame(Item item) {
        switch (item.getType()) {
            case bomb:
                //bitmapper(item);
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
                black.setColor(Color.GRAY);
                black.setStyle(Paint.Style.FILL);
                drawer(item, black);
                break;
            case tronTrail:
                if (item.getFirst()) {

                    switch (item.getOwner()) {
                        case player1:
                            Paint x1 = new Paint();
                            x1.setColor(Color.GREEN);
                            x1.setStyle(Paint.Style.FILL);
                            drawer(item, x1);
                            break;
                        case player2:
                            Paint x2 = new Paint();
                            x2.setColor(Color.CYAN);
                            x2.setStyle(Paint.Style.FILL);
                            drawer(item, x2);
                            break;
                        case player3:
                            Paint x3 = new Paint();
                            x3.setColor(Color.YELLOW);
                            x3.setStyle(Paint.Style.FILL);
                            drawer(item, x3);
                            break;
                        case player4:
                            Paint x4 = new Paint();
                            x4.setColor(Color.MAGENTA);
                            x4.setStyle(Paint.Style.FILL);
                            drawer(item, x4);
                            break;
                        case bot:
                            Paint x5 = new Paint();
                            x5.setColor(Color.GRAY);
                            x5.setStyle(Paint.Style.FILL);
                            drawer(item, x5);
                            break;
                    }
                    break;
                } else {
                    switch (item.getOwner()) {
                        case player1:
                            Paint y5 = new Paint();
                            y5.setColor(Color.GREEN);
                            y5.setStyle(Paint.Style.FILL);
                            drawer(item, y5);
                            break;
                        case player2:
                            Paint y1 = new Paint();
                            y1.setColor(Color.CYAN);
                            y1.setStyle(Paint.Style.FILL);
                            drawer(item, y1);
                            break;
                        case player3:
                            Paint y2 = new Paint();
                            y2.setColor(Color.YELLOW);
                            y2.setStyle(Paint.Style.FILL);
                            drawer(item, y2);
                            break;
                        case player4:
                            Paint y3 = new Paint();
                            y3.setColor(Color.MAGENTA);
                            y3.setStyle(Paint.Style.FILL);
                            drawer(item, y3);
                            break;
                        case bot:
                            Paint y4 = new Paint();
                            y4.setColor(Color.GRAY);
                            y4.setStyle(Paint.Style.FILL);
                            drawer(item, y4);
                            break;
                    }
                    break;

                }
        }
    }



}