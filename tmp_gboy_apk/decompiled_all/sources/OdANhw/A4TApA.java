package OdANhw;

import CtFAbx.ASJ6gh;
import CtFAbx.AYUAbz;
import D8MqeW.AzWtSf;
import D8MqeW.B7CMnp;
import DcUJf1.B3GDIM;
import LqstKO.AMqCpz;
import LqstKO.ARc23Z;
import NOd7IU.AlLFFp;
import RD2OKB.AZkASS;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends Drawable implements Drawable.Callback {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Context f6626AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AMqCpz f6627AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final A5SV6n f6628AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final A2egSU f6629B25kr6;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f6631B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public B3GDIM f6632B4ZgIw;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public OvgpEe.A2egSU f6625AcNBzu = new OvgpEe.A2egSU();

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final Paint f6630B2KMhB = new Paint();

    public A4TApA(Context context, AMqCpz aMqCpz, A5SV6n a5SV6n, A2egSU a2egSU) {
        this.f6626AlLFFp = context;
        this.f6627AmA8tU = aMqCpz;
        this.f6628AzWtSf = a5SV6n;
        this.f6629B25kr6 = a2egSU;
        a2egSU.f6623ASJ6gh = this;
        setAlpha(255);
    }

    public final boolean A2egSU(boolean z, boolean z2, boolean z3) {
        boolean visible = super.setVisible(z, z2);
        A2egSU a2egSU = this.f6629B25kr6;
        ObjectAnimator objectAnimator = a2egSU.f6621ADYaiT;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ASJ6gh aSJ6gh = a2egSU.AMqCpz;
        if (aSJ6gh != null) {
            aSJ6gh.ADYaiT();
        }
        if (z && z3) {
            if (this.f6625AcNBzu != null && OvgpEe.A2egSU.A2egSU(this.f6626AlLFFp.getContentResolver()) == 0.0f) {
                return visible;
            }
            if (a2egSU.AMqCpz == null) {
                ASJ6gh aSJ6gh2 = new ASJ6gh(a2egSU, A2egSU.f6617AZkASS);
                AYUAbz aYUAbz = new AYUAbz();
                aYUAbz.A4TApA(200.0f);
                aYUAbz.A2egSU(0.6f);
                aSJ6gh2.f1905AaHO0E = aYUAbz;
                aSJ6gh2.f1902AYUAbz = 0.01f;
                a2egSU.AMqCpz = aSJ6gh2;
            }
            if (a2egSU.f6621ADYaiT == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a2egSU, A2egSU.f6616AZOQYO, 0.0f, 1.0f);
                a2egSU.f6621ADYaiT = ofFloat;
                ofFloat.setDuration(650L);
                a2egSU.f6621ADYaiT.setInterpolator(null);
                a2egSU.f6621ADYaiT.setRepeatCount(-1);
                a2egSU.f6621ADYaiT.addListener(new AaHO0E.A5SV6n(8, a2egSU));
            }
            a2egSU.f6618A2egSU = 1;
            a2egSU.A2egSU(0.0f);
            a2egSU.f6624AYUAbz.f4938A2egSU = ((int[]) a2egSU.f6622ARc23Z.f4937B25kr6)[0];
            a2egSU.AMqCpz.A2egSU(a2egSU.f6618A2egSU);
            a2egSU.f6621ADYaiT.start();
        }
        return visible;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z;
        B3GDIM b3gdim;
        Rect rect = new Rect();
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            boolean z2 = this.f6625AcNBzu != null && OvgpEe.A2egSU.A2egSU(this.f6626AlLFFp.getContentResolver()) == 0.0f;
            AMqCpz aMqCpz = this.f6627AmA8tU;
            if (z2 && (b3gdim = this.f6632B4ZgIw) != null) {
                b3gdim.setBounds(bounds);
                this.f6632B4ZgIw.setTint(((int[]) aMqCpz.f4937B25kr6)[0]);
                this.f6632B4ZgIw.draw(canvas);
                return;
            }
            canvas.save();
            A5SV6n a5SV6n = this.f6628AzWtSf;
            a5SV6n.getClass();
            canvas.translate(bounds.centerX(), bounds.centerY());
            a5SV6n.f6634A2egSU.getClass();
            AMqCpz aMqCpz2 = a5SV6n.f6634A2egSU;
            AMqCpz aMqCpz3 = a5SV6n.f6634A2egSU;
            AMqCpz aMqCpz4 = a5SV6n.f6634A2egSU;
            AMqCpz aMqCpz5 = a5SV6n.f6634A2egSU;
            canvas.clipRect((-Math.max(aMqCpz2.f4935AmA8tU, aMqCpz2.f4933AcNBzu)) / 2.0f, (-Math.max(aMqCpz3.f4934AlLFFp, aMqCpz3.f4933AcNBzu)) / 2.0f, Math.max(aMqCpz4.f4935AmA8tU, aMqCpz4.f4933AcNBzu) / 2.0f, Math.max(aMqCpz5.f4934AlLFFp, aMqCpz5.f4933AcNBzu) / 2.0f);
            canvas.rotate(-90.0f);
            Paint paint = this.f6630B2KMhB;
            int i = aMqCpz.f4936AzWtSf;
            int i2 = this.f6631B3GDIM;
            AMqCpz aMqCpz6 = a5SV6n.f6634A2egSU;
            float min = Math.min(aMqCpz6.f4934AlLFFp, aMqCpz6.f4935AmA8tU) / 2.0f;
            paint.setColor(OLy1FW.AYUAbz.ADYaiT(i, i2));
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            canvas.drawRoundRect(new RectF((-r11) / 2.0f, (-r9) / 2.0f, aMqCpz6.f4934AlLFFp / 2.0f, aMqCpz6.f4935AmA8tU / 2.0f), min, min, paint);
            ARc23Z aRc23Z = this.f6629B25kr6.f6624AYUAbz;
            paint.setColor(OLy1FW.AYUAbz.ADYaiT(aRc23Z.f4938A2egSU, this.f6631B3GDIM));
            paint.setStyle(style);
            canvas.save();
            canvas.rotate(aRc23Z.f4940A5SV6n);
            Path path = a5SV6n.f6635A4TApA;
            path.rewind();
            int floor = (int) Math.floor(aRc23Z.f4939A4TApA);
            AzWtSf[] azWtSfArr = A5SV6n.AMqCpz;
            int length = azWtSfArr.length;
            int i3 = floor / length;
            if ((floor ^ length) < 0 && i3 * length != floor) {
                i3--;
            }
            float f = aRc23Z.f4939A4TApA - floor;
            AzWtSf azWtSf = azWtSfArr[floor - (i3 * length)];
            RXb0Sz.ARc23Z.AMqCpz(azWtSf, "<this>");
            RFbdkT.A5SV6n A4TApA2 = AZkASS.A4TApA();
            ArrayList arrayList = azWtSf.f2030A2egSU;
            int size = arrayList.size();
            D8MqeW.A4TApA a4TApA = null;
            D8MqeW.A4TApA a4TApA2 = null;
            int i4 = 0;
            while (i4 < size) {
                float[] fArr = new float[8];
                int i5 = 0;
                for (int i6 = 8; i5 < i6; i6 = 8) {
                    fArr[i5] = B7CMnp.A4TApA(((D8MqeW.A4TApA) ((R8Rbcg.A4TApA) arrayList.get(i4)).f7826AcNBzu).f2011A2egSU[i5], ((D8MqeW.A4TApA) ((R8Rbcg.A4TApA) arrayList.get(i4)).f7827AlLFFp).f2011A2egSU[i5], f);
                    i5++;
                }
                D8MqeW.A4TApA a4TApA3 = new D8MqeW.A4TApA(fArr);
                if (a4TApA2 == null) {
                    a4TApA2 = a4TApA3;
                }
                if (a4TApA != null) {
                    A4TApA2.add(a4TApA);
                }
                i4++;
                a4TApA = a4TApA3;
            }
            if (a4TApA != null && a4TApA2 != null) {
                float[] fArr2 = a4TApA.f2011A2egSU;
                float f2 = fArr2[0];
                float f3 = fArr2[1];
                float f4 = fArr2[2];
                float f5 = fArr2[3];
                float f6 = fArr2[4];
                float f7 = fArr2[5];
                float[] fArr3 = a4TApA2.f2011A2egSU;
                A4TApA2.add(AlLFFp.A2egSU(f2, f3, f4, f5, f6, f7, fArr3[0], fArr3[1]));
            }
            RFbdkT.A5SV6n A2egSU2 = AZkASS.A2egSU(A4TApA2);
            path.rewind();
            int i7 = 0;
            boolean z3 = true;
            for (int A2egSU3 = A2egSU2.A2egSU(); i7 < A2egSU3; A2egSU3 = A2egSU3) {
                D8MqeW.A4TApA a4TApA4 = (D8MqeW.A4TApA) A2egSU2.get(i7);
                if (z3) {
                    float[] fArr4 = a4TApA4.f2011A2egSU;
                    path.moveTo(fArr4[0], fArr4[1]);
                    z = false;
                } else {
                    z = z3;
                }
                float[] fArr5 = a4TApA4.f2011A2egSU;
                path.cubicTo(fArr5[2], fArr5[3], fArr5[4], fArr5[5], a4TApA4.A2egSU(), a4TApA4.A4TApA());
                i7++;
                z3 = z;
            }
            path.close();
            Matrix matrix = a5SV6n.f6636A5SV6n;
            float f8 = a5SV6n.f6634A2egSU.f4933AcNBzu / 2.0f;
            matrix.setScale(f8, f8);
            path.transform(matrix);
            canvas.drawPath(path, paint);
            canvas.restore();
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f6631B3GDIM;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        AMqCpz aMqCpz = this.f6628AzWtSf.f6634A2egSU;
        return Math.max(aMqCpz.f4934AlLFFp, aMqCpz.f4933AcNBzu);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        AMqCpz aMqCpz = this.f6628AzWtSf.f6634A2egSU;
        return Math.max(aMqCpz.f4935AmA8tU, aMqCpz.f4933AcNBzu);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.f6631B3GDIM != i) {
            this.f6631B3GDIM = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f6630B2KMhB.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return A2egSU(z, z2, z);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
