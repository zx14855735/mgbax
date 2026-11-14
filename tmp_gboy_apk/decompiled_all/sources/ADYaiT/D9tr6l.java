package ADYaiT;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D9tr6l implements AZkASS.BJ7GGh, Oay4Bh.COJEAR {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f222AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f223AlLFFp;

    public /* synthetic */ D9tr6l(Object obj) {
        this.f223AlLFFp = obj;
    }

    @Override // AZkASS.BJ7GGh
    public void A2egSU(AZkASS.AmA8tU amA8tU, boolean z) {
        AaHO0E.AzWtSf azWtSf;
        if (this.f222AcNBzu) {
            return;
        }
        this.f222AcNBzu = true;
        DAk1zC dAk1zC = (DAk1zC) this.f223AlLFFp;
        ActionMenuView actionMenuView = dAk1zC.f224A2egSU.f898A2egSU.f8219AcNBzu;
        if (actionMenuView != null && (azWtSf = actionMenuView.f8140BniPrB) != null) {
            azWtSf.AcNBzu();
            AaHO0E.AYUAbz aYUAbz = azWtSf.BpkvW3;
            if (aYUAbz != null && aYUAbz.A4TApA()) {
                aYUAbz.f568AZOQYO.dismiss();
            }
        }
        dAk1zC.f225A4TApA.onPanelClosed(108, amA8tU);
        this.f222AcNBzu = false;
    }

    public void A4TApA(NIA37H.A2egSU a2egSU) {
        synchronized (this.f223AlLFFp) {
        }
    }

    public boolean A5SV6n() {
        return this.f222AcNBzu;
    }

    public boolean ADYaiT(CharSequence charSequence, int i) {
        if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
            throw new IllegalArgumentException();
        }
        if (((CASmeH.AZkASS) this.f223AlLFFp) == null) {
            return A5SV6n();
        }
        char c = 2;
        for (int i2 = 0; i2 < i && c == 2; i2++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i2));
            D9tr6l d9tr6l = CASmeH.AaHO0E.f1606A2egSU;
            if (directionality != 0) {
                if (directionality != 1 && directionality != 2) {
                    switch (directionality) {
                        case 14:
                        case 15:
                            break;
                        case 16:
                        case 17:
                            break;
                        default:
                            c = 2;
                            break;
                    }
                }
                c = 0;
            }
            c = 1;
        }
        if (c == 0) {
            return true;
        }
        if (c != 1) {
            return A5SV6n();
        }
        return false;
    }

    @Override // AZkASS.BJ7GGh
    public boolean AMqCpz(AZkASS.AmA8tU amA8tU) {
        ((DAk1zC) this.f223AlLFFp).f225A4TApA.onMenuOpened(108, amA8tU);
        return true;
    }

    public synchronized void ARc23Z(HXc4pW.BTvldC bTvldC, boolean z) {
        try {
            if (!this.f222AcNBzu && !z) {
                this.f222AcNBzu = true;
                bTvldC.A2egSU();
                this.f222AcNBzu = false;
            }
            ((Handler) this.f223AlLFFp).obtainMessage(1, bTvldC).sendToTarget();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    @Override // Oay4Bh.COJEAR
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public COJEAR.FG7pZc AZOQYO(android.view.View r11, COJEAR.FG7pZc r12, Oay4Bh.CQhlFr r13) {
        /*
            r10 = this;
            COJEAR.F32kj0 r0 = r12.f1747A2egSU
            r1 = 7
            BV3sI0.A5SV6n r1 = r0.ARc23Z(r1)
            r2 = 32
            BV3sI0.A5SV6n r0 = r0.ARc23Z(r2)
            int r2 = r1.f1483A4TApA
            java.lang.Object r3 = r10.f223AlLFFp
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r3
            r3.f11410C4FrIb = r2
            boolean r2 = Oay4Bh.C4FrIb.AlLFFp(r11)
            int r4 = r11.getPaddingBottom()
            int r5 = r11.getPaddingLeft()
            int r6 = r11.getPaddingRight()
            boolean r7 = r3.f11403BNL6CD
            if (r7 == 0) goto L32
            int r4 = r12.A2egSU()
            r3.f11409C2rE4F = r4
            int r7 = r13.f6615ADYaiT
            int r4 = r4 + r7
        L32:
            boolean r7 = r3.f11404BPw6Q8
            int r8 = r1.f1482A2egSU
            if (r7 == 0) goto L40
            if (r2 == 0) goto L3d
            int r5 = r13.f6614A5SV6n
            goto L3f
        L3d:
            int r5 = r13.f6612A2egSU
        L3f:
            int r5 = r5 + r8
        L40:
            boolean r7 = r3.f11405BTvldC
            int r9 = r1.f1484A5SV6n
            if (r7 == 0) goto L4f
            if (r2 == 0) goto L4b
            int r13 = r13.f6612A2egSU
            goto L4d
        L4b:
            int r13 = r13.f6614A5SV6n
        L4d:
            int r6 = r13 + r9
        L4f:
            android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
            boolean r2 = r3.f11407BmvVmW
            r7 = 1
            if (r2 == 0) goto L62
            int r2 = r13.leftMargin
            if (r2 == r8) goto L62
            r13.leftMargin = r8
            r2 = 1
            goto L63
        L62:
            r2 = 0
        L63:
            boolean r8 = r3.f11408BniPrB
            if (r8 == 0) goto L6e
            int r8 = r13.rightMargin
            if (r8 == r9) goto L6e
            r13.rightMargin = r9
            r2 = 1
        L6e:
            boolean r8 = r3.BpkvW3
            if (r8 == 0) goto L7b
            int r8 = r13.topMargin
            int r1 = r1.f1483A4TApA
            if (r8 == r1) goto L7b
            r13.topMargin = r1
            goto L7c
        L7b:
            r7 = r2
        L7c:
            if (r7 == 0) goto L81
            r11.setLayoutParams(r13)
        L81:
            int r13 = r11.getPaddingTop()
            r11.setPadding(r5, r13, r6, r4)
            boolean r11 = r10.f222AcNBzu
            if (r11 == 0) goto L90
            int r13 = r0.f1485ADYaiT
            r3.f11401BIYEnU = r13
        L90:
            boolean r13 = r3.f11403BNL6CD
            if (r13 != 0) goto L98
            if (r11 == 0) goto L97
            goto L98
        L97:
            return r12
        L98:
            r3.BIYEnU()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.D9tr6l.AZOQYO(android.view.View, COJEAR.FG7pZc, Oay4Bh.CQhlFr):COJEAR.FG7pZc");
    }

    public D9tr6l(int i) {
        switch (i) {
            case 3:
                this.f223AlLFFp = new Object();
                break;
            default:
                this.f223AlLFFp = new Handler(Looper.getMainLooper(), new HXc4pW.BniPrB(0));
                break;
        }
    }

    public D9tr6l(CASmeH.AZkASS aZkASS, boolean z) {
        this(aZkASS);
        this.f222AcNBzu = z;
    }

    public D9tr6l(BottomSheetBehavior bottomSheetBehavior, boolean z) {
        this.f223AlLFFp = bottomSheetBehavior;
        this.f222AcNBzu = z;
    }
}
