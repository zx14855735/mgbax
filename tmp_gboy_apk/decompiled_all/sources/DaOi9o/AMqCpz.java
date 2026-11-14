package DaOi9o;

import AaHO0E.GEYgCP;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AMqCpz extends B4ZgIw {

    /* renamed from: CcAIMM, reason: collision with root package name */
    public static final String[] f2211CcAIMM = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public static final GEYgCP f2212Cd8JRx = new GEYgCP(PointF.class, "topLeft", 1);

    /* renamed from: CikNvS, reason: collision with root package name */
    public static final GEYgCP f2213CikNvS = new GEYgCP(PointF.class, "bottomRight", 2);

    /* renamed from: CkXcdM, reason: collision with root package name */
    public static final GEYgCP f2214CkXcdM = new GEYgCP(PointF.class, "bottomRight", 3);

    /* renamed from: CmUvjW, reason: collision with root package name */
    public static final GEYgCP f2215CmUvjW = new GEYgCP(PointF.class, "topLeft", 4);

    /* renamed from: CqNSpT, reason: collision with root package name */
    public static final GEYgCP f2216CqNSpT = new GEYgCP(PointF.class, "position", 5);

    static {
        fUPUGv();
    }

    public static void COJEAR(BmvVmW bmvVmW) {
        View view = bmvVmW.f2282A4TApA;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap hashMap = bmvVmW.f2281A2egSU;
        hashMap.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        hashMap.put("android:changeBounds:parent", bmvVmW.f2282A4TApA.getParent());
    }

    private static /* synthetic */ void fUPUGv() {
        char[] charArray = "59;x17;3x49/x%>3::x\u001c8?\u0014$?213".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'V');
        }
        String str = new String(charArray);
        char[] charArray2 = "5:?8?\"".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'V');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // DaOi9o.B4ZgIw
    public final void ADYaiT(BmvVmW bmvVmW) {
        COJEAR(bmvVmW);
    }

    @Override // DaOi9o.B4ZgIw
    public final void ASJ6gh(BmvVmW bmvVmW) {
        COJEAR(bmvVmW);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // DaOi9o.B4ZgIw
    public final Animator AaHO0E(ViewGroup viewGroup, BmvVmW bmvVmW, BmvVmW bmvVmW2) {
        int i;
        AMqCpz aMqCpz;
        ObjectAnimator A2egSU2;
        if (bmvVmW != null && bmvVmW2 != null) {
            HashMap hashMap = bmvVmW.f2281A2egSU;
            HashMap hashMap2 = bmvVmW2.f2281A2egSU;
            ViewGroup viewGroup2 = (ViewGroup) hashMap.get("android:changeBounds:parent");
            ViewGroup viewGroup3 = (ViewGroup) hashMap2.get("android:changeBounds:parent");
            if (viewGroup2 != null && viewGroup3 != null) {
                Rect rect = (Rect) hashMap.get("android:changeBounds:bounds");
                Rect rect2 = (Rect) hashMap2.get("android:changeBounds:bounds");
                int i2 = rect.left;
                int i3 = rect2.left;
                int i4 = rect.top;
                int i5 = rect2.top;
                int i6 = rect.right;
                int i7 = rect2.right;
                int i8 = rect.bottom;
                int i9 = rect2.bottom;
                int i10 = i6 - i2;
                int i11 = i8 - i4;
                int i12 = i7 - i3;
                int i13 = i9 - i5;
                Rect rect3 = (Rect) hashMap.get("android:changeBounds:clip");
                Rect rect4 = (Rect) hashMap2.get("android:changeBounds:clip");
                if ((i10 == 0 || i11 == 0) && (i12 == 0 || i13 == 0)) {
                    i = 0;
                } else {
                    i = (i2 == i3 && i4 == i5) ? 0 : 1;
                    if (i6 != i7 || i8 != i9) {
                        i++;
                    }
                }
                if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                    i++;
                }
                if (i > 0) {
                    View view = bmvVmW2.f2282A4TApA;
                    BpkvW3.A2egSU(view, i2, i4, i6, i8);
                    if (i != 2) {
                        aMqCpz = this;
                        A2egSU2 = (i2 == i3 && i4 == i5) ? AzWtSf.A2egSU(view, f2214CkXcdM, aMqCpz.f2261CNPG0E.A2egSU(i6, i8, i7, i9)) : AzWtSf.A2egSU(view, f2215CmUvjW, aMqCpz.f2261CNPG0E.A2egSU(i2, i4, i3, i5));
                    } else if (i10 == i12 && i11 == i13) {
                        aMqCpz = this;
                        A2egSU2 = AzWtSf.A2egSU(view, f2216CqNSpT, aMqCpz.f2261CNPG0E.A2egSU(i2, i4, i3, i5));
                    } else {
                        aMqCpz = this;
                        ADYaiT aDYaiT = new ADYaiT(view);
                        ObjectAnimator A2egSU3 = AzWtSf.A2egSU(aDYaiT, f2212Cd8JRx, aMqCpz.f2261CNPG0E.A2egSU(i2, i4, i3, i5));
                        ObjectAnimator A2egSU4 = AzWtSf.A2egSU(aDYaiT, f2213CikNvS, aMqCpz.f2261CNPG0E.A2egSU(i6, i8, i7, i9));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(A2egSU3, A2egSU4);
                        animatorSet.addListener(new A4TApA(aDYaiT));
                        A2egSU2 = animatorSet;
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                        com.bumptech.glide.A5SV6n.DXuj49(viewGroup4, true);
                        aMqCpz.B2KMhB().A2egSU(new A5SV6n(viewGroup4));
                    }
                    return A2egSU2;
                }
            }
        }
        return null;
    }

    @Override // DaOi9o.B4ZgIw
    public final String[] B4ZgIw() {
        return f2211CcAIMM;
    }
}
