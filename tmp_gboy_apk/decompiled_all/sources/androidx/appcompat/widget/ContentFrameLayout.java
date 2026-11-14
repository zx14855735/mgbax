package androidx.appcompat.widget;

import ADYaiT.BTvldC;
import ADYaiT.CkXcdM;
import AZkASS.AmA8tU;
import AaHO0E.AYUAbz;
import AaHO0E.AzWtSf;
import AaHO0E.Dphsd2;
import AaHO0E.DuwtYk;
import AaHO0E.H6qKiO;
import COJEAR.De4eam;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public TypedValue f8164AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public TypedValue f8165AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public TypedValue f8166AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public TypedValue f8167AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public TypedValue f8168B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public TypedValue f8169B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final Rect f8170B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public Dphsd2 f8171B4ZgIw;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f8170B3GDIM = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f8168B25kr6 == null) {
            this.f8168B25kr6 = new TypedValue();
        }
        return this.f8168B25kr6;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f8169B2KMhB == null) {
            this.f8169B2KMhB = new TypedValue();
        }
        return this.f8169B2KMhB;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f8166AmA8tU == null) {
            this.f8166AmA8tU = new TypedValue();
        }
        return this.f8166AmA8tU;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f8167AzWtSf == null) {
            this.f8167AzWtSf = new TypedValue();
        }
        return this.f8167AzWtSf;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f8164AcNBzu == null) {
            this.f8164AcNBzu = new TypedValue();
        }
        return this.f8164AcNBzu;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f8165AlLFFp == null) {
            this.f8165AlLFFp = new TypedValue();
        }
        return this.f8165AlLFFp;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Dphsd2 dphsd2 = this.f8171B4ZgIw;
        if (dphsd2 != null) {
            dphsd2.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        AzWtSf azWtSf;
        super.onDetachedFromWindow();
        Dphsd2 dphsd2 = this.f8171B4ZgIw;
        if (dphsd2 != null) {
            CkXcdM ckXcdM = ((BTvldC) dphsd2).f109AcNBzu;
            DuwtYk duwtYk = ckXcdM.f164BV3sI0;
            if (duwtYk != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) duwtYk;
                actionBarOverlayLayout.AMqCpz();
                ActionMenuView actionMenuView = ((H6qKiO) actionBarOverlayLayout.f8113B25kr6).f898A2egSU.f8219AcNBzu;
                if (actionMenuView != null && (azWtSf = actionMenuView.f8140BniPrB) != null) {
                    azWtSf.AcNBzu();
                    AYUAbz aYUAbz = azWtSf.BpkvW3;
                    if (aYUAbz != null && aYUAbz.A4TApA()) {
                        aYUAbz.f568AZOQYO.dismiss();
                    }
                }
            }
            if (ckXcdM.f168C4FrIb != null) {
                ckXcdM.f158BI9f7h.getDecorView().removeCallbacks(ckXcdM.f169CASmeH);
                if (ckXcdM.f168C4FrIb.isShowing()) {
                    try {
                        ckXcdM.f168C4FrIb.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                ckXcdM.f168C4FrIb = null;
            }
            De4eam de4eam = ckXcdM.f170CNPG0E;
            if (de4eam != null) {
                de4eam.A4TApA();
            }
            AmA8tU amA8tU = ckXcdM.BTvldC(0).f144AYUAbz;
            if (amA8tU != null) {
                amA8tU.A5SV6n(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b3  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(Dphsd2 dphsd2) {
        this.f8171B4ZgIw = dphsd2;
    }
}
