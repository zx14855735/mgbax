package OvgpEe;

import ADYaiT.CcAIMM;
import ADYaiT.CtFAbx;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E extends ASJ6gh {

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public AcNBzu f6876BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public CcAIMM f6877BNL6CD;

    @Override // OvgpEe.ASJ6gh
    public final boolean AMqCpz(boolean z, boolean z2, boolean z3) {
        boolean AMqCpz = super.AMqCpz(z, z2, z3);
        ASJ6gh();
        if (!isRunning()) {
            this.f6877BNL6CD.A5SV6n();
        }
        if (z && (z3 || (Build.VERSION.SDK_INT <= 22 && !ASJ6gh()))) {
            this.f6877BNL6CD.AmA8tU();
        }
        return AMqCpz;
    }

    public final boolean ASJ6gh() {
        return this.f6853AmA8tU != null && A2egSU.A2egSU(this.f6851AcNBzu.getContentResolver()) == 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(this.f6862BI9f7h)) {
            ASJ6gh();
            canvas.save();
            AcNBzu acNBzu = this.f6876BJ7GGh;
            Rect bounds = getBounds();
            float A4TApA2 = A4TApA();
            ObjectAnimator objectAnimator = this.f6854AzWtSf;
            boolean z = objectAnimator != null && objectAnimator.isRunning();
            ObjectAnimator objectAnimator2 = this.f6855B25kr6;
            acNBzu.A5SV6n(canvas, bounds, A4TApA2, z, objectAnimator2 != null && objectAnimator2.isRunning());
            B25kr6 b25kr6 = this.f6852AlLFFp;
            int i5 = b25kr6.f6915AZOQYO;
            int i6 = this.f6861BChYOn;
            boolean z2 = i5 == 0 && !b25kr6.A5SV6n(false);
            Paint paint = this.f6860B9tovu;
            if (z2) {
                this.f6876BJ7GGh.ASJ6gh(canvas, paint, 0.0f, 1.0f, b25kr6.f6912ARc23Z, i6, 0);
                i = i6;
                i2 = i5;
            } else {
                AYUAbz aYUAbz = (AYUAbz) ((ArrayList) this.f6877BNL6CD.f136AlLFFp).get(0);
                AYUAbz aYUAbz2 = (AYUAbz) CtFAbx.ADYaiT((ArrayList) this.f6877BNL6CD.f136AlLFFp, 1);
                AcNBzu acNBzu2 = this.f6876BJ7GGh;
                if (CtFAbx.B9tovu(acNBzu2)) {
                    acNBzu2.ASJ6gh(canvas, paint, 0.0f, aYUAbz.f6863A2egSU, b25kr6.f6912ARc23Z, i6, i5);
                    this.f6876BJ7GGh.ASJ6gh(canvas, paint, aYUAbz2.f6864A4TApA, 1.0f, b25kr6.f6912ARc23Z, i6, i5);
                    i = i6;
                    i2 = i5;
                } else {
                    canvas.save();
                    aYUAbz2.getClass();
                    canvas.rotate(0.0f);
                    this.f6876BJ7GGh.ASJ6gh(canvas, paint, aYUAbz2.f6864A4TApA, 1.0f + aYUAbz.f6863A2egSU, b25kr6.f6912ARc23Z, i6, i5);
                    i = i6;
                    i2 = i5;
                    canvas.restore();
                }
            }
            int i7 = 0;
            while (i7 < ((ArrayList) this.f6877BNL6CD.f136AlLFFp).size()) {
                AYUAbz aYUAbz3 = (AYUAbz) ((ArrayList) this.f6877BNL6CD.f136AlLFFp).get(i7);
                aYUAbz3.f6867ARc23Z = A5SV6n();
                int i8 = i7;
                AcNBzu acNBzu3 = this.f6876BJ7GGh;
                int i9 = this.f6861BChYOn;
                acNBzu3.getClass();
                int ADYaiT2 = OLy1FW.AYUAbz.ADYaiT(aYUAbz3.f6865A5SV6n, i9);
                acNBzu3.f6885AlLFFp = aYUAbz3.f6868ASJ6gh;
                float f = aYUAbz3.f6863A2egSU;
                float f2 = aYUAbz3.f6864A4TApA;
                int i10 = aYUAbz3.f6866ADYaiT;
                boolean z3 = z2;
                acNBzu3.AMqCpz(canvas, paint, f, f2, ADYaiT2, i10, i10, aYUAbz3.AMqCpz, aYUAbz3.f6867ARc23Z, true);
                if (i8 <= 0 || z3) {
                    i3 = i2;
                    i4 = i;
                } else {
                    i3 = i2;
                    i4 = i;
                    this.f6876BJ7GGh.ASJ6gh(canvas, paint, ((AYUAbz) ((ArrayList) this.f6877BNL6CD.f136AlLFFp).get(i8 - 1)).f6864A4TApA, aYUAbz3.f6863A2egSU, b25kr6.f6912ARc23Z, i4, i3);
                }
                i7 = i8 + 1;
                i = i4;
                i2 = i3;
                z2 = z3;
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f6876BJ7GGh.A2egSU();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        this.f6876BJ7GGh.getClass();
        return -1;
    }
}
