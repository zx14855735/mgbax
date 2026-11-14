package AaHO0E;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DRlcZ9 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final TextView f728A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public GJee0v f729A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public GJee0v f730A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public GJee0v f731ADYaiT;
    public GJee0v AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public GJee0v f732ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public GJee0v f733ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public GJee0v f734AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final De4eam f735AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f736AZkASS = 0;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f737AaHO0E = -1;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Typeface f738AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f739AlLFFp;

    public DRlcZ9(TextView textView) {
        this.f728A2egSU = textView;
        this.f735AZOQYO = new De4eam(textView);
    }

    public static GJee0v A5SV6n(Context context, BNL6CD bnl6cd, int i) {
        ColorStateList AZOQYO2;
        synchronized (bnl6cd) {
            AZOQYO2 = bnl6cd.f663A2egSU.AZOQYO(context, i);
        }
        if (AZOQYO2 == null) {
            return null;
        }
        GJee0v gJee0v = new GJee0v();
        gJee0v.f882ADYaiT = true;
        gJee0v.f879A2egSU = AZOQYO2;
        return gJee0v;
    }

    public static void AYUAbz(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i >= 30) {
            Cd8JRx.A4TApA.A2egSU(editorInfo, text);
            return;
        }
        text.getClass();
        if (i >= 30) {
            Cd8JRx.A4TApA.A2egSU(editorInfo, text);
            return;
        }
        int i2 = editorInfo.initialSelStart;
        int i3 = editorInfo.initialSelEnd;
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 <= i3) {
            i2 = i3;
        }
        int length = text.length();
        if (i4 < 0 || i2 > length) {
            Cd8JRx.A5SV6n.A2egSU(editorInfo, null, 0, 0);
            return;
        }
        int i5 = editorInfo.inputType & 4095;
        if (i5 == 129 || i5 == 225 || i5 == 18) {
            Cd8JRx.A5SV6n.A2egSU(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            Cd8JRx.A5SV6n.A2egSU(editorInfo, text, i4, i2);
            return;
        }
        int i6 = i2 - i4;
        int i7 = i6 > 1024 ? 0 : i6;
        int i8 = 2048 - i7;
        int min = Math.min(text.length() - i2, i8 - Math.min(i4, (int) (i8 * 0.8d)));
        int min2 = Math.min(i4, i8 - min);
        int i9 = i4 - min2;
        if (Character.isLowSurrogate(text.charAt(i9))) {
            i9++;
            min2--;
        }
        if (Character.isHighSurrogate(text.charAt((i2 + min) - 1))) {
            min--;
        }
        int i10 = min2 + i7;
        Cd8JRx.A5SV6n.A2egSU(editorInfo, i7 != i6 ? TextUtils.concat(text.subSequence(i9, i9 + min2), text.subSequence(i2, min + i2)) : text.subSequence(i9, i10 + min + i9), min2, i10);
    }

    public final void A2egSU(Drawable drawable, GJee0v gJee0v) {
        if (drawable == null || gJee0v == null) {
            return;
        }
        BNL6CD.AMqCpz(drawable, gJee0v, this.f728A2egSU.getDrawableState());
    }

    public final void A4TApA() {
        GJee0v gJee0v = this.f729A4TApA;
        TextView textView = this.f728A2egSU;
        if (gJee0v != null || this.f730A5SV6n != null || this.f731ADYaiT != null || this.AMqCpz != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            A2egSU(compoundDrawables[0], this.f729A4TApA);
            A2egSU(compoundDrawables[1], this.f730A5SV6n);
            A2egSU(compoundDrawables[2], this.f731ADYaiT);
            A2egSU(compoundDrawables[3], this.AMqCpz);
        }
        if (this.f732ARc23Z == null && this.f733ASJ6gh == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        A2egSU(compoundDrawablesRelative[0], this.f732ARc23Z);
        A2egSU(compoundDrawablesRelative[2], this.f733ASJ6gh);
    }

    public final ColorStateList ADYaiT() {
        GJee0v gJee0v = this.f734AYUAbz;
        if (gJee0v != null) {
            return gJee0v.f879A2egSU;
        }
        return null;
    }

    public final PorterDuff.Mode AMqCpz() {
        GJee0v gJee0v = this.f734AYUAbz;
        if (gJee0v != null) {
            return gJee0v.f880A4TApA;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ARc23Z(android.util.AttributeSet r30, int r31) {
        /*
            Method dump skipped, instructions count: 1165
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: AaHO0E.DRlcZ9.ARc23Z(android.util.AttributeSet, int):void");
    }

    public final void ASJ6gh(Context context, int i) {
        String string;
        ColorStateList A2egSU2;
        ColorStateList A2egSU3;
        ColorStateList A2egSU4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.f8036BIYEnU);
        GYpKKt gYpKKt = new GYpKKt(context, obtainStyledAttributes);
        boolean hasValue = obtainStyledAttributes.hasValue(14);
        TextView textView = this.f728A2egSU;
        if (hasValue) {
            textView.setAllCaps(obtainStyledAttributes.getBoolean(14, false));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            if (obtainStyledAttributes.hasValue(3) && (A2egSU4 = gYpKKt.A2egSU(3)) != null) {
                textView.setTextColor(A2egSU4);
            }
            if (obtainStyledAttributes.hasValue(5) && (A2egSU3 = gYpKKt.A2egSU(5)) != null) {
                textView.setLinkTextColor(A2egSU3);
            }
            if (obtainStyledAttributes.hasValue(4) && (A2egSU2 = gYpKKt.A2egSU(4)) != null) {
                textView.setHintTextColor(A2egSU2);
            }
        }
        if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        AmA8tU(context, gYpKKt);
        if (i2 >= 26 && obtainStyledAttributes.hasValue(13) && (string = obtainStyledAttributes.getString(13)) != null) {
            DAk1zC.ADYaiT(textView, string);
        }
        gYpKKt.ASJ6gh();
        Typeface typeface = this.f738AcNBzu;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f736AZkASS);
        }
    }

    public final void AZOQYO(int i, int i2, int i3, int i4) {
        De4eam de4eam = this.f735AZOQYO;
        if (de4eam.AZkASS()) {
            DisplayMetrics displayMetrics = de4eam.f752AZkASS.getResources().getDisplayMetrics();
            de4eam.AaHO0E(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (de4eam.AYUAbz()) {
                de4eam.A2egSU();
            }
        }
    }

    public final void AZkASS(int[] iArr, int i) {
        De4eam de4eam = this.f735AZOQYO;
        if (de4eam.AZkASS()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = de4eam.f752AZkASS.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                de4eam.f748ARc23Z = De4eam.A4TApA(iArr2);
                if (!de4eam.AZOQYO()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                de4eam.f749ASJ6gh = false;
            }
            if (de4eam.AYUAbz()) {
                de4eam.A2egSU();
            }
        }
    }

    public final void AaHO0E(int i) {
        De4eam de4eam = this.f735AZOQYO;
        if (de4eam.AZkASS()) {
            if (i == 0) {
                de4eam.f744A2egSU = 0;
                de4eam.f747ADYaiT = -1.0f;
                de4eam.AMqCpz = -1.0f;
                de4eam.f746A5SV6n = -1.0f;
                de4eam.f748ARc23Z = new int[0];
                de4eam.f745A4TApA = false;
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException(ADYaiT.CtFAbx.ARc23Z(i, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = de4eam.f752AZkASS.getResources().getDisplayMetrics();
            de4eam.AaHO0E(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (de4eam.AYUAbz()) {
                de4eam.A2egSU();
            }
        }
    }

    public final void AcNBzu(ColorStateList colorStateList) {
        if (this.f734AYUAbz == null) {
            this.f734AYUAbz = new GJee0v();
        }
        GJee0v gJee0v = this.f734AYUAbz;
        gJee0v.f879A2egSU = colorStateList;
        gJee0v.f882ADYaiT = colorStateList != null;
        this.f729A4TApA = gJee0v;
        this.f730A5SV6n = gJee0v;
        this.f731ADYaiT = gJee0v;
        this.AMqCpz = gJee0v;
        this.f732ARc23Z = gJee0v;
        this.f733ASJ6gh = gJee0v;
    }

    public final void AlLFFp(PorterDuff.Mode mode) {
        if (this.f734AYUAbz == null) {
            this.f734AYUAbz = new GJee0v();
        }
        GJee0v gJee0v = this.f734AYUAbz;
        gJee0v.f880A4TApA = mode;
        gJee0v.f881A5SV6n = mode != null;
        this.f729A4TApA = gJee0v;
        this.f730A5SV6n = gJee0v;
        this.f731ADYaiT = gJee0v;
        this.AMqCpz = gJee0v;
        this.f732ARc23Z = gJee0v;
        this.f733ASJ6gh = gJee0v;
    }

    public final void AmA8tU(Context context, GYpKKt gYpKKt) {
        String string;
        int i = this.f736AZkASS;
        TypedArray typedArray = gYpKKt.f884A4TApA;
        this.f736AZkASS = typedArray.getInt(2, i);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i3 = typedArray.getInt(11, -1);
            this.f737AaHO0E = i3;
            if (i3 != -1) {
                this.f736AZkASS &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f739AlLFFp = false;
                int i4 = typedArray.getInt(1, 1);
                if (i4 == 1) {
                    this.f738AcNBzu = Typeface.SANS_SERIF;
                    return;
                } else if (i4 == 2) {
                    this.f738AcNBzu = Typeface.SERIF;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.f738AcNBzu = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f738AcNBzu = null;
        int i5 = typedArray.hasValue(12) ? 12 : 10;
        int i6 = this.f737AaHO0E;
        int i7 = this.f736AZkASS;
        if (!context.isRestricted()) {
            try {
                Typeface ADYaiT2 = gYpKKt.ADYaiT(i5, this.f736AZkASS, new D6yqiO(this, i6, i7, new WeakReference(this.f728A2egSU)));
                if (ADYaiT2 != null) {
                    if (i2 < 28 || this.f737AaHO0E == -1) {
                        this.f738AcNBzu = ADYaiT2;
                    } else {
                        this.f738AcNBzu = DG07BK.A2egSU(Typeface.create(ADYaiT2, 0), this.f737AaHO0E, (this.f736AZkASS & 2) != 0);
                    }
                }
                this.f739AlLFFp = this.f738AcNBzu == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f738AcNBzu != null || (string = typedArray.getString(i5)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f737AaHO0E == -1) {
            this.f738AcNBzu = Typeface.create(string, this.f736AZkASS);
        } else {
            this.f738AcNBzu = DG07BK.A2egSU(Typeface.create(string, 0), this.f737AaHO0E, (this.f736AZkASS & 2) != 0);
        }
    }
}
