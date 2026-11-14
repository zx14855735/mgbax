package AaHO0E;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class GYpKKt {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f883A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final TypedArray f884A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public TypedValue f885A5SV6n;

    public GYpKKt(Context context, TypedArray typedArray) {
        this.f883A2egSU = context;
        this.f884A4TApA = typedArray;
    }

    public static GYpKKt AMqCpz(Context context, AttributeSet attributeSet, int[] iArr) {
        return new GYpKKt(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static GYpKKt ARc23Z(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new GYpKKt(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public final ColorStateList A2egSU(int i) {
        int resourceId;
        ColorStateList A5SV6n2;
        TypedArray typedArray = this.f884A4TApA;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (A5SV6n2 = BPw6Q8.ASJ6gh.A5SV6n(this.f883A2egSU, resourceId)) == null) ? typedArray.getColorStateList(i) : A5SV6n2;
    }

    public final Drawable A4TApA(int i) {
        int resourceId;
        TypedArray typedArray = this.f884A4TApA;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : NOd7IU.AlLFFp.CQhlFr(this.f883A2egSU, resourceId);
    }

    public final Drawable A5SV6n(int i) {
        int resourceId;
        Drawable ASJ6gh2;
        if (!this.f884A4TApA.hasValue(i) || (resourceId = this.f884A4TApA.getResourceId(i, 0)) == 0) {
            return null;
        }
        BNL6CD A2egSU2 = BNL6CD.A2egSU();
        Context context = this.f883A2egSU;
        synchronized (A2egSU2) {
            ASJ6gh2 = A2egSU2.f663A2egSU.ASJ6gh(context, resourceId, true);
        }
        return ASJ6gh2;
    }

    public final Typeface ADYaiT(int i, int i2, D6yqiO d6yqiO) {
        int resourceId = this.f884A4TApA.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f885A5SV6n == null) {
            this.f885A5SV6n = new TypedValue();
        }
        TypedValue typedValue = this.f885A5SV6n;
        ThreadLocal threadLocal = BTvldC.B4ZgIw.f1468A2egSU;
        Context context = this.f883A2egSU;
        if (context.isRestricted()) {
            return null;
        }
        return BTvldC.B4ZgIw.A4TApA(context, resourceId, typedValue, i2, d6yqiO, true, false);
    }

    public final void ASJ6gh() {
        this.f884A4TApA.recycle();
    }

    public Resources getResources() {
        return this.f884A4TApA.getResources();
    }

    public int getType(int i) {
        return GTPRn3.getType(this.f884A4TApA, i);
    }
}
