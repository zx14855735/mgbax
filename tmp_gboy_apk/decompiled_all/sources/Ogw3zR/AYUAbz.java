package Ogw3zR;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz extends A2egSU {

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final float f6647ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final float f6648AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public float f6649AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public Rect f6650AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public Rect f6651AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public float[] f6652AcNBzu;

    public AYUAbz(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f6647ASJ6gh = resources.getDimension(2131165630);
        this.f6648AYUAbz = resources.getDimension(2131165629);
    }

    public final AnimatorSet A2egSU(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        View view2 = this.f6638A4TApA;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f));
        animatorSet.addListener(new AaHO0E.A5SV6n(10, view));
        return animatorSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        r12 = r6.getRoundedCorner(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        r13 = r6.getRoundedCorner(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
    
        r8 = r6.getRoundedCorner(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        r5 = r6.getRoundedCorner(3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[] A4TApA() {
        /*
            r14 = this;
            r0 = 8
            r1 = 3
            r2 = 1
            r3 = 0
            r4 = 2
            float[] r5 = r14.f6652AcNBzu
            if (r5 != 0) goto L9b
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 31
            if (r5 < r6) goto L94
            android.view.View r5 = r14.f6638A4TApA
            android.view.WindowInsets r6 = com.bytedance.pangle.wrapper.AMqCpz.AaHO0E(r5)
            if (r6 == 0) goto L94
            android.content.res.Resources r7 = r5.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            int r8 = r7.widthPixels
            int r7 = r7.heightPixels
            int[] r9 = new int[r4]
            r5.getLocationOnScreen(r9)
            r10 = r9[r3]
            r9 = r9[r2]
            int r11 = r5.getWidth()
            int r5 = r5.getHeight()
            if (r10 != 0) goto L44
            if (r9 != 0) goto L44
            android.view.RoundedCorner r12 = COJEAR.ADYaiT.AZOQYO(r6, r3)
            if (r12 == 0) goto L44
            int r12 = COJEAR.ADYaiT.A5SV6n(r12)
            goto L45
        L44:
            r12 = 0
        L45:
            int r11 = r11 + r10
            if (r11 < r8) goto L55
            if (r9 != 0) goto L55
            android.view.RoundedCorner r13 = COJEAR.ADYaiT.AZOQYO(r6, r2)
            if (r13 == 0) goto L55
            int r13 = COJEAR.ADYaiT.A5SV6n(r13)
            goto L56
        L55:
            r13 = 0
        L56:
            if (r11 < r8) goto L67
            int r8 = r9 + r5
            if (r8 < r7) goto L67
            android.view.RoundedCorner r8 = COJEAR.ADYaiT.AZOQYO(r6, r4)
            if (r8 == 0) goto L67
            int r8 = COJEAR.ADYaiT.A5SV6n(r8)
            goto L68
        L67:
            r8 = 0
        L68:
            if (r10 != 0) goto L78
            int r9 = r9 + r5
            if (r9 < r7) goto L78
            android.view.RoundedCorner r5 = COJEAR.ADYaiT.AZOQYO(r6, r1)
            if (r5 == 0) goto L78
            int r5 = COJEAR.ADYaiT.A5SV6n(r5)
            goto L79
        L78:
            r5 = 0
        L79:
            float r6 = (float) r12
            float r7 = (float) r13
            float r8 = (float) r8
            float r5 = (float) r5
            float[] r0 = new float[r0]
            r0[r3] = r6
            r0[r2] = r6
            r0[r4] = r7
            r0[r1] = r7
            r1 = 4
            r0[r1] = r8
            r1 = 5
            r0[r1] = r8
            r1 = 6
            r0[r1] = r5
            r1 = 7
            r0[r1] = r5
            goto L99
        L94:
            float[] r0 = new float[r0]
            r0 = {x009e: FILL_ARRAY_DATA , data: [0, 0, 0, 0, 0, 0, 0, 0} // fill-array
        L99:
            r14.f6652AcNBzu = r0
        L9b:
            float[] r0 = r14.f6652AcNBzu
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Ogw3zR.AYUAbz.A4TApA():float[]");
    }
}
