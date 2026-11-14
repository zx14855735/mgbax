package AaHO0E;

import android.content.Context;
import android.os.Build;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class Ff5QvW extends FM663C implements FOAO9d {

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public static final Method f850Cd8JRx;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public AZkASS.ARc23Z f851CcAIMM;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f850Cd8JRx = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    @Override // AaHO0E.FOAO9d
    public final void AZOQYO(AZkASS.AmA8tU amA8tU, AZkASS.B25kr6 b25kr6) {
        AZkASS.ARc23Z aRc23Z = this.f851CcAIMM;
        if (aRc23Z != null) {
            aRc23Z.AZOQYO(amA8tU, b25kr6);
        }
    }

    @Override // AaHO0E.FM663C
    public final EdQ5bb AmA8tU(Context context, boolean z) {
        FdMWEC fdMWEC = new FdMWEC(context, z);
        fdMWEC.setHoverListener(this);
        return fdMWEC;
    }

    @Override // AaHO0E.FOAO9d
    public final void B9tovu(AZkASS.AmA8tU amA8tU, AZkASS.B25kr6 b25kr6) {
        AZkASS.ARc23Z aRc23Z = this.f851CcAIMM;
        if (aRc23Z != null) {
            aRc23Z.B9tovu(amA8tU, b25kr6);
        }
    }
}
