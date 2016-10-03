package danielc.tec.TronAndroid.Android.trash;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;


/**
 * Created by DanielC on 1/10/16.
 */

public class CustomView extends View {

    Paint paint;
    RectF cuadrito;
    Button Button;


    public CustomView(Context context) {
        super(context);
        cuadrito = new RectF(20, 20, 100,100);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect cuadro = new Rect();
        Paint black = new Paint();
        /**cuadro.set(0,0,canvas.getWidth(),canvas.getHeight());**/
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
        /**Rect base = new Rect();
        Paint Tron1 = new Paint();
        base.set(1150,30,1860,1050);
        Tron1.setColor(Color.CYAN);
        Tron1.setStyle(Paint.Style.FILL);
        canvas.drawRect(base, Tron1);**/


    }



}
