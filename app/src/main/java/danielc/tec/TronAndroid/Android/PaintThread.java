package danielc.tec.TronAndroid.Android;

import android.graphics.Canvas;

import java.util.ArrayList;

import danielc.tec.TronAndroid.Comunication.ItemReceiver;
import danielc.tec.TronAndroid.Comunication.JsonParser;
import danielc.tec.TronAndroid.GameStructures.Item;


/**
 * Created by DanielC on 6/10/16.
 */

public class PaintThread extends Thread {
    private Canvas canvas;

    public PaintThread(Canvas canvas) {
        this.canvas = canvas;
    }

    public void run() {
        ItemReceiver itemReceiver = new ItemReceiver(canvas);
        //while (true) {
            itemReceiver.eraseall();
            ArrayList<Item> items = JsonParser.getInstance().getPlayerItems();
            if (items != null) {
                //System.out.println("no es null");
                for (Item data : items) {
                    final ItemReceiver itemReceiverFinal = itemReceiver;
                    final Item dataFinal = data;
                    Utils.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            itemReceiverFinal.drawOnGame(dataFinal);
                        }
                    });

                }

            }


       // }
    }
}
