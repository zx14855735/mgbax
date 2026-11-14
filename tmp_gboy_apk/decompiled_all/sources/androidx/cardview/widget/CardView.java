package androidx.cardview.widget;

import ADYaiT.BmvVmW;
import K1Z3yj.A2egSU;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.cardview.R$styleable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final int[] f8269B2KMhB = {R.attr.colorBackground};

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final BmvVmW f8270B3GDIM = new BmvVmW(2);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f8271AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f8272AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Rect f8273AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Rect f8274AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final A2egSU f8275B25kr6;

    static {
        MfuXx();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130968756);
    }

    private static /* synthetic */ void MfuXx() {
        char[] charArray = "ñýÿ¼õóÿ÷¼ðýë¼áú÷þþ¼ØüûÐàûöõ÷".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 146);
        }
        String str = new String(charArray);
        char[] charArray2 = "ñþûüûæ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 146);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((AzWtSf.A2egSU) ((Drawable) this.f8275B25kr6.f4174AlLFFp)).f963AYUAbz;
    }

    public float getCardElevation() {
        return ((CardView) this.f8275B25kr6.f4175AmA8tU).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f8273AmA8tU.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f8273AmA8tU.left;
    }

    public int getContentPaddingRight() {
        return this.f8273AmA8tU.right;
    }

    public int getContentPaddingTop() {
        return this.f8273AmA8tU.top;
    }

    public float getMaxCardElevation() {
        return ((AzWtSf.A2egSU) ((Drawable) this.f8275B25kr6.f4174AlLFFp)).AMqCpz;
    }

    public boolean getPreventCornerOverlap() {
        return this.f8272AlLFFp;
    }

    public float getRadius() {
        return ((AzWtSf.A2egSU) ((Drawable) this.f8275B25kr6.f4174AlLFFp)).f957A2egSU;
    }

    public boolean getUseCompatPadding() {
        return this.f8271AcNBzu;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        ColorStateList valueOf = ColorStateList.valueOf(i);
        AzWtSf.A2egSU a2egSU = (AzWtSf.A2egSU) ((Drawable) this.f8275B25kr6.f4174AlLFFp);
        if (valueOf == null) {
            a2egSU.getClass();
            valueOf = ColorStateList.valueOf(0);
        }
        a2egSU.f963AYUAbz = valueOf;
        a2egSU.f958A4TApA.setColor(valueOf.getColorForState(a2egSU.getState(), a2egSU.f963AYUAbz.getDefaultColor()));
        a2egSU.invalidateSelf();
    }

    public void setCardElevation(float f) {
        ((CardView) this.f8275B25kr6.f4175AmA8tU).setElevation(f);
    }

    public void setMaxCardElevation(float f) {
        f8270B3GDIM.AZkASS(this.f8275B25kr6, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f8272AlLFFp) {
            this.f8272AlLFFp = z;
            BmvVmW bmvVmW = f8270B3GDIM;
            A2egSU a2egSU = this.f8275B25kr6;
            bmvVmW.AZkASS(a2egSU, ((AzWtSf.A2egSU) ((Drawable) a2egSU.f4174AlLFFp)).AMqCpz);
        }
    }

    public void setRadius(float f) {
        AzWtSf.A2egSU a2egSU = (AzWtSf.A2egSU) ((Drawable) this.f8275B25kr6.f4174AlLFFp);
        if (f == a2egSU.f957A2egSU) {
            return;
        }
        a2egSU.f957A2egSU = f;
        a2egSU.A4TApA(null);
        a2egSU.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f8271AcNBzu != z) {
            this.f8271AcNBzu = z;
            BmvVmW bmvVmW = f8270B3GDIM;
            A2egSU a2egSU = this.f8275B25kr6;
            bmvVmW.AZkASS(a2egSU, ((AzWtSf.A2egSU) ((Drawable) a2egSU.f4174AlLFFp)).AMqCpz);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f8273AmA8tU = rect;
        this.f8274AzWtSf = new Rect();
        A2egSU a2egSU = new A2egSU(3, this);
        this.f8275B25kr6 = a2egSU;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8268A2egSU, i, 2131951913);
        if (obtainStyledAttributes.hasValue(2)) {
            valueOf = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f8269B2KMhB);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            valueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(2131099693) : getResources().getColor(2131099692));
        }
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.f8271AcNBzu = obtainStyledAttributes.getBoolean(7, false);
        this.f8272AlLFFp = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        BmvVmW bmvVmW = f8270B3GDIM;
        AzWtSf.A2egSU a2egSU2 = new AzWtSf.A2egSU(valueOf, dimension);
        a2egSU.f4174AlLFFp = a2egSU2;
        setBackgroundDrawable(a2egSU2);
        setClipToOutline(true);
        setElevation(dimension2);
        bmvVmW.AZkASS(a2egSU, dimension3);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        AzWtSf.A2egSU a2egSU = (AzWtSf.A2egSU) ((Drawable) this.f8275B25kr6.f4174AlLFFp);
        if (colorStateList == null) {
            a2egSU.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        a2egSU.f963AYUAbz = colorStateList;
        a2egSU.f958A4TApA.setColor(colorStateList.getColorForState(a2egSU.getState(), a2egSU.f963AYUAbz.getDefaultColor()));
        a2egSU.invalidateSelf();
    }
}
