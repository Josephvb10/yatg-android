package danielc.tec.helloworld;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;


/**
 * Created by DanielC on 1/10/16.
 */

public class CustomView extends View {
    Paint paint;
    RectF cuadrito;

    public CustomView(Context context) {
        super(context);
        cuadrito = new RectF(20, 20, 100,100);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /** setContentView(R.layout.activity_main); **/


        Rect cuadro = new Rect();
        Paint blue = new Paint();
        cuadro.set(0,0,canvas.getWidth(),canvas.getHeight());
        blue.setColor(Color.BLACK);
        blue.setStyle(Paint.Style.FILL);
        canvas.drawRect(cuadro, blue);



        for (int i = 1; i <= 34; i++){
            for (int j = 1; j <= 34; j++) {
                //Rect cuadro = new Rect();
                int size = 30;
                cuadro.set(40+size * j, i * size, 40+size * j+size, i * size + size);

                //Paint blue = new Paint();
                blue.setColor(Color.BLACK);
                blue.setStyle(Paint.Style.FILL);

                canvas.drawRect(cuadro, blue);
                blue.setColor(Color.CYAN);
                blue.setStyle(Paint.Style.STROKE);
                canvas.drawRect(cuadro,blue);
            }
        }


    }



}
