package androidx.emoji2.text;

import android.text.TextPaint;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ThreadLocal f8648A4TApA = new ThreadLocal();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final TextPaint f8649A2egSU;

    static {
        sdcAPZk();
    }

    public ARc23Z() {
        TextPaint textPaint = new TextPaint();
        this.f8649A2egSU = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static /* synthetic */ void sdcAPZk() {
        char[] charArray = "FJH\u000bBDH@\u000bGJ\\\u000bVM@II\u000boKLgWLAB@".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '%');
        }
        String str = new String(charArray);
        char[] charArray2 = "FILKLQ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '%');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
