package com.zy.chart.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;

import java.util.Vector;

/**
 * 自动换行和居中排列的TextView
 */

public class Text extends android.support.v7.widget.AppCompatTextView {

    private String text = "";

    public Text(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        this.text = text.toString();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (TextUtils.isEmpty(text)) {
            super.onDraw(canvas);
        } else {
            drawLinesText(canvas);
        }
    }

    private void drawLinesText(Canvas canvas) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(getCurrentTextColor());
        textPaint.setTextSize(getTextSize());

        Rect rect = new Rect(0, 0, getWidth(), getMeasuredHeight());

        //获得自动换行后的文字
        Vector vector = getTextLinesVector(textPaint, text, rect.height(), rect.width());
        text = vectorToString(vector);
        //文字自动换行
        StaticLayout layout = new StaticLayout(text, textPaint, rect.width(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
        canvas.save();
        textPaint.setTextAlign(Paint.Align.CENTER);
        //文字的位置
        canvas.translate(rect.left + rect.width() / 2, rect.top + (rect.height() - getFontHeight(textPaint) * vector.size()) / 2);
        layout.draw(canvas);
        canvas.restore();
    }

    private String vectorToString(Vector strs) {
        StringBuffer ss = new StringBuffer();
        for (Object s : strs) {
            ss.append(s + "\n");
        }
        return ss.toString();
    }

    /**
     * 将文字拆分成每一行放到Vector里
     */
    public Vector getTextLinesVector(TextPaint paint, String content, float maxHeight,
                                     float maxWidth) {
        Vector mString = new Vector<>();
        int mRealLine = 0;// 字符串真实的行数
        char ch;
        int w = 0;
        int istart = 0;
        float mFontHeight = getFontHeight(paint);
        int mMaxLinesNum = (int) (maxHeight / mFontHeight);//显示的最大行数
        int count = content.length();
        for (int i = 0; i < count; i++) {
            ch = content.charAt(i);
            float[] widths = new float[1];
            String str = String.valueOf(ch);
            paint.getTextWidths(str, widths);
            if (ch == '\n') {
                mRealLine++;// 真实的行数加一
                mString.addElement(content.substring(istart, i));
                istart = i + 1;
                w = 0;
            } else {
                w += (int) Math.ceil(widths[0]);
                if (w > maxWidth) {
                    mRealLine++;// 真实的行数加一
                    mString.addElement(content.substring(istart, i));
                    istart = i;
                    i--;
                    w = 0;
                } else {
                    if (i == count - 1) {
                        mRealLine++;// 真实的行数加一
                        mString.addElement(content.substring(istart, count));
                    }
                }
            }
            //当真实行数大于显示的最大行数时跳出循环
            if (mRealLine == mMaxLinesNum) {
                break;
            }
        }
        return mString;
    }

    /**
     * 得到文字的高度
     */
    private float getFontHeight(TextPaint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();// 得到系统默认字体属性
        return fm.bottom - fm.top;
    }

}
