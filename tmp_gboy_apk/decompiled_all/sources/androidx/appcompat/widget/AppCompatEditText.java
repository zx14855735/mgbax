package androidx.appcompat.widget;

import AaHO0E.B7CMnp;
import AaHO0E.BPw6Q8;
import AaHO0E.C4FrIb;
import AaHO0E.COJEAR;
import AaHO0E.D6DOie;
import AaHO0E.DRlcZ9;
import AaHO0E.GIi2tl;
import AaHO0E.GIl1rw;
import COJEAR.AMqCpz;
import COJEAR.ARc23Z;
import COJEAR.AYUAbz;
import COJEAR.BTvldC;
import COJEAR.DG07BK;
import CikNvS.B4ZgIw;
import CikNvS.B9tovu;
import JrXYwF.A4TApA;
import KCxDWD.A5SV6n;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AppCompatEditText extends EditText implements BTvldC, B9tovu {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B7CMnp f8148AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final DRlcZ9 f8149AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final C4FrIb f8150AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final B4ZgIw f8151AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final C4FrIb f8152B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public BPw6Q8 f8153B2KMhB;

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private BPw6Q8 getSuperCaller() {
        if (this.f8153B2KMhB == null) {
            this.f8153B2KMhB = new BPw6Q8(this);
        }
        return this.f8153B2KMhB;
    }

    @Override // COJEAR.BTvldC
    public final AYUAbz A2egSU(AYUAbz aYUAbz) {
        return this.f8151AzWtSf.A2egSU(this, aYUAbz);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        B7CMnp b7CMnp = this.f8148AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.A2egSU();
        }
        DRlcZ9 dRlcZ9 = this.f8149AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return A4TApA.DcUJf1(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        B7CMnp b7CMnp = this.f8148AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A4TApA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        B7CMnp b7CMnp = this.f8148AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A5SV6n();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8149AlLFFp.ADYaiT();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8149AlLFFp.AMqCpz();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C4FrIb c4FrIb;
        if (Build.VERSION.SDK_INT >= 28 || (c4FrIb = this.f8150AmA8tU) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) c4FrIb.f681A5SV6n;
        return textClassifier == null ? D6DOie.A2egSU((TextView) c4FrIb.f680A4TApA) : textClassifier;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        r6 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        if (r1 != null) goto L23;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r8) {
        /*
            r7 = this;
            android.view.inputmethod.InputConnection r0 = super.onCreateInputConnection(r8)
            AaHO0E.DRlcZ9 r1 = r7.f8149AlLFFp
            r1.getClass()
            AaHO0E.DRlcZ9.AYUAbz(r8, r0, r7)
            com.bumptech.glide.AMqCpz.CSDoyG(r8, r0, r7)
            if (r0 == 0) goto L77
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 > r2) goto L77
            java.lang.String[] r2 = COJEAR.DG07BK.AYUAbz(r7)
            if (r2 == 0) goto L77
            java.lang.String r3 = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String r4 = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            r5 = 25
            if (r1 < r5) goto L29
            Cd8JRx.A2egSU.AcNBzu(r8, r2)
            goto L3e
        L29:
            android.os.Bundle r6 = r8.extras
            if (r6 != 0) goto L34
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            r8.extras = r6
        L34:
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r4, r2)
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r3, r2)
        L3e:
            Cd8JRx.ADYaiT r2 = new Cd8JRx.ADYaiT
            r6 = 0
            r2.<init>(r6, r7)
            if (r1 < r5) goto L4d
            Cd8JRx.AMqCpz r1 = new Cd8JRx.AMqCpz
            r1.<init>(r0, r2)
        L4b:
            r0 = r1
            goto L77
        L4d:
            java.lang.String[] r6 = Cd8JRx.A5SV6n.f1777A2egSU
            if (r1 < r5) goto L59
            java.lang.String[] r1 = Cd8JRx.A2egSU.AlLFFp(r8)
            if (r1 == 0) goto L6d
        L57:
            r6 = r1
            goto L6d
        L59:
            android.os.Bundle r1 = r8.extras
            if (r1 != 0) goto L5e
            goto L6d
        L5e:
            java.lang.String[] r1 = r1.getStringArray(r4)
            if (r1 != 0) goto L6a
            android.os.Bundle r1 = r8.extras
            java.lang.String[] r1 = r1.getStringArray(r3)
        L6a:
            if (r1 == 0) goto L6d
            goto L57
        L6d:
            int r1 = r6.length
            if (r1 != 0) goto L71
            goto L77
        L71:
            Cd8JRx.ARc23Z r1 = new Cd8JRx.ARc23Z
            r1.<init>(r0, r2)
            goto L4b
        L77:
            AaHO0E.C4FrIb r1 = r7.f8152B25kr6
            D07BeM.A5SV6n r8 = r1.A5SV6n(r0, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatEditText.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i < 31 && i >= 24 && dragEvent.getLocalState() == null && DG07BK.AYUAbz(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                toString();
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                z = COJEAR.A2egSU(dragEvent, this, activity);
            }
        }
        if (z) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        AMqCpz aMqCpz;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31 || DG07BK.AYUAbz(this) == null || !(i == 16908322 || i == 16908337)) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i2 >= 31) {
                aMqCpz = new A5SV6n(primaryClip, 1);
            } else {
                ARc23Z aRc23Z = new ARc23Z();
                aRc23Z.f1619AlLFFp = primaryClip;
                aRc23Z.f1620AmA8tU = 1;
                aMqCpz = aRc23Z;
            }
            aMqCpz.AZOQYO(i == 16908322 ? 0 : 1);
            DG07BK.AzWtSf(this, aMqCpz.build());
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        B7CMnp b7CMnp = this.f8148AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AMqCpz();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        B7CMnp b7CMnp = this.f8148AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.ARc23Z(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f8149AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f8149AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(A4TApA.Ddcejp(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.f8152B25kr6.ADYaiT(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f8152B25kr6.A2egSU(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        B7CMnp b7CMnp = this.f8148AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AYUAbz(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        B7CMnp b7CMnp = this.f8148AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AZOQYO(mode);
        }
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        DRlcZ9 dRlcZ9 = this.f8149AlLFFp;
        dRlcZ9.AcNBzu(colorStateList);
        dRlcZ9.A4TApA();
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        DRlcZ9 dRlcZ9 = this.f8149AlLFFp;
        dRlcZ9.AlLFFp(mode);
        dRlcZ9.A4TApA();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        DRlcZ9 dRlcZ9 = this.f8149AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.ASJ6gh(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C4FrIb c4FrIb;
        if (Build.VERSION.SDK_INT >= 28 || (c4FrIb = this.f8150AmA8tU) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c4FrIb.f681A5SV6n = textClassifier;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 2130969051);
        GIl1rw.A2egSU(context);
        GIi2tl.A2egSU(getContext(), this);
        B7CMnp b7CMnp = new B7CMnp(this);
        this.f8148AcNBzu = b7CMnp;
        b7CMnp.ADYaiT(attributeSet, 2130969051);
        DRlcZ9 dRlcZ9 = new DRlcZ9(this);
        this.f8149AlLFFp = dRlcZ9;
        dRlcZ9.ARc23Z(attributeSet, 2130969051);
        dRlcZ9.A4TApA();
        C4FrIb c4FrIb = new C4FrIb();
        c4FrIb.f680A4TApA = this;
        this.f8150AmA8tU = c4FrIb;
        this.f8151AzWtSf = new B4ZgIw();
        C4FrIb c4FrIb2 = new C4FrIb(this);
        this.f8152B25kr6 = c4FrIb2;
        c4FrIb2.A4TApA(attributeSet, 2130969051);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean isFocusable = super.isFocusable();
        boolean isClickable = super.isClickable();
        boolean isLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener A2egSU2 = c4FrIb2.A2egSU(keyListener);
        if (A2egSU2 == keyListener) {
            return;
        }
        super.setKeyListener(A2egSU2);
        super.setRawInputType(inputType);
        super.setFocusable(isFocusable);
        super.setClickable(isClickable);
        super.setLongClickable(isLongClickable);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
