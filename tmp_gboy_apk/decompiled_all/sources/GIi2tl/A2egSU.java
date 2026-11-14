package GIi2tl;

import AZOQYO.ARc23Z;
import EY4UKY.ADYaiT;
import Fyurov.ASJ6gh;
import GJee0v.AZOQYO;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.bean.Shake;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f2993A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Context f2994A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f2995A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final boolean f2996ADYaiT;
    public LinearLayout AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public FrameLayout f2997ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public LinearLayout f2998ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public LinearLayout f2999AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public LinearLayout f3000AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public LinearLayout f3001AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public ViewGroup f3002AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final LinearLayout f3003AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public LinearLayout f3004AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final FrameLayout f3005AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final FrameLayout f3006AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final FrameLayout f3007B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public FrameLayout f3008B2KMhB = null;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public FrameLayout f3009B3GDIM = null;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public FrameLayout f3010B4ZgIw = null;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public FrameLayout f3011B7CMnp = null;

    /* renamed from: B9tovu, reason: collision with root package name */
    public FrameLayout f3012B9tovu = null;

    /* renamed from: BChYOn, reason: collision with root package name */
    public FrameLayout f3013BChYOn = null;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public FrameLayout f3014BI9f7h = null;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final int[] f3015BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public ASJ6gh f3016BJ7GGh;

    public A2egSU(Context context, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int i5;
        int[] iArr;
        double d;
        double d2;
        float f;
        View view;
        LinearLayout linearLayout;
        double d3;
        double d4;
        float f2;
        View view2;
        LinearLayout linearLayout2;
        double d5;
        double d6;
        float f3;
        float f4;
        View view3;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        float f5;
        View view4;
        LinearLayout linearLayout5;
        this.AMqCpz = null;
        this.f2997ARc23Z = null;
        this.f2998ASJ6gh = null;
        this.f2999AYUAbz = null;
        this.f3000AZOQYO = null;
        this.f3001AZkASS = null;
        this.f3002AaHO0E = null;
        this.f3003AcNBzu = null;
        this.f3004AlLFFp = null;
        this.f3005AmA8tU = null;
        this.f3006AzWtSf = null;
        this.f3007B25kr6 = null;
        int[] iArr2 = new int[2];
        this.f3015BIYEnU = iArr2;
        this.f2994A4TApA = context;
        this.f2995A5SV6n = i;
        this.f2993A2egSU = i2;
        this.f2996ADYaiT = z;
        int i6 = AZOQYO.f3039AcNBzu;
        float f6 = 12.0f;
        switch (i2) {
            case 1:
                i5 = i;
                iArr = iArr2;
                ARc23Z(true);
                break;
            case 2:
                i5 = i;
                iArr = iArr2;
                if (z) {
                    d = i5;
                    d2 = 0.85d;
                } else {
                    d = i5;
                    d2 = 0.75d;
                }
                float f7 = (float) (d * d2);
                if ((A2egSU(f7) * 0.9d) / 16.0d <= i3) {
                    f7 += 25.0f;
                    f = 49.0f;
                } else {
                    f = 24.0f;
                }
                iArr[1] = (int) f7;
                LinearLayout A5SV6n2 = A5SV6n(A2egSU(i5), 1.0f, A2egSU(f7), 1);
                if (z) {
                    LinearLayout A5SV6n3 = A5SV6n(-1, 36.0f, 0, 0);
                    AMqCpz(A5SV6n3, (String) ARc23Z.f361B3GDIM.f364AlLFFp, 0.0f, 0.0f, 0.0f, 0.0f);
                    LinearLayout A5SV6n4 = A5SV6n(0, 12.0f, -1, 1);
                    linearLayout = ASJ6gh(336.0f);
                    com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n3, A5SV6n4, linearLayout, A5SV6n(0, 12.0f, -1, 1));
                    view = A5SV6n3;
                } else {
                    view = null;
                    linearLayout = null;
                }
                LinearLayout A5SV6n5 = A5SV6n(-1, 296.0f, 0, 0);
                A5SV6n2.addView(A5SV6n5);
                if (z && view != null) {
                    A5SV6n2.addView(view);
                    this.f3004AlLFFp = linearLayout;
                }
                LinearLayout A5SV6n6 = A5SV6n(0, 12.0f, -1, 1);
                LinearLayout A5SV6n7 = A5SV6n(0, 336.0f, -1, 1);
                com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n5, A5SV6n6, A5SV6n7, A5SV6n(0, 12.0f, -1, 1));
                View A5SV6n8 = A5SV6n(-1, 12.0f, 0, 1);
                LinearLayout A5SV6n9 = A5SV6n(-1, 224.0f, 0, 1);
                AMqCpz(A5SV6n9, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
                FrameLayout frameLayout = new FrameLayout(context);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                A5SV6n9.addView(frameLayout);
                AYUAbz(false);
                View A5SV6n10 = A5SV6n(-1, 12.0f, 0, 1);
                LinearLayout A5SV6n11 = A5SV6n(-1, f, 0, 1);
                LinearLayout A5SV6n12 = A5SV6n(-1, 12.0f, 0, 1);
                LinearLayout A5SV6n13 = A5SV6n(-1, 24.0f, 0, 0);
                LinearLayout A5SV6n14 = A5SV6n(-1, 12.0f, 0, 1);
                A5SV6n7.addView(A5SV6n8);
                A5SV6n7.addView(A5SV6n9);
                A5SV6n7.addView(A5SV6n10);
                A5SV6n7.addView(A5SV6n11);
                com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n7, A5SV6n12, A5SV6n13, A5SV6n14);
                LinearLayout A5SV6n15 = A5SV6n(0, 42.0f, -1, 1);
                View A5SV6n16 = A5SV6n(0, 8.0f, -1, 1);
                LinearLayout ASJ6gh2 = ASJ6gh(174.0f);
                View A5SV6n17 = A5SV6n(0, 12.0f, -1, 1);
                LinearLayout A5SV6n18 = A5SV6n(0, 80.0f, -1, 1);
                LinearLayout A5SV6n19 = A5SV6n(0, 6.0f, -1, 1);
                LinearLayout A5SV6n20 = A5SV6n(0, 20.0f, -1, 1);
                A5SV6n13.addView(A5SV6n15);
                A5SV6n13.addView(A5SV6n16);
                A5SV6n13.addView(ASJ6gh2);
                A5SV6n13.addView(A5SV6n17);
                com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n13, A5SV6n18, A5SV6n19, A5SV6n20);
                this.AMqCpz = A5SV6n2;
                this.f2997ARc23Z = frameLayout;
                this.f2998ASJ6gh = A5SV6n11;
                this.f2999AYUAbz = ASJ6gh2;
                this.f3000AZOQYO = A5SV6n18;
                this.f3001AZkASS = A5SV6n20;
                this.f3002AaHO0E = A5SV6n15;
                break;
            case 3:
                iArr = iArr2;
                if (z) {
                    i5 = i;
                    d3 = i5;
                    d4 = 0.775d;
                } else {
                    i5 = i;
                    d3 = i5;
                    d4 = 0.675d;
                }
                float f8 = (float) (d3 * d4);
                iArr[1] = (int) f8;
                LinearLayout A5SV6n21 = A5SV6n(A2egSU(i5), 1.0f, A2egSU(f8), 1);
                LinearLayout A5SV6n22 = A5SV6n(-1, 243.0f, 0, 0);
                if (z) {
                    LinearLayout A5SV6n23 = A5SV6n(-1, 36.0f, 0, 0);
                    f2 = 24.0f;
                    AMqCpz(A5SV6n23, (String) ARc23Z.f361B3GDIM.f364AlLFFp, 0.0f, 0.0f, 0.0f, 0.0f);
                    LinearLayout A5SV6n24 = A5SV6n(0, 12.0f, -1, 1);
                    linearLayout2 = ASJ6gh(336.0f);
                    com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n23, A5SV6n24, linearLayout2, A5SV6n(0, 12.0f, -1, 1));
                    view2 = A5SV6n23;
                } else {
                    f2 = 24.0f;
                    view2 = null;
                    linearLayout2 = null;
                }
                A5SV6n21.addView(A5SV6n22);
                if (z && view2 != null) {
                    A5SV6n21.addView(view2);
                    this.f3004AlLFFp = linearLayout2;
                }
                LinearLayout A5SV6n25 = A5SV6n(0, 12.0f, -1, 1);
                LinearLayout A5SV6n26 = A5SV6n(0, 336.0f, -1, 1);
                com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n22, A5SV6n25, A5SV6n26, A5SV6n(0, 12.0f, -1, 1));
                View A5SV6n27 = A5SV6n(-1, 12.0f, 0, 1);
                LinearLayout A5SV6n28 = A5SV6n(-1, 209.0f, 0, 1);
                AMqCpz(A5SV6n28, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
                FrameLayout frameLayout2 = new FrameLayout(context);
                frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                A5SV6n28.addView(frameLayout2);
                AYUAbz(false);
                View A5SV6n29 = A5SV6n(-1, 12.0f, 0, 1);
                LinearLayout A5SV6n30 = A5SV6n(-1, f2, 0, 0);
                View A5SV6n31 = A5SV6n(-1, 12.0f, 0, 1);
                A5SV6n26.addView(A5SV6n27);
                A5SV6n26.addView(A5SV6n28);
                A5SV6n26.addView(A5SV6n29);
                A5SV6n26.addView(A5SV6n30);
                A5SV6n26.addView(A5SV6n31);
                LinearLayout A5SV6n32 = A5SV6n(0, 42.0f, -1, 1);
                View A5SV6n33 = A5SV6n(0, 8.0f, -1, 1);
                LinearLayout ASJ6gh3 = ASJ6gh(174.0f);
                View A5SV6n34 = A5SV6n(0, 12.0f, -1, 1);
                LinearLayout A5SV6n35 = A5SV6n(0, 80.0f, -1, 1);
                LinearLayout A5SV6n36 = A5SV6n(0, 6.0f, -1, 1);
                LinearLayout A5SV6n37 = A5SV6n(0, 20.0f, -1, 1);
                A5SV6n30.addView(A5SV6n32);
                A5SV6n30.addView(A5SV6n33);
                A5SV6n30.addView(ASJ6gh3);
                A5SV6n30.addView(A5SV6n34);
                com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n30, A5SV6n35, A5SV6n36, A5SV6n37);
                this.AMqCpz = A5SV6n21;
                this.f2997ARc23Z = frameLayout2;
                this.f2999AYUAbz = ASJ6gh3;
                this.f3000AZOQYO = A5SV6n35;
                this.f3001AZkASS = A5SV6n37;
                this.f3002AaHO0E = A5SV6n32;
                break;
            case 4:
                iArr = iArr2;
                if (z) {
                    d5 = i;
                    d6 = 0.53d;
                } else {
                    d5 = i;
                    d6 = 0.43d;
                }
                float f9 = (float) (d5 * d6);
                if ((A2egSU(f9) * 0.9d) / 16.0d <= i3) {
                    f9 += 25.0f;
                    f3 = 49.0f;
                } else {
                    f3 = 24.0f;
                }
                iArr[1] = (int) f9;
                LinearLayout A5SV6n38 = A5SV6n(A2egSU(i), 1.0f, A2egSU(f9), 1);
                LinearLayout A5SV6n39 = A5SV6n(-1, 181.0f, 0, 0);
                if (z) {
                    LinearLayout A5SV6n40 = A5SV6n(-1, 36.0f, 0, 0);
                    f4 = 1.0f;
                    AMqCpz(A5SV6n40, (String) ARc23Z.f361B3GDIM.f364AlLFFp, 0.0f, 0.0f, 0.0f, 0.0f);
                    LinearLayout A5SV6n41 = A5SV6n(0, 12.0f, -1, 1);
                    linearLayout3 = ASJ6gh(336.0f);
                    com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n40, A5SV6n41, linearLayout3, A5SV6n(0, 12.0f, -1, 1));
                    view3 = A5SV6n40;
                } else {
                    f4 = 1.0f;
                    view3 = null;
                    linearLayout3 = null;
                }
                A5SV6n38.addView(A5SV6n39);
                if (z && view3 != null) {
                    A5SV6n38.addView(view3);
                    this.f3004AlLFFp = linearLayout3;
                }
                LinearLayout A5SV6n42 = A5SV6n(0, 12.0f, -1, 1);
                LinearLayout A5SV6n43 = A5SV6n(0, 336.0f, -1, 1);
                com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n39, A5SV6n42, A5SV6n43, A5SV6n(0, 12.0f, -1, 1));
                View A5SV6n44 = A5SV6n(-1, 12.0f, 0, 1);
                LinearLayout A5SV6n45 = A5SV6n(-1, f3, 0, 1);
                View A5SV6n46 = A5SV6n(-1, 12.0f, 0, 1);
                LinearLayout A5SV6n47 = A5SV6n(-1, 72.0f, 0, 0);
                FrameLayout frameLayout3 = new FrameLayout(context);
                frameLayout3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                A5SV6n47.addView(frameLayout3);
                LinearLayout A5SV6n48 = A5SV6n(-1, f4, -1, 0);
                LinearLayout A5SV6n49 = A5SV6n(-1, 12.0f, 0, 1);
                LinearLayout A5SV6n50 = A5SV6n(-1, 24.0f, 0, 0);
                LinearLayout A5SV6n51 = A5SV6n(-1, 12.0f, 0, 1);
                A5SV6n43.addView(A5SV6n44);
                A5SV6n43.addView(A5SV6n45);
                A5SV6n43.addView(A5SV6n46);
                A5SV6n43.addView(A5SV6n47);
                com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n43, A5SV6n49, A5SV6n50, A5SV6n51);
                if (i4 == 2) {
                    LinearLayout A5SV6n52 = A5SV6n(0, 166.0f, -1, 1);
                    linearLayout4 = A5SV6n50;
                    AMqCpz(A5SV6n52, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
                    FrameLayout frameLayout4 = new FrameLayout(context);
                    frameLayout4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    A5SV6n52.addView(frameLayout4);
                    LinearLayout A5SV6n53 = A5SV6n(0, 4.0f, -1, 1);
                    LinearLayout A5SV6n54 = A5SV6n(0, 166.0f, -1, 1);
                    AMqCpz(A5SV6n54, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
                    FrameLayout frameLayout5 = new FrameLayout(context);
                    frameLayout5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    A5SV6n54.addView(frameLayout5);
                    com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n48, A5SV6n52, A5SV6n53, A5SV6n54);
                    this.f3005AmA8tU = frameLayout4;
                    this.f3006AzWtSf = frameLayout5;
                } else {
                    linearLayout4 = A5SV6n50;
                    LinearLayout A5SV6n55 = A5SV6n(0, 109.0f, -1, 1);
                    AMqCpz(A5SV6n55, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
                    FrameLayout frameLayout6 = new FrameLayout(context);
                    frameLayout6.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    A5SV6n55.addView(frameLayout6);
                    View A5SV6n56 = A5SV6n(0, 4.0f, -1, 1);
                    LinearLayout A5SV6n57 = A5SV6n(0, 109.0f, -1, 1);
                    AMqCpz(A5SV6n57, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
                    FrameLayout frameLayout7 = new FrameLayout(context);
                    frameLayout7.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    A5SV6n57.addView(frameLayout7);
                    View A5SV6n58 = A5SV6n(0, 4.0f, -1, 1);
                    LinearLayout A5SV6n59 = A5SV6n(0, 109.0f, -1, 1);
                    AMqCpz(A5SV6n59, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
                    FrameLayout frameLayout8 = new FrameLayout(context);
                    frameLayout8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    A5SV6n59.addView(frameLayout8);
                    A5SV6n48.addView(A5SV6n55);
                    A5SV6n48.addView(A5SV6n56);
                    A5SV6n48.addView(A5SV6n57);
                    A5SV6n48.addView(A5SV6n58);
                    A5SV6n48.addView(A5SV6n59);
                    this.f3005AmA8tU = frameLayout6;
                    this.f3006AzWtSf = frameLayout7;
                    this.f3007B25kr6 = frameLayout8;
                }
                frameLayout3.addView(A5SV6n48);
                LinearLayout A5SV6n60 = A5SV6n(0, 42.0f, -1, 1);
                View A5SV6n61 = A5SV6n(0, 8.0f, -1, 1);
                LinearLayout ASJ6gh4 = ASJ6gh(174.0f);
                View A5SV6n62 = A5SV6n(0, 12.0f, -1, 1);
                LinearLayout A5SV6n63 = A5SV6n(0, 80.0f, -1, 1);
                LinearLayout A5SV6n64 = A5SV6n(0, 6.0f, -1, 1);
                LinearLayout A5SV6n65 = A5SV6n(0, 20.0f, -1, 1);
                linearLayout4.addView(A5SV6n60);
                linearLayout4.addView(A5SV6n61);
                linearLayout4.addView(ASJ6gh4);
                linearLayout4.addView(A5SV6n62);
                com.bumptech.glide.A5SV6n.ASJ6gh(linearLayout4, A5SV6n63, A5SV6n64, A5SV6n65);
                this.f2997ARc23Z = frameLayout3;
                this.AMqCpz = A5SV6n38;
                this.f2998ASJ6gh = A5SV6n45;
                this.f2999AYUAbz = ASJ6gh4;
                this.f3000AZOQYO = A5SV6n63;
                this.f3001AZkASS = A5SV6n65;
                this.f3002AaHO0E = A5SV6n60;
                i5 = i;
                break;
            case 5:
                iArr = iArr2;
                ARc23Z(false);
                i5 = i;
                break;
            case 6:
                float f10 = (float) (z ? i * 0.9d : i * 0.8d);
                iArr = iArr2;
                if ((A2egSU(f10) * 0.9d) / 16.0d <= i3) {
                    f10 += 25.0f;
                    f5 = 49.0f;
                } else {
                    f5 = 24.0f;
                }
                iArr[1] = (int) f10;
                LinearLayout A5SV6n66 = A5SV6n(A2egSU(i), 1.0f, A2egSU(f10), 1);
                LinearLayout A5SV6n67 = A5SV6n(-1, 296.0f, 0, 0);
                if (z) {
                    LinearLayout A5SV6n68 = A5SV6n(-1, 36.0f, 0, 0);
                    AMqCpz(A5SV6n68, (String) ARc23Z.f361B3GDIM.f364AlLFFp, 0.0f, 0.0f, 0.0f, 0.0f);
                    LinearLayout A5SV6n69 = A5SV6n(0, 12.0f, -1, 1);
                    linearLayout5 = ASJ6gh(336.0f);
                    com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n68, A5SV6n69, linearLayout5, A5SV6n(0, 12.0f, -1, 1));
                    view4 = A5SV6n68;
                } else {
                    view4 = null;
                    linearLayout5 = null;
                }
                A5SV6n66.addView(A5SV6n67);
                if (z && view4 != null) {
                    A5SV6n66.addView(view4);
                    this.f3004AlLFFp = linearLayout5;
                }
                LinearLayout A5SV6n70 = A5SV6n(0, 12.0f, -1, 1);
                LinearLayout A5SV6n71 = A5SV6n(0, 336.0f, -1, 1);
                com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n67, A5SV6n70, A5SV6n71, A5SV6n(0, 12.0f, -1, 1));
                View A5SV6n72 = A5SV6n(-1, 12.0f, 0, 1);
                LinearLayout A5SV6n73 = A5SV6n(-1, 32.0f, 0, 0);
                View A5SV6n74 = A5SV6n(-1, 12.0f, 0, 1);
                LinearLayout A5SV6n75 = A5SV6n(-1, f5, 0, 1);
                LinearLayout A5SV6n76 = A5SV6n(-1, 12.0f, 0, 1);
                LinearLayout A5SV6n77 = A5SV6n(-1, 197.0f, 0, 1);
                AMqCpz(A5SV6n77, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
                FrameLayout frameLayout9 = new FrameLayout(context);
                frameLayout9.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                A5SV6n77.addView(frameLayout9);
                AYUAbz(true);
                LinearLayout A5SV6n78 = A5SV6n(-1, 12.0f, 0, 1);
                A5SV6n71.addView(A5SV6n72);
                A5SV6n71.addView(A5SV6n73);
                A5SV6n71.addView(A5SV6n74);
                A5SV6n71.addView(A5SV6n75);
                com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n71, A5SV6n76, A5SV6n77, A5SV6n78);
                if (z2) {
                    LinearLayout A5SV6n79 = A5SV6n(0, 32.0f, -1, 1);
                    View A5SV6n80 = A5SV6n(0, 12.0f, -1, 1);
                    A5SV6n73.addView(A5SV6n79);
                    A5SV6n73.addView(A5SV6n80);
                    this.f3003AcNBzu = A5SV6n79;
                } else {
                    f6 = 56.0f;
                }
                LinearLayout ASJ6gh5 = ASJ6gh(192.0f);
                View A5SV6n81 = A5SV6n(0, f6, -1, 1);
                LinearLayout ASJ6gh6 = ASJ6gh(80.0f);
                View A5SV6n82 = A5SV6n(0, 6.0f, -1, 1);
                LinearLayout A5SV6n83 = A5SV6n(0, 20.0f, -1, 1);
                A5SV6n73.addView(ASJ6gh5);
                A5SV6n73.addView(A5SV6n81);
                A5SV6n73.addView(ASJ6gh6);
                A5SV6n73.addView(A5SV6n82);
                A5SV6n73.addView(A5SV6n83);
                this.AMqCpz = A5SV6n66;
                this.f2997ARc23Z = frameLayout9;
                this.f2998ASJ6gh = A5SV6n75;
                this.f2999AYUAbz = ASJ6gh5;
                this.f3000AZOQYO = ASJ6gh6;
                this.f3001AZkASS = A5SV6n83;
                i5 = i;
                break;
            default:
                i5 = i;
                iArr = iArr2;
                break;
        }
        iArr[0] = i5;
    }

    public final int A2egSU(float f) {
        Context context = this.f2994A4TApA;
        if (context == null) {
            int i = AZOQYO.f3039AcNBzu;
        } else {
            f = (f * context.getResources().getDisplayMetrics().density) + 0.5f;
        }
        return (int) f;
    }

    public final FrameLayout A4TApA(int i, Shake shake, FOAO9d.A2egSU a2egSU) {
        Context context = this.f2994A4TApA;
        int i2 = this.f2995A5SV6n;
        if (i == 1) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.setBackgroundColor(Color.parseColor("#42000000"));
            double d = i2;
            double d2 = 0.2d * d;
            int A2egSU2 = A2egSU((float) d2);
            FrameLayout frameLayout2 = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(A2egSU2, A2egSU2);
            layoutParams.gravity = 17;
            frameLayout2.setLayoutParams(layoutParams);
            ASJ6gh aSJ6gh = new ASJ6gh(this.f2994A4TApA, 2, (int) d2, shake, a2egSU);
            this.f3016BJ7GGh = aSJ6gh;
            frameLayout2.addView(aSJ6gh.f2923AZOQYO);
            ImageView imageView = new ImageView(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(A2egSU((float) (d * 0.117d)), A2egSU((float) (d * 0.05d)));
            layoutParams2.gravity = 8388691;
            imageView.setLayoutParams(layoutParams2);
            imageView.setImageResource(2131231427);
            frameLayout.addView(frameLayout2);
            frameLayout.addView(imageView);
            return frameLayout;
        }
        if (i != 2) {
            if (i != 3) {
                return null;
            }
            FrameLayout frameLayout3 = new FrameLayout(context);
            frameLayout3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout3.setBackgroundColor(Color.parseColor("#42000000"));
            double d3 = i2 * 0.2d;
            int A2egSU3 = A2egSU((float) d3);
            FrameLayout frameLayout4 = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(A2egSU3, A2egSU3);
            layoutParams3.gravity = 17;
            frameLayout4.setLayoutParams(layoutParams3);
            ASJ6gh aSJ6gh2 = new ASJ6gh(this.f2994A4TApA, 2, (int) d3, shake, a2egSU);
            this.f3016BJ7GGh = aSJ6gh2;
            frameLayout4.addView(aSJ6gh2.f2923AZOQYO);
            frameLayout3.addView(frameLayout4);
            return frameLayout3;
        }
        FrameLayout frameLayout5 = new FrameLayout(context);
        frameLayout5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout5.setBackgroundColor(Color.parseColor("#42000000"));
        double d4 = i2;
        double d5 = d4 * 0.25d;
        int A2egSU4 = A2egSU((float) d5);
        FrameLayout frameLayout6 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(A2egSU4, A2egSU4);
        layoutParams4.gravity = 81;
        layoutParams4.setMargins(0, 0, 0, A2egSU((float) (0.2d * d4)));
        frameLayout6.setLayoutParams(layoutParams4);
        ASJ6gh aSJ6gh3 = new ASJ6gh(this.f2994A4TApA, 2, (int) d5, shake, a2egSU);
        this.f3016BJ7GGh = aSJ6gh3;
        frameLayout6.addView(aSJ6gh3.f2923AZOQYO);
        frameLayout5.addView(frameLayout6);
        ViewGroup frameLayout7 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(A2egSU((float) (0.4d * d4)), A2egSU((float) (0.07d * d4)));
        layoutParams5.gravity = 81;
        layoutParams5.setMargins(0, 0, 0, A2egSU((float) (0.13d * d4)));
        frameLayout7.setLayoutParams(layoutParams5);
        float f = (float) (d4 * 0.03d);
        AMqCpz(frameLayout7, "#80000000", f, f, f, f);
        TextView textView = new TextView(context);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 17;
        textView.setText("跳转详情页或下载APP");
        textView.setTextSize(10.0f);
        if (i2 <= 180) {
            textView.setTextSize(7.0f);
        } else if (i2 <= 240) {
            textView.setTextSize(8.0f);
        } else if (i2 <= 300) {
            textView.setTextSize(9.0f);
        }
        textView.setTextColor(Color.parseColor("#ffffffff"));
        frameLayout7.addView(textView, layoutParams6);
        frameLayout5.addView(frameLayout7);
        int i3 = this.f2993A2egSU;
        if (i3 != 2 && i3 != 3) {
            ImageView imageView2 = new ImageView(context);
            FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(A2egSU((float) (d4 * 0.117d)), A2egSU((float) (d4 * 0.05d)));
            layoutParams7.gravity = 8388691;
            layoutParams7.setMargins(A2egSU(8.0f), 0, 0, A2egSU(8.0f));
            imageView2.setLayoutParams(layoutParams7);
            imageView2.setImageResource(2131231427);
            frameLayout5.addView(imageView2);
        }
        return frameLayout5;
    }

    public final LinearLayout A5SV6n(int i, float f, int i2, int i3) {
        LinearLayout linearLayout = new LinearLayout(this.f2994A4TApA);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2, f);
        linearLayout.setOrientation(i3);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor((String) ARc23Z.f361B3GDIM.f363AcNBzu));
        return linearLayout;
    }

    public final void ADYaiT(View view, Bitmap bitmap) {
        Context context = this.f2994A4TApA;
        if (context == null || view == null || bitmap == null) {
            return;
        }
        if (ADYaiT.f2522BIYEnU > 4500) {
            bitmap = JrXYwF.A4TApA.A4TApA(bitmap, 10.0f);
        }
        if (bitmap == null) {
            return;
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(bitmap);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(Color.parseColor("#38FFFFFF"));
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.addView(imageView);
        viewGroup.addView(frameLayout);
    }

    public final void AMqCpz(ViewGroup viewGroup, String str, float f, float f2, float f3, float f4) {
        if (viewGroup == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadii(new float[]{A2egSU(f), A2egSU(f), A2egSU(f2), A2egSU(f2), A2egSU(f3), A2egSU(f3), A2egSU(f4), A2egSU(f4)});
        viewGroup.setBackground(gradientDrawable);
    }

    public final void ARc23Z(boolean z) {
        double d;
        double d2;
        boolean z2;
        LinearLayout linearLayout;
        View view;
        LinearLayout linearLayout2;
        int i = this.f2995A5SV6n;
        boolean z3 = this.f2996ADYaiT;
        if (z3) {
            d = i;
            d2 = 0.37d;
        } else {
            d = i;
            d2 = 0.27d;
        }
        float f = (float) (d * d2);
        this.f3015BIYEnU[1] = (int) f;
        LinearLayout A5SV6n2 = A5SV6n(A2egSU(i), 1.0f, A2egSU(f), 1);
        LinearLayout A5SV6n3 = A5SV6n(-1, 12.0f, 0, 1);
        LinearLayout A5SV6n4 = A5SV6n(-1, 72.0f, 0, 0);
        LinearLayout A5SV6n5 = A5SV6n(-1, 12.0f, 0, 1);
        if (z3) {
            LinearLayout A5SV6n6 = A5SV6n(-1, 36.0f, 0, 0);
            z2 = z3;
            linearLayout = A5SV6n5;
            AMqCpz(A5SV6n6, (String) ARc23Z.f361B3GDIM.f364AlLFFp, 0.0f, 0.0f, 0.0f, 0.0f);
            LinearLayout A5SV6n7 = A5SV6n(0, 12.0f, -1, 1);
            linearLayout2 = ASJ6gh(336.0f);
            com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n6, A5SV6n7, linearLayout2, A5SV6n(0, 12.0f, -1, 1));
            view = A5SV6n6;
        } else {
            z2 = z3;
            linearLayout = A5SV6n5;
            view = null;
            linearLayout2 = null;
        }
        com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n2, A5SV6n3, A5SV6n4, linearLayout);
        if (z2 && view != null) {
            A5SV6n2.addView(view);
            this.f3004AlLFFp = linearLayout2;
        }
        View A5SV6n8 = A5SV6n(0, 12.0f, -1, 1);
        LinearLayout A5SV6n9 = A5SV6n(0, 128.0f, -1, 1);
        AMqCpz(A5SV6n9, "#FF000000", 4.0f, 4.0f, 4.0f, 4.0f);
        Context context = this.f2994A4TApA;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        A5SV6n9.addView(frameLayout);
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout2.setBackgroundColor(Color.parseColor("#00000000"));
        FrameLayout frameLayout3 = new FrameLayout(context);
        double d3 = i;
        float f2 = (float) (d3 * 0.045d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(A2egSU(f2), A2egSU(f2));
        layoutParams.gravity = 8388659;
        layoutParams.setMargins(A2egSU(2.0f), A2egSU(2.0f), 0, 0);
        frameLayout3.setLayoutParams(layoutParams);
        FrameLayout frameLayout4 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(A2egSU((float) (d3 * 0.117d)), A2egSU((float) (d3 * 0.05d)));
        layoutParams2.gravity = 8388691;
        frameLayout4.setLayoutParams(layoutParams2);
        FrameLayout frameLayout5 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(A2egSU((float) (0.08d * d3)), A2egSU((float) (d3 * 0.03d)));
        layoutParams3.gravity = 8388693;
        layoutParams3.setMargins(0, 0, A2egSU(2.0f), A2egSU(4.0f));
        frameLayout5.setLayoutParams(layoutParams3);
        FrameLayout frameLayout6 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, A2egSU(3.0f));
        layoutParams4.gravity = 80;
        frameLayout6.setLayoutParams(layoutParams4);
        frameLayout2.addView(frameLayout3);
        frameLayout2.addView(frameLayout4);
        frameLayout2.addView(frameLayout5);
        frameLayout2.addView(frameLayout6);
        this.f3010B4ZgIw = frameLayout3;
        this.f3011B7CMnp = frameLayout2;
        this.f3002AaHO0E = frameLayout4;
        this.f3008B2KMhB = frameLayout5;
        this.f3009B3GDIM = frameLayout6;
        LinearLayout A5SV6n10 = A5SV6n(0, 12.0f, -1, 1);
        LinearLayout A5SV6n11 = A5SV6n(0, 196.0f, -1, 1);
        View A5SV6n12 = A5SV6n(0, 12.0f, -1, 1);
        A5SV6n4.addView(A5SV6n8);
        if (z) {
            com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n4, A5SV6n9, A5SV6n10, A5SV6n11);
        } else {
            com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n4, A5SV6n11, A5SV6n10, A5SV6n9);
        }
        A5SV6n4.addView(A5SV6n12);
        LinearLayout A5SV6n13 = A5SV6n(-1, 49.0f, 0, 1);
        LinearLayout A5SV6n14 = A5SV6n(-1, 7.0f, 0, 1);
        LinearLayout A5SV6n15 = A5SV6n(-1, 18.0f, 0, 0);
        com.bumptech.glide.A5SV6n.ASJ6gh(A5SV6n11, A5SV6n13, A5SV6n14, A5SV6n15);
        LinearLayout A5SV6n16 = A5SV6n(0, 118.0f, -1, 1);
        View A5SV6n17 = A5SV6n(0, 6.0f, -1, 1);
        LinearLayout A5SV6n18 = A5SV6n(0, 52.0f, -1, 1);
        View A5SV6n19 = A5SV6n(0, 6.0f, -1, 1);
        LinearLayout A5SV6n20 = A5SV6n(0, 20.0f, -1, 1);
        A5SV6n15.addView(A5SV6n16);
        A5SV6n15.addView(A5SV6n17);
        A5SV6n15.addView(A5SV6n18);
        A5SV6n15.addView(A5SV6n19);
        A5SV6n15.addView(A5SV6n20);
        this.AMqCpz = A5SV6n2;
        this.f2997ARc23Z = frameLayout;
        this.f2998ASJ6gh = A5SV6n13;
        this.f2999AYUAbz = A5SV6n16;
        this.f3000AZOQYO = A5SV6n18;
        this.f3001AZkASS = A5SV6n20;
    }

    public final LinearLayout ASJ6gh(float f) {
        LinearLayout linearLayout = new LinearLayout(this.f2994A4TApA);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, f);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor((String) ARc23Z.f361B3GDIM.f363AcNBzu));
        return linearLayout;
    }

    public final void AYUAbz(boolean z) {
        double d;
        Context context = this.f2994A4TApA;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(Color.parseColor("#00000000"));
        FrameLayout frameLayout2 = new FrameLayout(context);
        double d2 = this.f2995A5SV6n;
        float f = (float) (0.078d * d2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(A2egSU(f), A2egSU(f));
        layoutParams.gravity = 8388659;
        layoutParams.setMargins(A2egSU(4.0f), A2egSU(4.0f), 0, 0);
        frameLayout2.setLayoutParams(layoutParams);
        if (z) {
            FrameLayout frameLayout3 = new FrameLayout(context);
            d = 0.05d;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(A2egSU((float) (0.117d * d2)), A2egSU((float) (d2 * 0.05d)));
            layoutParams2.setMargins(A2egSU(8.0f), 0, 0, A2egSU(8.0f));
            layoutParams2.gravity = 8388691;
            frameLayout3.setLayoutParams(layoutParams2);
            frameLayout.addView(frameLayout3);
            this.f3002AaHO0E = frameLayout3;
        } else {
            d = 0.05d;
        }
        FrameLayout frameLayout4 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(A2egSU((float) (0.106d * d2)), A2egSU((float) (d2 * d)));
        layoutParams3.gravity = 8388693;
        layoutParams.setMargins(0, 0, A2egSU(8.0f), A2egSU(8.0f));
        frameLayout4.setLayoutParams(layoutParams3);
        FrameLayout frameLayout5 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, A2egSU(2.0f));
        layoutParams4.gravity = 80;
        frameLayout5.setLayoutParams(layoutParams4);
        FrameLayout frameLayout6 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(A2egSU((float) (0.4d * d2)), A2egSU((float) (d2 * 0.08d)));
        layoutParams5.gravity = 81;
        layoutParams5.setMargins(0, 0, 0, A2egSU(5.0f));
        frameLayout6.setLayoutParams(layoutParams5);
        frameLayout.addView(frameLayout2);
        frameLayout.addView(frameLayout4);
        frameLayout.addView(frameLayout5);
        frameLayout.addView(frameLayout6);
        this.f3010B4ZgIw = frameLayout2;
        this.f3011B7CMnp = frameLayout;
        this.f3008B2KMhB = frameLayout4;
        this.f3009B3GDIM = frameLayout5;
        this.f3014BI9f7h = frameLayout6;
    }
}
