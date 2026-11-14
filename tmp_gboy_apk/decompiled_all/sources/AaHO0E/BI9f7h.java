package AaHO0E;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BI9f7h extends CheckedTextView implements CikNvS.B9tovu {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final BIYEnU f647AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final B7CMnp f648AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final DRlcZ9 f649AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public BTvldC f650AzWtSf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0080 A[Catch: all -> 0x005f, TryCatch #1 {all -> 0x005f, blocks: (B:3:0x0046, B:5:0x004d, B:8:0x0053, B:9:0x0079, B:11:0x0080, B:12:0x0087, B:14:0x008e, B:21:0x0062, B:23:0x0068, B:25:0x006e), top: B:2:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008e A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #1 {all -> 0x005f, blocks: (B:3:0x0046, B:5:0x004d, B:8:0x0053, B:9:0x0079, B:11:0x0080, B:12:0x0087, B:14:0x008e, B:21:0x0062, B:23:0x0068, B:25:0x006e), top: B:2:0x0046 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BI9f7h(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            AaHO0E.GIl1rw.A2egSU(r8)
            r6 = 2130968786(0x7f0400d2, float:1.7546235E38)
            r7.<init>(r8, r9, r6)
            android.content.Context r8 = r7.getContext()
            AaHO0E.GIi2tl.A2egSU(r8, r7)
            AaHO0E.DRlcZ9 r8 = new AaHO0E.DRlcZ9
            r8.<init>(r7)
            r7.f649AmA8tU = r8
            r8.ARc23Z(r9, r6)
            r8.A4TApA()
            AaHO0E.B7CMnp r8 = new AaHO0E.B7CMnp
            r8.<init>(r7)
            r7.f648AlLFFp = r8
            r8.ADYaiT(r9, r6)
            AaHO0E.BIYEnU r8 = new AaHO0E.BIYEnU
            r8.<init>(r7)
            r7.f647AcNBzu = r8
            android.content.Context r8 = r7.getContext()
            int[] r3 = androidx.appcompat.R$styleable.f8024AcNBzu
            AaHO0E.GYpKKt r8 = AaHO0E.GYpKKt.ARc23Z(r8, r9, r3, r6)
            android.content.res.TypedArray r0 = r8.f884A4TApA
            android.content.Context r2 = r7.getContext()
            android.content.res.TypedArray r5 = r8.f884A4TApA
            r1 = r7
            r4 = r9
            COJEAR.DG07BK.B3GDIM(r1, r2, r3, r4, r5, r6)
            r9 = 1
            boolean r2 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L5f
            r3 = 0
            if (r2 == 0) goto L62
            int r9 = r0.getResourceId(r9, r3)     // Catch: java.lang.Throwable -> L5f
            if (r9 == 0) goto L62
            android.content.Context r2 = r7.getContext()     // Catch: java.lang.Throwable -> L5f android.content.res.Resources.NotFoundException -> L62
            android.graphics.drawable.Drawable r9 = NOd7IU.AlLFFp.CQhlFr(r2, r9)     // Catch: java.lang.Throwable -> L5f android.content.res.Resources.NotFoundException -> L62
            r7.setCheckMarkDrawable(r9)     // Catch: java.lang.Throwable -> L5f android.content.res.Resources.NotFoundException -> L62
            goto L79
        L5f:
            r0 = move-exception
            r9 = r0
            goto La6
        L62:
            boolean r9 = r0.hasValue(r3)     // Catch: java.lang.Throwable -> L5f
            if (r9 == 0) goto L79
            int r9 = r0.getResourceId(r3, r3)     // Catch: java.lang.Throwable -> L5f
            if (r9 == 0) goto L79
            android.content.Context r2 = r7.getContext()     // Catch: java.lang.Throwable -> L5f
            android.graphics.drawable.Drawable r9 = NOd7IU.AlLFFp.CQhlFr(r2, r9)     // Catch: java.lang.Throwable -> L5f
            r7.setCheckMarkDrawable(r9)     // Catch: java.lang.Throwable -> L5f
        L79:
            r9 = 2
            boolean r2 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L5f
            if (r2 == 0) goto L87
            android.content.res.ColorStateList r9 = r8.A2egSU(r9)     // Catch: java.lang.Throwable -> L5f
            r7.setCheckMarkTintList(r9)     // Catch: java.lang.Throwable -> L5f
        L87:
            r9 = 3
            boolean r2 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L5f
            if (r2 == 0) goto L9b
            r2 = -1
            int r9 = r0.getInt(r9, r2)     // Catch: java.lang.Throwable -> L5f
            r0 = 0
            android.graphics.PorterDuff$Mode r9 = AaHO0E.EGM26s.A5SV6n(r9, r0)     // Catch: java.lang.Throwable -> L5f
            r7.setCheckMarkTintMode(r9)     // Catch: java.lang.Throwable -> L5f
        L9b:
            r8.ASJ6gh()
            AaHO0E.BTvldC r8 = r7.getEmojiTextViewHelper()
            r8.A4TApA(r4, r6)
            return
        La6:
            r8.ASJ6gh()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: AaHO0E.BI9f7h.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private BTvldC getEmojiTextViewHelper() {
        if (this.f650AzWtSf == null) {
            this.f650AzWtSf = new BTvldC(this);
        }
        return this.f650AzWtSf;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        DRlcZ9 dRlcZ9 = this.f649AmA8tU;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
        B7CMnp b7CMnp = this.f648AlLFFp;
        if (b7CMnp != null) {
            b7CMnp.A2egSU();
        }
        BIYEnU bIYEnU = this.f647AcNBzu;
        if (bIYEnU != null) {
            bIYEnU.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return JrXYwF.A4TApA.DcUJf1(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        B7CMnp b7CMnp = this.f648AlLFFp;
        if (b7CMnp != null) {
            return b7CMnp.A4TApA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        B7CMnp b7CMnp = this.f648AlLFFp;
        if (b7CMnp != null) {
            return b7CMnp.A5SV6n();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        BIYEnU bIYEnU = this.f647AcNBzu;
        if (bIYEnU != null) {
            return bIYEnU.f651A2egSU;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        BIYEnU bIYEnU = this.f647AcNBzu;
        if (bIYEnU != null) {
            return bIYEnU.f652A4TApA;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f649AmA8tU.ADYaiT();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f649AmA8tU.AMqCpz();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        com.bumptech.glide.AMqCpz.CSDoyG(editorInfo, onCreateInputConnection, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().A5SV6n(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        B7CMnp b7CMnp = this.f648AlLFFp;
        if (b7CMnp != null) {
            b7CMnp.AMqCpz();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        B7CMnp b7CMnp = this.f648AlLFFp;
        if (b7CMnp != null) {
            b7CMnp.ARc23Z(i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        BIYEnU bIYEnU = this.f647AcNBzu;
        if (bIYEnU != null) {
            if (bIYEnU.AMqCpz) {
                bIYEnU.AMqCpz = false;
            } else {
                bIYEnU.AMqCpz = true;
                bIYEnU.A4TApA();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f649AmA8tU;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f649AmA8tU;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(JrXYwF.A4TApA.Ddcejp(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().ADYaiT(z);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        B7CMnp b7CMnp = this.f648AlLFFp;
        if (b7CMnp != null) {
            b7CMnp.AYUAbz(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        B7CMnp b7CMnp = this.f648AlLFFp;
        if (b7CMnp != null) {
            b7CMnp.AZOQYO(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        BIYEnU bIYEnU = this.f647AcNBzu;
        if (bIYEnU != null) {
            bIYEnU.f651A2egSU = colorStateList;
            bIYEnU.f653A5SV6n = true;
            bIYEnU.A4TApA();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        BIYEnU bIYEnU = this.f647AcNBzu;
        if (bIYEnU != null) {
            bIYEnU.f652A4TApA = mode;
            bIYEnU.f654ADYaiT = true;
            bIYEnU.A4TApA();
        }
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        DRlcZ9 dRlcZ9 = this.f649AmA8tU;
        dRlcZ9.AcNBzu(colorStateList);
        dRlcZ9.A4TApA();
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        DRlcZ9 dRlcZ9 = this.f649AmA8tU;
        dRlcZ9.AlLFFp(mode);
        dRlcZ9.A4TApA();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        DRlcZ9 dRlcZ9 = this.f649AmA8tU;
        if (dRlcZ9 != null) {
            dRlcZ9.ASJ6gh(context, i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(NOd7IU.AlLFFp.CQhlFr(getContext(), i));
    }
}
