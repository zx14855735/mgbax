package AaHO0E;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BniPrB extends MultiAutoCompleteTextView implements CikNvS.B9tovu {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final int[] f674AzWtSf = {R.attr.popupBackground};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B7CMnp f675AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final DRlcZ9 f676AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final C4FrIb f677AmA8tU;

    static {
        iDNiewY();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BniPrB(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130968646);
        GIl1rw.A2egSU(context);
        GIi2tl.A2egSU(getContext(), this);
        GYpKKt ARc23Z2 = GYpKKt.ARc23Z(getContext(), attributeSet, f674AzWtSf, 2130968646);
        if (ARc23Z2.f884A4TApA.hasValue(0)) {
            setDropDownBackgroundDrawable(ARc23Z2.A4TApA(0));
        }
        ARc23Z2.ASJ6gh();
        B7CMnp b7CMnp = new B7CMnp(this);
        this.f675AcNBzu = b7CMnp;
        b7CMnp.ADYaiT(attributeSet, 2130968646);
        DRlcZ9 dRlcZ9 = new DRlcZ9(this);
        this.f676AlLFFp = dRlcZ9;
        dRlcZ9.ARc23Z(attributeSet, 2130968646);
        dRlcZ9.A4TApA();
        C4FrIb c4FrIb = new C4FrIb(this);
        this.f677AmA8tU = c4FrIb;
        c4FrIb.A4TApA(attributeSet, 2130968646);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean isFocusable = isFocusable();
        boolean isClickable = isClickable();
        boolean isLongClickable = isLongClickable();
        int inputType = getInputType();
        KeyListener A2egSU2 = c4FrIb.A2egSU(keyListener);
        if (A2egSU2 == keyListener) {
            return;
        }
        super.setKeyListener(A2egSU2);
        setRawInputType(inputType);
        setFocusable(isFocusable);
        setClickable(isClickable);
        setLongClickable(isLongClickable);
    }

    private static /* synthetic */ void iDNiewY() {
        char[] charArray = "áíï¬åãïç¬àíû¬ñêçîî¬ÈìëÀðëæåç".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 130);
        }
        String str = new String(charArray);
        char[] charArray2 = "áîëìëö".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 130);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        B7CMnp b7CMnp = this.f675AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.A2egSU();
        }
        DRlcZ9 dRlcZ9 = this.f676AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        B7CMnp b7CMnp = this.f675AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A4TApA();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        B7CMnp b7CMnp = this.f675AcNBzu;
        if (b7CMnp != null) {
            return b7CMnp.A5SV6n();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f676AlLFFp.ADYaiT();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f676AlLFFp.AMqCpz();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        com.bumptech.glide.AMqCpz.CSDoyG(editorInfo, onCreateInputConnection, this);
        return this.f677AmA8tU.A5SV6n(onCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        B7CMnp b7CMnp = this.f675AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AMqCpz();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        B7CMnp b7CMnp = this.f675AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.ARc23Z(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f676AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        DRlcZ9 dRlcZ9 = this.f676AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.A4TApA();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(NOd7IU.AlLFFp.CQhlFr(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.f677AmA8tU.ADYaiT(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f677AmA8tU.A2egSU(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        B7CMnp b7CMnp = this.f675AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AYUAbz(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        B7CMnp b7CMnp = this.f675AcNBzu;
        if (b7CMnp != null) {
            b7CMnp.AZOQYO(mode);
        }
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        DRlcZ9 dRlcZ9 = this.f676AlLFFp;
        dRlcZ9.AcNBzu(colorStateList);
        dRlcZ9.A4TApA();
    }

    @Override // CikNvS.B9tovu
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        DRlcZ9 dRlcZ9 = this.f676AlLFFp;
        dRlcZ9.AlLFFp(mode);
        dRlcZ9.A4TApA();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        DRlcZ9 dRlcZ9 = this.f676AlLFFp;
        if (dRlcZ9 != null) {
            dRlcZ9.ASJ6gh(context, i);
        }
    }
}
