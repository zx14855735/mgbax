package androidx.preference;

import BTvldC.A4TApA;
import DRlcZ9.B4ZgIw;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class DialogPreference extends Preference {

    /* renamed from: D6yqiO, reason: collision with root package name */
    public final CharSequence f9060D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public final String f9061D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public final Drawable f9062D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public String f9063D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public final String f9064DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public final int f9065DG07BK;

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f9125A5SV6n, i, 0);
        String string = obtainStyledAttributes.getString(9);
        string = string == null ? obtainStyledAttributes.getString(0) : string;
        this.f9060D6yqiO = string;
        if (string == null) {
            this.f9060D6yqiO = this.f9084B4ZgIw;
        }
        String string2 = obtainStyledAttributes.getString(8);
        this.f9061D8MqeW = string2 == null ? obtainStyledAttributes.getString(1) : string2;
        Drawable drawable = obtainStyledAttributes.getDrawable(6);
        this.f9062D8cQ8b = drawable == null ? obtainStyledAttributes.getDrawable(2) : drawable;
        String string3 = obtainStyledAttributes.getString(11);
        this.f9063D9tr6l = string3 == null ? obtainStyledAttributes.getString(3) : string3;
        String string4 = obtainStyledAttributes.getString(10);
        this.f9064DAk1zC = string4 == null ? obtainStyledAttributes.getString(4) : string4;
        this.f9065DG07BK = obtainStyledAttributes.getResourceId(7, obtainStyledAttributes.getResourceId(5, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void AmA8tU() {
        B4ZgIw b4ZgIw = this.f9078AlLFFp.f2134AZOQYO;
        if (b4ZgIw != null) {
            b4ZgIw.ADYaiT(this);
        }
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, A4TApA.A2egSU(context, 2130969010, R.attr.dialogPreferenceStyle));
    }
}
