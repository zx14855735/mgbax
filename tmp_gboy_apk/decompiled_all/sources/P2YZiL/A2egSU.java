package P2YZiL;

import AaHO0E.CASmeH;
import CikNvS.A4TApA;
import OLy1FW.AYUAbz;
import android.R;
import android.content.res.ColorStateList;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends CASmeH {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final int[][] f6930B3GDIM = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: B25kr6, reason: collision with root package name */
    public ColorStateList f6931B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f6932B2KMhB;

    static {
        yiKx();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f6931B25kr6 == null) {
            int ASJ6gh2 = AYUAbz.ASJ6gh(2130968852, this);
            int ASJ6gh3 = AYUAbz.ASJ6gh(2130968872, this);
            int ASJ6gh4 = AYUAbz.ASJ6gh(2130968895, this);
            this.f6931B25kr6 = new ColorStateList(f6930B3GDIM, new int[]{AYUAbz.AaHO0E(1.0f, ASJ6gh4, ASJ6gh2), AYUAbz.AaHO0E(0.54f, ASJ6gh4, ASJ6gh3), AYUAbz.AaHO0E(0.38f, ASJ6gh4, ASJ6gh3), AYUAbz.AaHO0E(0.38f, ASJ6gh4, ASJ6gh3)});
        }
        return this.f6931B25kr6;
    }

    private static /* synthetic */ void yiKx() {
        char[] charArray = "|pr1x~rz1}pf1lwzss1Uqv]mv{xz".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 31);
        }
        String str = new String(charArray);
        char[] charArray2 = "|svqvk".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 31);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6932B2KMhB && A4TApA.A2egSU(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f6932B2KMhB = z;
        if (z) {
            A4TApA.A5SV6n(this, getMaterialThemeColorsTintList());
        } else {
            A4TApA.A5SV6n(this, null);
        }
    }
}
