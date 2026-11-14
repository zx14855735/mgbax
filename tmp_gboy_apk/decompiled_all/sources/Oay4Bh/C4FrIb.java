package Oay4Bh;

import ADYaiT.CtFAbx;
import AaHO0E.GYpKKt;
import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import COJEAR.FM663C;
import COJEAR.FOAO9d;
import COJEAR.FSFw2u;
import COJEAR.FdMWEC;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.MaterialToolbar;
import com.sigmob.sdk.base.blurkit.d;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class C4FrIb {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int[] f6605A2egSU = {2130968881};

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final int[] f6606A4TApA = {2130968888};

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final B4ZgIw.ARc23Z f6607A5SV6n = new B4ZgIw.ARc23Z(12);

    /* JADX WARN: Multi-variable type inference failed */
    public static void A2egSU(Window window, boolean z, Integer num) {
        FM663C fm663c;
        FM663C fm663c2;
        WindowInsetsController insetsController;
        WindowInsetsController insetsController2;
        boolean z2 = true;
        boolean z3 = num == null || num.intValue() == 0;
        int AYUAbz2 = OLy1FW.AYUAbz.AYUAbz(window.getContext(), R.attr.colorBackground, d.f13043a);
        if (z3) {
            num = Integer.valueOf(AYUAbz2);
        }
        com.bumptech.glide.A5SV6n.D8MqeW(window, !z);
        Context context = window.getContext();
        int AYUAbz3 = (!z || Build.VERSION.SDK_INT >= 23) ? z ? 0 : OLy1FW.AYUAbz.AYUAbz(context, R.attr.statusBarColor, d.f13043a) : BV3sI0.A2egSU.AMqCpz(OLy1FW.AYUAbz.AYUAbz(context, R.attr.statusBarColor, d.f13043a), r.b.d);
        Context context2 = window.getContext();
        int AYUAbz4 = (!z || Build.VERSION.SDK_INT >= 27) ? z ? 0 : OLy1FW.AYUAbz.AYUAbz(context2, R.attr.navigationBarColor, d.f13043a) : BV3sI0.A2egSU.AMqCpz(OLy1FW.AYUAbz.AYUAbz(context2, R.attr.navigationBarColor, d.f13043a), r.b.d);
        window.setStatusBarColor(AYUAbz3);
        window.setNavigationBarColor(AYUAbz4);
        boolean z4 = OLy1FW.AYUAbz.AZkASS(AYUAbz3) || (AYUAbz3 == 0 && OLy1FW.AYUAbz.AZkASS(num.intValue()));
        KCxDWD.A5SV6n a5SV6n = new KCxDWD.A5SV6n(window.getDecorView());
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            insetsController2 = window.getInsetsController();
            FdMWEC fdMWEC = new FdMWEC(insetsController2, a5SV6n);
            fdMWEC.f1752AcNBzu = window;
            fm663c = fdMWEC;
        } else {
            fm663c = i >= 26 ? new FSFw2u(window, a5SV6n) : i >= 23 ? new FOAO9d(window, a5SV6n) : new FM663C(window, a5SV6n);
        }
        fm663c.D6yqiO(z4);
        boolean AZkASS2 = OLy1FW.AYUAbz.AZkASS(AYUAbz2);
        if (!OLy1FW.AYUAbz.AZkASS(AYUAbz4) && (AYUAbz4 != 0 || !AZkASS2)) {
            z2 = false;
        }
        KCxDWD.A5SV6n a5SV6n2 = new KCxDWD.A5SV6n(window.getDecorView());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            insetsController = window.getInsetsController();
            FdMWEC fdMWEC2 = new FdMWEC(insetsController, a5SV6n2);
            fdMWEC2.f1752AcNBzu = window;
            fm663c2 = fdMWEC2;
        } else {
            fm663c2 = i2 >= 26 ? new FSFw2u(window, a5SV6n2) : i2 >= 23 ? new FOAO9d(window, a5SV6n2) : new FM663C(window, a5SV6n2);
        }
        fm663c2.D6DOie(z2);
    }

    public static void A4TApA(float f, float[] fArr) {
        if (f <= 0.5f) {
            fArr[0] = 1.0f - (f * 2.0f);
            fArr[1] = 0.0f;
        } else {
            fArr[0] = 0.0f;
            fArr[1] = (f * 2.0f) - 1.0f;
        }
    }

    public static Rect A5SV6n(View view, View view2) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i3 = i - iArr2[0];
        int i4 = i2 - iArr2[1];
        return new Rect(i3, i4, view2.getWidth() + i3, view2.getHeight() + i4);
    }

    public static void ADYaiT(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11265DAk1zC, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(2130969268, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                ARc23Z(context, f6606A4TApA, "Theme.MaterialComponents");
            }
        }
        ARc23Z(context, f6605A2egSU, "Theme.AppCompat");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r0.getResourceId(0, -1) != (-1)) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void AMqCpz(android.content.Context r5, android.util.AttributeSet r6, int[] r7, int r8, int r9, int... r10) {
        /*
            int[] r0 = com.google.android.material.R$styleable.f11265DAk1zC
            android.content.res.TypedArray r0 = r5.obtainStyledAttributes(r6, r0, r8, r9)
            r1 = 2
            r2 = 0
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 != 0) goto L12
            r0.recycle()
            return
        L12:
            int r1 = r10.length
            r3 = 1
            r4 = -1
            if (r1 != 0) goto L1f
            int r5 = r0.getResourceId(r2, r4)
            if (r5 == r4) goto L3a
        L1d:
            r2 = 1
            goto L3a
        L1f:
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r6, r7, r8, r9)
            int r6 = r10.length
            r7 = 0
        L25:
            if (r7 >= r6) goto L36
            r8 = r10[r7]
            int r8 = r5.getResourceId(r8, r4)
            if (r8 != r4) goto L33
            r5.recycle()
            goto L3a
        L33:
            int r7 = r7 + 1
            goto L25
        L36:
            r5.recycle()
            goto L1d
        L3a:
            r0.recycle()
            if (r2 == 0) goto L40
            return
        L40:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant)."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: Oay4Bh.C4FrIb.AMqCpz(android.content.Context, android.util.AttributeSet, int[], int, int, int[]):void");
    }

    public static void ARc23Z(Context context, int[] iArr, String str) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i = 0; i < iArr.length; i++) {
            if (!obtainStyledAttributes.hasValue(i)) {
                obtainStyledAttributes.recycle();
                throw new IllegalArgumentException(CtFAbx.BI9f7h("The style on this component requires your app theme to be ", str, " (or a descendant)."));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public static void ASJ6gh(View view, COJEAR cojear) {
        int paddingStart = view.getPaddingStart();
        int paddingTop = view.getPaddingTop();
        int paddingEnd = view.getPaddingEnd();
        int paddingBottom = view.getPaddingBottom();
        CQhlFr cQhlFr = new CQhlFr();
        cQhlFr.f6612A2egSU = paddingStart;
        cQhlFr.f6613A4TApA = paddingTop;
        cQhlFr.f6614A5SV6n = paddingEnd;
        cQhlFr.f6615ADYaiT = paddingBottom;
        I3HV03.A4TApA a4TApA = new I3HV03.A4TApA(cojear, 15, cQhlFr);
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        CmUvjW.B9tovu(view, a4TApA);
        if (view.isAttachedToWindow()) {
            view.requestApplyInsets();
        } else {
            view.addOnAttachStateChangeListener(new CNPG0E());
        }
    }

    public static float AYUAbz(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static ActionMenuView AZOQYO(Toolbar toolbar) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View childAt = toolbar.getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    public static ViewGroup AZkASS(PSeUZ5.ADYaiT aDYaiT) {
        View rootView = aDYaiT.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == aDYaiT || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static ImageButton AaHO0E(Toolbar toolbar) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View childAt = toolbar.getChildAt(i);
            if (childAt instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
        }
        return null;
    }

    public static ArrayList AcNBzu(MaterialToolbar materialToolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < materialToolbar.getChildCount(); i++) {
            View childAt = materialToolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static boolean AlLFFp(View view) {
        return view.getLayoutDirection() == 1;
    }

    public static TypedArray AmA8tU(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        ADYaiT(context, attributeSet, i, i2);
        AMqCpz(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    public static GYpKKt AzWtSf(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        ADYaiT(context, attributeSet, i, i2);
        AMqCpz(context, attributeSet, iArr, i, i2, iArr2);
        return new GYpKKt(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static PorterDuff.Mode B25kr6(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void wfPc() {
        char[] charArray = "²¾¼ÿ¶°¼´ÿ³¾¨ÿ¢¹´½½ÿ\u009b¿¸\u0093£¸µ¶´".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 209);
        }
        String str = new String(charArray);
        char[] charArray2 = "²½¸¿¸¥".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 209);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
