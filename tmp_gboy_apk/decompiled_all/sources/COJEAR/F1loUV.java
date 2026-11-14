package COJEAR;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class F1loUV extends ExjC7D {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final FG7pZc f1743B2KMhB;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f1743B2KMhB = FG7pZc.ASJ6gh(null, windowInsets);
        SjQpmsz();
    }

    public F1loUV(FG7pZc fG7pZc, WindowInsets windowInsets) {
        super(fG7pZc, windowInsets);
    }

    private static /* synthetic */ void SjQpmsz() {
        char[] charArray = "6:8{2480{7:,{&=099{\u001f;<\u0017'<120".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'U');
        }
        String str = new String(charArray);
        char[] charArray2 = "69<;<!".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'U');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // COJEAR.ErKPGd, COJEAR.F32kj0
    public final void ADYaiT(View view) {
    }

    @Override // COJEAR.ErKPGd, COJEAR.F32kj0
    public BV3sI0.A5SV6n ARc23Z(int i) {
        Insets insets;
        insets = this.f1735A5SV6n.getInsets(F508T2.A2egSU(i));
        return BV3sI0.A5SV6n.A5SV6n(insets);
    }
}
