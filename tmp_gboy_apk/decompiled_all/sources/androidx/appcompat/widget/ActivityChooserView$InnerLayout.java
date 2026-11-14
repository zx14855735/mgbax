package androidx.appcompat.widget;

import AaHO0E.GYpKKt;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final int[] f8147AcNBzu = {R.attr.background};

    static {
        bpwwua();
    }

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        GYpKKt AMqCpz = GYpKKt.AMqCpz(context, attributeSet, f8147AcNBzu);
        setBackgroundDrawable(AMqCpz.A4TApA(0));
        AMqCpz.ASJ6gh();
    }

    private static /* synthetic */ void bpwwua() {
        char[] charArray = "0<>}42>6}1<*} ;6??}\u0019=:\u0011!:746".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'S');
        }
        String str = new String(charArray);
        char[] charArray2 = "0?:=:'".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'S');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
