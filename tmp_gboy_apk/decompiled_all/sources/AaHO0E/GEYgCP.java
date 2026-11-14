package AaHO0E;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.SwitchCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class GEYgCP extends Property {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f869A2egSU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GEYgCP(Class cls, String str, int i) {
        super(cls, str);
        this.f869A2egSU = i;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f869A2egSU) {
            case 0:
                return Float.valueOf(((SwitchCompat) obj).f8201COJEAR);
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return null;
            case 6:
                return Float.valueOf(DaOi9o.BpkvW3.f2284A2egSU.ADYaiT((View) obj));
            case 7:
                return ((View) obj).getClipBounds();
            case 8:
                return Float.valueOf(((OdANhw.A2egSU) obj).f6619A4TApA);
            case 9:
                return Float.valueOf(((OvgpEe.ASJ6gh) obj).A4TApA());
            case 10:
                return Float.valueOf(((OvgpEe.AlLFFp) obj).f6894B4ZgIw);
            default:
                return Float.valueOf(((OvgpEe.AzWtSf) obj).f6906B7CMnp);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f869A2egSU) {
            case 0:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                break;
            case 1:
                DaOi9o.ADYaiT aDYaiT = (DaOi9o.ADYaiT) obj;
                PointF pointF = (PointF) obj2;
                aDYaiT.getClass();
                aDYaiT.f2205A2egSU = Math.round(pointF.x);
                int round = Math.round(pointF.y);
                aDYaiT.f2206A4TApA = round;
                int i = aDYaiT.f2209ARc23Z + 1;
                aDYaiT.f2209ARc23Z = i;
                if (i == aDYaiT.f2210ASJ6gh) {
                    DaOi9o.BpkvW3.A2egSU(aDYaiT.AMqCpz, aDYaiT.f2205A2egSU, round, aDYaiT.f2207A5SV6n, aDYaiT.f2208ADYaiT);
                    aDYaiT.f2209ARc23Z = 0;
                    aDYaiT.f2210ASJ6gh = 0;
                    break;
                }
                break;
            case 2:
                DaOi9o.ADYaiT aDYaiT2 = (DaOi9o.ADYaiT) obj;
                PointF pointF2 = (PointF) obj2;
                aDYaiT2.getClass();
                aDYaiT2.f2207A5SV6n = Math.round(pointF2.x);
                int round2 = Math.round(pointF2.y);
                aDYaiT2.f2208ADYaiT = round2;
                int i2 = aDYaiT2.f2210ASJ6gh + 1;
                aDYaiT2.f2210ASJ6gh = i2;
                if (aDYaiT2.f2209ARc23Z == i2) {
                    DaOi9o.BpkvW3.A2egSU(aDYaiT2.AMqCpz, aDYaiT2.f2205A2egSU, aDYaiT2.f2206A4TApA, aDYaiT2.f2207A5SV6n, round2);
                    aDYaiT2.f2209ARc23Z = 0;
                    aDYaiT2.f2210ASJ6gh = 0;
                    break;
                }
                break;
            case 3:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                DaOi9o.BpkvW3.A2egSU(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 4:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                DaOi9o.BpkvW3.A2egSU(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case 5:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int round3 = Math.round(pointF5.x);
                int round4 = Math.round(pointF5.y);
                DaOi9o.BpkvW3.A2egSU(view3, round3, round4, view3.getWidth() + round3, view3.getHeight() + round4);
                break;
            case 6:
                DaOi9o.BpkvW3.f2284A2egSU.AaHO0E((View) obj, ((Float) obj2).floatValue());
                break;
            case 7:
                ((View) obj).setClipBounds((Rect) obj2);
                break;
            case 8:
                OdANhw.A2egSU a2egSU = (OdANhw.A2egSU) obj;
                a2egSU.f6619A4TApA = ((Float) obj2).floatValue();
                float f = a2egSU.f6618A2egSU - 1;
                float f2 = a2egSU.f6620A5SV6n - f;
                float f3 = ((int) (r13 * 650.0f)) / 650.0f;
                if (f3 == 1.0f) {
                    f3 = 0.0f;
                }
                a2egSU.f6624AYUAbz.f4940A5SV6n = ((f2 * 90.0f) + ((f3 * 50.0f) + (f * 140.0f))) % 360.0f;
                OdANhw.A4TApA a4TApA = a2egSU.f6623ASJ6gh;
                if (a4TApA != null) {
                    a4TApA.invalidateSelf();
                    break;
                }
                break;
            case 9:
                OvgpEe.ASJ6gh aSJ6gh = (OvgpEe.ASJ6gh) obj;
                float floatValue = ((Float) obj2).floatValue();
                if (aSJ6gh.f6859B7CMnp != floatValue) {
                    aSJ6gh.f6859B7CMnp = floatValue;
                    aSJ6gh.invalidateSelf();
                    break;
                }
                break;
            case 10:
                OvgpEe.AlLFFp alLFFp = (OvgpEe.AlLFFp) obj;
                alLFFp.f6894B4ZgIw = ((Float) obj2).floatValue();
                ArrayList arrayList = (ArrayList) alLFFp.f136AlLFFp;
                ((OvgpEe.AYUAbz) arrayList.get(0)).f6863A2egSU = 0.0f;
                float B2KMhB2 = com.bumptech.glide.AMqCpz.B2KMhB(((int) (r13 * 333.0f)) / 667, 0.0f, 1.0f);
                OvgpEe.AYUAbz aYUAbz = (OvgpEe.AYUAbz) arrayList.get(0);
                OvgpEe.AYUAbz aYUAbz2 = (OvgpEe.AYUAbz) arrayList.get(1);
                D8cQ8b.A4TApA a4TApA2 = alLFFp.f6890AzWtSf;
                float interpolation = a4TApA2.getInterpolation(B2KMhB2);
                aYUAbz2.f6863A2egSU = interpolation;
                aYUAbz.f6864A4TApA = interpolation;
                OvgpEe.AYUAbz aYUAbz3 = (OvgpEe.AYUAbz) arrayList.get(1);
                OvgpEe.AYUAbz aYUAbz4 = (OvgpEe.AYUAbz) arrayList.get(2);
                float interpolation2 = a4TApA2.getInterpolation(B2KMhB2 + 0.49925038f);
                aYUAbz4.f6863A2egSU = interpolation2;
                aYUAbz3.f6864A4TApA = interpolation2;
                ((OvgpEe.AYUAbz) arrayList.get(2)).f6864A4TApA = 1.0f;
                if (alLFFp.f6893B3GDIM && ((OvgpEe.AYUAbz) arrayList.get(1)).f6864A4TApA < 1.0f) {
                    ((OvgpEe.AYUAbz) arrayList.get(2)).f6865A5SV6n = ((OvgpEe.AYUAbz) arrayList.get(1)).f6865A5SV6n;
                    ((OvgpEe.AYUAbz) arrayList.get(1)).f6865A5SV6n = ((OvgpEe.AYUAbz) arrayList.get(0)).f6865A5SV6n;
                    ((OvgpEe.AYUAbz) arrayList.get(0)).f6865A5SV6n = alLFFp.f6891B25kr6.AMqCpz[alLFFp.f6892B2KMhB];
                    alLFFp.f6893B3GDIM = false;
                }
                ((OvgpEe.AaHO0E) alLFFp.f135AcNBzu).invalidateSelf();
                break;
            default:
                OvgpEe.AzWtSf azWtSf = (OvgpEe.AzWtSf) obj;
                float floatValue2 = ((Float) obj2).floatValue();
                azWtSf.f6906B7CMnp = floatValue2;
                int i3 = (int) (floatValue2 * 1800.0f);
                int i4 = 0;
                while (true) {
                    ArrayList arrayList2 = (ArrayList) azWtSf.f136AlLFFp;
                    if (i4 >= arrayList2.size()) {
                        if (azWtSf.f6905B4ZgIw) {
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                ((OvgpEe.AYUAbz) it.next()).f6865A5SV6n = azWtSf.f6903B2KMhB.AMqCpz[azWtSf.f6904B3GDIM];
                            }
                            azWtSf.f6905B4ZgIw = false;
                        }
                        ((OvgpEe.AaHO0E) azWtSf.f135AcNBzu).invalidateSelf();
                        break;
                    } else {
                        OvgpEe.AYUAbz aYUAbz5 = (OvgpEe.AYUAbz) arrayList2.get(i4);
                        int i5 = i4 * 2;
                        int i6 = OvgpEe.AzWtSf.f6898BI9f7h[i5];
                        int[] iArr = OvgpEe.AzWtSf.f6897BChYOn;
                        float B2KMhB3 = com.bumptech.glide.AMqCpz.B2KMhB((i3 - i6) / iArr[i5], 0.0f, 1.0f);
                        Interpolator[] interpolatorArr = azWtSf.f6902B25kr6;
                        aYUAbz5.f6863A2egSU = com.bumptech.glide.AMqCpz.B2KMhB(interpolatorArr[i5].getInterpolation(B2KMhB3), 0.0f, 1.0f);
                        aYUAbz5.f6864A4TApA = com.bumptech.glide.AMqCpz.B2KMhB(interpolatorArr[i5 + 1].getInterpolation(com.bumptech.glide.AMqCpz.B2KMhB((i3 - r3[r4]) / iArr[r4], 0.0f, 1.0f)), 0.0f, 1.0f);
                        i4++;
                    }
                }
        }
    }
}
