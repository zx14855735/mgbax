package AZkASS;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BIYEnU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f561A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AmA8tU f562A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final boolean f563A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f564ADYaiT;
    public View AMqCpz;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f566ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public BJ7GGh f567AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public BChYOn f568AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public PopupWindow.OnDismissListener f569AZkASS;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f565ARc23Z = 8388611;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final BI9f7h f570AaHO0E = new BI9f7h(0, this);

    public BIYEnU(int i, AmA8tU amA8tU, Context context, View view, boolean z) {
        this.f561A2egSU = context;
        this.f562A4TApA = amA8tU;
        this.AMqCpz = view;
        this.f563A5SV6n = z;
        this.f564ADYaiT = i;
    }

    public final BChYOn A2egSU() {
        BChYOn bniPrB;
        if (this.f568AZOQYO == null) {
            Context context = this.f561A2egSU;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(2131165206)) {
                bniPrB = new AYUAbz(context, this.AMqCpz, this.f564ADYaiT, this.f563A5SV6n);
            } else {
                View view = this.AMqCpz;
                Context context2 = this.f561A2egSU;
                boolean z = this.f563A5SV6n;
                bniPrB = new BniPrB(this.f564ADYaiT, this.f562A4TApA, context2, view, z);
            }
            bniPrB.AcNBzu(this.f562A4TApA);
            bniPrB.B3GDIM(this.f570AaHO0E);
            bniPrB.AmA8tU(this.AMqCpz);
            bniPrB.AaHO0E(this.f567AYUAbz);
            bniPrB.AzWtSf(this.f566ASJ6gh);
            bniPrB.B25kr6(this.f565ARc23Z);
            this.f568AZOQYO = bniPrB;
        }
        return this.f568AZOQYO;
    }

    public final boolean A4TApA() {
        BChYOn bChYOn = this.f568AZOQYO;
        return bChYOn != null && bChYOn.isShowing();
    }

    public void A5SV6n() {
        this.f568AZOQYO = null;
        PopupWindow.OnDismissListener onDismissListener = this.f569AZkASS;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void ADYaiT(int i, int i2, boolean z, boolean z2) {
        BChYOn A2egSU2 = A2egSU();
        A2egSU2.B4ZgIw(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.f565ARc23Z, this.AMqCpz.getLayoutDirection()) & 7) == 5) {
                i -= this.AMqCpz.getWidth();
            }
            A2egSU2.B2KMhB(i);
            A2egSU2.B7CMnp(i2);
            int i3 = (int) ((this.f561A2egSU.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            A2egSU2.f558AcNBzu = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        A2egSU2.show();
    }
}
