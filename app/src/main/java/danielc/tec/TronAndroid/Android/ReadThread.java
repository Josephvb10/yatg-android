package danielc.tec.TronAndroid.Android;

import android.graphics.Canvas;

import java.util.Random;

import danielc.tec.TronAndroid.GameStructures.Item;
import danielc.tec.TronAndroid.GameStructures.ItemType;

import static android.R.attr.max;
import static danielc.tec.TronAndroid.GameStructures.ItemType.*;

/**
 * Created by DanielC on 3/10/16.
 */

public class ReadThread extends Thread {
    Canvas canvas;

    public ReadThread(Canvas canvas) {
        this.canvas = canvas;
    }


    ItemReceiver itemReceiver = new ItemReceiver(canvas);
    public void run() {
        while(true) {
            //Random rn = new Random();
            //int num=rn.nextInt(34 - 1 + 1) + 1;
            itemReceiver.eraseall();
            Item item = new Item(ItemType.bomb,4,4);
            itemReceiver.drawOnGame(item);

        }
    }
}
