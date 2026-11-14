package AaHO0E;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BIYEnU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public ColorStateList f651A2egSU = null;

    /* renamed from: A4TApA, reason: collision with root package name */
    public PorterDuff.Mode f652A4TApA = null;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f653A5SV6n = false;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f654ADYaiT = false;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final TextView f655ARc23Z;

    public /* synthetic */ BIYEnU(TextView textView) {
        this.f655ARc23Z = textView;
    }

    public void A2egSU() {
        CompoundButton compoundButton = (CompoundButton) this.f655ARc23Z;
        Drawable CNPG0E2 = NOd7IU.AlLFFp.CNPG0E(compoundButton);
        if (CNPG0E2 != null) {
            if (this.f653A5SV6n || this.f654ADYaiT) {
                Drawable mutate = com.bumptech.glide.A5SV6n.DvK7DB(CNPG0E2).mutate();
                if (this.f653A5SV6n) {
                    BmvVmW.A2egSU.AYUAbz(mutate, this.f651A2egSU);
                }
                if (this.f654ADYaiT) {
                    BmvVmW.A2egSU.AZOQYO(mutate, this.f652A4TApA);
                }
                if (mutate.isStateful()) {
                    mutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(mutate);
            }
        }
    }

    public void A4TApA() {
        BI9f7h bI9f7h = (BI9f7h) this.f655ARc23Z;
        Drawable checkMarkDrawable = bI9f7h.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f653A5SV6n || this.f654ADYaiT) {
                Drawable mutate = com.bumptech.glide.A5SV6n.DvK7DB(checkMarkDrawable).mutate();
                if (this.f653A5SV6n) {
                    BmvVmW.A2egSU.AYUAbz(mutate, this.f651A2egSU);
                }
                if (this.f654ADYaiT) {
                    BmvVmW.A2egSU.AZOQYO(mutate, this.f652A4TApA);
                }
                if (mutate.isStateful()) {
                    mutate.setState(bI9f7h.getDrawableState());
                }
                bI9f7h.setCheckMarkDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0057 A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:3:0x001d, B:5:0x0024, B:8:0x002a, B:9:0x0050, B:11:0x0057, B:12:0x005e, B:14:0x0065, B:21:0x0039, B:23:0x003f, B:25:0x0045), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:3:0x001d, B:5:0x0024, B:8:0x002a, B:9:0x0050, B:11:0x0057, B:12:0x005e, B:14:0x0065, B:21:0x0039, B:23:0x003f, B:25:0x0045), top: B:2:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A5SV6n(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            android.widget.TextView r0 = r8.f655ARc23Z
            r1 = r0
            android.widget.CompoundButton r1 = (android.widget.CompoundButton) r1
            android.content.Context r0 = r1.getContext()
            int[] r3 = androidx.appcompat.R$styleable.f8025AlLFFp
            AaHO0E.GYpKKt r7 = AaHO0E.GYpKKt.ARc23Z(r0, r9, r3, r10)
            android.content.res.TypedArray r0 = r7.f884A4TApA
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r7.f884A4TApA
            r4 = r9
            r6 = r10
            COJEAR.DG07BK.B3GDIM(r1, r2, r3, r4, r5, r6)
            r9 = 1
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L36
            r2 = 0
            if (r10 == 0) goto L39
            int r9 = r0.getResourceId(r9, r2)     // Catch: java.lang.Throwable -> L36
            if (r9 == 0) goto L39
            android.content.Context r10 = r1.getContext()     // Catch: java.lang.Throwable -> L36 android.content.res.Resources.NotFoundException -> L39
            android.graphics.drawable.Drawable r9 = NOd7IU.AlLFFp.CQhlFr(r10, r9)     // Catch: java.lang.Throwable -> L36 android.content.res.Resources.NotFoundException -> L39
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L36 android.content.res.Resources.NotFoundException -> L39
            goto L50
        L36:
            r0 = move-exception
            r9 = r0
            goto L76
        L39:
            boolean r9 = r0.hasValue(r2)     // Catch: java.lang.Throwable -> L36
            if (r9 == 0) goto L50
            int r9 = r0.getResourceId(r2, r2)     // Catch: java.lang.Throwable -> L36
            if (r9 == 0) goto L50
            android.content.Context r10 = r1.getContext()     // Catch: java.lang.Throwable -> L36
            android.graphics.drawable.Drawable r9 = NOd7IU.AlLFFp.CQhlFr(r10, r9)     // Catch: java.lang.Throwable -> L36
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L36
        L50:
            r9 = 2
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L36
            if (r10 == 0) goto L5e
            android.content.res.ColorStateList r9 = r7.A2egSU(r9)     // Catch: java.lang.Throwable -> L36
            CikNvS.A4TApA.A5SV6n(r1, r9)     // Catch: java.lang.Throwable -> L36
        L5e:
            r9 = 3
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L36
            if (r10 == 0) goto L72
            r10 = -1
            int r9 = r0.getInt(r9, r10)     // Catch: java.lang.Throwable -> L36
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = AaHO0E.EGM26s.A5SV6n(r9, r10)     // Catch: java.lang.Throwable -> L36
            CikNvS.A4TApA.ADYaiT(r1, r9)     // Catch: java.lang.Throwable -> L36
        L72:
            r7.ASJ6gh()
            return
        L76:
            r7.ASJ6gh()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: AaHO0E.BIYEnU.A5SV6n(android.util.AttributeSet, int):void");
    }
}
