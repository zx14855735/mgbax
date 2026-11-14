package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ReplacementSpan;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BPw6Q8 extends ReplacementSpan {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final BNL6CD f8692AlLFFp;

    /* renamed from: B25kr6, reason: collision with root package name */
    public TextPaint f8695B25kr6;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Paint.FontMetricsInt f8691AcNBzu = new Paint.FontMetricsInt();

    /* renamed from: AmA8tU, reason: collision with root package name */
    public short f8693AmA8tU = -1;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public float f8694AzWtSf = 1.0f;

    public BPw6Q8(BNL6CD bnl6cd) {
        JrXYwF.A4TApA.B4ZgIw(bnl6cd, "rasterizer cannot be null");
        this.f8692AlLFFp = bnl6cd;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        TextPaint textPaint = null;
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i, i2, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                    TextPaint textPaint2 = this.f8695B25kr6;
                    if (textPaint2 == null) {
                        textPaint2 = new TextPaint();
                        this.f8695B25kr6 = textPaint2;
                    }
                    textPaint = textPaint2;
                    textPaint.set(paint);
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        characterStyle.updateDrawState(textPaint);
                    }
                }
            }
            if (paint instanceof TextPaint) {
                textPaint = (TextPaint) paint;
            }
        } else if (paint instanceof TextPaint) {
            textPaint = (TextPaint) paint;
        }
        TextPaint textPaint3 = textPaint;
        if (textPaint3 != null && textPaint3.bgColor != 0) {
            int color = textPaint3.getColor();
            Paint.Style style = textPaint3.getStyle();
            textPaint3.setColor(textPaint3.bgColor);
            textPaint3.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, i3, f + this.f8693AmA8tU, i5, textPaint3);
            textPaint3.setStyle(style);
            textPaint3.setColor(color);
        }
        AmA8tU.A2egSU().getClass();
        float f2 = i4;
        Paint paint2 = textPaint3;
        if (textPaint3 == null) {
            paint2 = paint;
        }
        BNL6CD bnl6cd = this.f8692AlLFFp;
        AZOQYO.ARc23Z aRc23Z = bnl6cd.f8689A4TApA;
        Typeface typeface = (Typeface) aRc23Z.f366AzWtSf;
        Typeface typeface2 = paint2.getTypeface();
        paint2.setTypeface(typeface);
        canvas.drawText((char[]) aRc23Z.f364AlLFFp, bnl6cd.f8688A2egSU * 2, 2, f, f2, paint2);
        paint2.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f8691AcNBzu;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        BNL6CD bnl6cd = this.f8692AlLFFp;
        this.f8694AzWtSf = abs / (bnl6cd.A4TApA().A2egSU(14) != 0 ? r8.f1918A4TApA.getShort(r1 + r8.f1917A2egSU) : (short) 0);
        CtxOCS.A2egSU A4TApA2 = bnl6cd.A4TApA();
        int A2egSU2 = A4TApA2.A2egSU(14);
        if (A2egSU2 != 0) {
            A4TApA2.f1918A4TApA.getShort(A2egSU2 + A4TApA2.f1917A2egSU);
        }
        short s = (short) ((bnl6cd.A4TApA().A2egSU(12) != 0 ? r5.f1918A4TApA.getShort(r7 + r5.f1917A2egSU) : (short) 0) * this.f8694AzWtSf);
        this.f8693AmA8tU = s;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s;
    }
}
