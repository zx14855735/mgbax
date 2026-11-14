package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BV3sI0 implements Spannable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f8696AcNBzu = false;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Spannable f8697AlLFFp;

    public BV3sI0(Spannable spannable) {
        this.f8697AlLFFp = spannable;
    }

    public final void A2egSU() {
        Spannable spannable = this.f8697AlLFFp;
        if (!this.f8696AcNBzu) {
            if ((Build.VERSION.SDK_INT < 28 ? new OLy1FW.AzWtSf(10, (byte) 0) : new BTvldC(10, (byte) 0)).AMqCpz(spannable)) {
                this.f8697AlLFFp = new SpannableString(spannable);
            }
        }
        this.f8696AcNBzu = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f8697AlLFFp.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        IntStream chars;
        chars = this.f8697AlLFFp.chars();
        return chars;
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        IntStream codePoints;
        codePoints = this.f8697AlLFFp.codePoints();
        return codePoints;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f8697AlLFFp.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f8697AlLFFp.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f8697AlLFFp.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i, int i2, Class cls) {
        return this.f8697AlLFFp.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f8697AlLFFp.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.f8697AlLFFp.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        A2egSU();
        this.f8697AlLFFp.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i, int i2, int i3) {
        A2egSU();
        this.f8697AlLFFp.setSpan(obj, i, i2, i3);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return this.f8697AlLFFp.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f8697AlLFFp.toString();
    }
}
