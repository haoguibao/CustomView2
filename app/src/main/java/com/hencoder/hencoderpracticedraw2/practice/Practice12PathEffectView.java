package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        CornerPathEffect cornerPathEffect = new CornerPathEffect(20);
        paint.setPathEffect(cornerPathEffect);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect
        DiscretePathEffect discretePathEffect = new DiscretePathEffect(5, 3);
        paint.setPathEffect(discretePathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{20, 5, 10, 5}, 0);
        paint.setPathEffect(dashPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        Path myPath = new Path(); //画个三角形
        paint.setStyle(Paint.Style.FILL);
        myPath.moveTo(10, 10);
        myPath.lineTo(20, 10);
        myPath.lineTo(15, 15);
        paint.setStyle(Paint.Style.STROKE);
        PathDashPathEffect pathDashPathEffect = new PathDashPathEffect(myPath, 10, 5, PathDashPathEffect.Style.TRANSLATE);
        paint.setPathEffect(pathDashPathEffect);
        canvas.drawPath(this.path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        DiscretePathEffect discretePathEffect1 = new DiscretePathEffect(5, 3);
        DashPathEffect dashPathEffect1 = new DashPathEffect(new float[]{20, 5, 10, 5}, 0);
        SumPathEffect sumPathEffect = new SumPathEffect(discretePathEffect1, dashPathEffect1);
        paint.setPathEffect(sumPathEffect);
        canvas.drawPath(this.path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect
        DiscretePathEffect discretePathEffect2 = new DiscretePathEffect(5, 3);
        DashPathEffect dashPathEffect2 = new DashPathEffect(new float[]{20, 5, 10, 5}, 0);
        ComposePathEffect composePathEffect = new ComposePathEffect(discretePathEffect2, dashPathEffect2);
        paint.setPathEffect(composePathEffect);
        canvas.drawPath(this.path, paint);
        canvas.restore();
    }
}
